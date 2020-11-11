package org.poly.repository;

import org.poly.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface SectionRepository extends JpaRepository<Section, Long> {

}
