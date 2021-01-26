package org.poly.repository;

import java.util.List;

import org.poly.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostRepository extends JpaRepository<Posts, Long> {

	@Query("SELECT m FROM Posts m WHERE m.userPo.Id = :idUser")
	public List<Posts> getByIdUser(Long idUser);
	@Query("SELECT m FROM Posts m ORDER BY m.date DESC")
	public List<Posts> getAll();
	@Query("SELECT m FROM Posts m WHERE m.Id = :id")
	public Posts getById(Long id);
}
