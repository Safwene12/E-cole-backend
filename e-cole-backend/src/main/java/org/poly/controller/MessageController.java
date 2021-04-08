package org.poly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.poly.entities.Etudiant;
import org.poly.entities.Message;
import org.poly.repository.MessageRepository;
import org.poly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin("*")
public class MessageController {
	@Autowired
	private MessageRepository mesRepo;
	@Autowired
	private UserRepository userRepo ;

	@RequestMapping(value = "/message/{idDest}/{idEnv}",method = RequestMethod.POST)
    public void sendMessage(@RequestBody Message message ,@PathVariable("idDest") Long idDest
    		, @PathVariable("idEnv") Long idEnv){
    	message.setUserDest(userRepo.getOne(idDest));
    	message.setUserEnv(userRepo.getOne(idEnv));
    	message.setVu(false);
    	message.setTrash(false);
    	Date date = new Date(); 
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	formatter.format(date);
    	message.setDate(date);
    	mesRepo.save(message);
    }
	@RequestMapping(value="messages/{idEnv}")
	public List<Message> getMessageByIdEnv(@PathVariable("idEnv") Long idEnv)
	{
		return mesRepo.getMessagesEnv(idEnv);
	}
	@RequestMapping(value="inbox/{idDest}")
	public List<Message> inboc(@PathVariable("idDest") Long idDest)
	{
		return mesRepo.inbox(idDest);
	}
	@RequestMapping(value="span/{idDest}")
	public int spanInbox(@PathVariable("idDest") Long idDest)
	{
		return mesRepo.spanInbox(idDest);
	}
	@RequestMapping(value="message/{idMessage}") 
	public Message getMessageById(@PathVariable("idMessage") Long idMessage)
	{
		return mesRepo.getById(idMessage);
	}
	@RequestMapping(value="message/vu/{idMessage}",method = RequestMethod.GET ) 
	public void setVu(@PathVariable("idMessage") Long idMessage)
	{
		Message mes= mesRepo.getById(idMessage);
		mes.setVu(true);
		mesRepo.save(mes);
	}
	
}
