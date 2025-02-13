package com.Kai.app.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Kai.app.rest.model.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

}
