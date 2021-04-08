package org.poly.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.poly.entities.Etudiant;
import org.poly.repository.EtudiantRepository;
import org.poly.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fileConfig.UploadFileResponse;

@RestController
@CrossOrigin("*")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private EtudiantRepository etudRepo;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file,"");

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName)
            .toUriString();
    
        return new UploadFileResponse(fileName, fileDownloadUri,
            file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List< UploadFileResponse > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files ) {
          	
    	return Arrays.asList(files)
            .stream()
            .map(file -> uploadFile(file))
            .collect(Collectors.toList());
    }
    @PostMapping("/uploadFile/{idUser}")
    public UploadFileResponse uploadImgUser(@RequestParam("file") MultipartFile file,@PathVariable("idUser") Long idUser) {
    	Etudiant e = etudRepo.getOne(idUser);
   
    	String fileName = fileStorageService.storeFile(file,e.getUsername());
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName)
            .toUriString();
       
        e.setPhoto(fileName);
        etudRepo.save(e);
        return new UploadFileResponse(fileName, fileDownloadUri,
            file.getContentType(), file.getSize());
    }
}