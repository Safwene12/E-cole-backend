package org.poly.repository;

import java.util.List;

import org.poly.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentRepository extends JpaRepository<Commentaire, Long> {

	@Query("SELECT c FROM Commentaire c WHERE c.post.Id = :idPost ORDER BY c.date DESC")
	public List<Commentaire> getCommentsByPost(Long idPost);
}
