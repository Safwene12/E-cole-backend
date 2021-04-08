package org.poly.repository;

import java.util.List;

import org.poly.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	@Query("SELECT m FROM Message m WHERE userEnv.Id = :idEnv ORDER BY m.date DESC")
	public List<Message> getMessagesEnv(Long idEnv);
	@Query("SELECT m FROM Message m WHERE userDest.Id = :idDest ORDER BY m.date DESC")
	public List<Message> inbox(Long idDest);
	@Query("SELECT m FROM Message m WHERE m.Id = :idMessage")
	public Message getById(Long idMessage);
	
	@Query("SELECT count(*) FROM Message m WHERE m.userDest.Id = :idDest AND m.vu = false")
	public int spanInbox(Long idDest);

}
