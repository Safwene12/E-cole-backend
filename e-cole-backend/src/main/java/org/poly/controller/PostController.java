package org.poly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.poly.entities.Posts;
import org.poly.repository.PostRepository;
import org.poly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import communication.SectionCom;

@RestController
@CrossOrigin("*")
public class PostController {

	@Autowired
	private PostRepository postRepo;
	@Autowired
	private UserRepository userRepo;
	@RequestMapping(value = "/addPost/{id}",method = RequestMethod.POST)
    public void addPost(@RequestBody Posts post , @PathVariable("id") Long id){
		//System.out.print(userRepo.getOne(id).toString()+"************");
        post.setUserPo(userRepo.getOne(id));
        Date date = new Date(); 
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM HH:mm");
    	formatter.format(date);
    	post.setDate(date);
        postRepo.save(post);
    }
	@GetMapping("/posts/{idUser}") 
	public List<Posts> getByIdUser(@PathVariable("idUser") Long idUser) {
		return postRepo.getByIdUser(idUser);
	}
	@GetMapping("/posts")
	public List<Posts> getAllPosts()
	{
		return postRepo.getAll();
	}
	@GetMapping("/getPost/{idUser}") 
	public Posts getPostById(@PathVariable("idUser") Long idUser) { 
		return postRepo.getById(idUser);
	}
	
}
