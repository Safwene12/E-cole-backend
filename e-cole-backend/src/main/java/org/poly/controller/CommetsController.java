package org.poly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.poly.entities.Commentaire;
import org.poly.entities.Posts;
import org.poly.repository.CommentRepository;
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

@RestController
@CrossOrigin("*")
public class CommetsController {

	@Autowired
	UserRepository userRepo;
	@Autowired
	PostRepository postRepo;
	@Autowired
	CommentRepository commentRepo;
	@RequestMapping(value = "/addComment/{idPost}/{idUser}",method = RequestMethod.POST)
	public void saveComment(@RequestBody Commentaire comment,@PathVariable("idPost") Long idPost ,@PathVariable("idUser") Long idUser   )
	{
		comment.setUserCom(userRepo.getOne(idUser));
		comment.setPost(postRepo.getById(idPost));
		Date date = new Date(); 
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM HH:mm");
    	formatter.format(date);
    	comment.setDate(date);
    	commentRepo.save(comment);
	}
	@GetMapping("/comments/{idPost}")
	public List<Commentaire> getCommentsByPost(@PathVariable ("idPost") Long idPost)
	{
		return commentRepo.getCommentsByPost(idPost);
	}
}
