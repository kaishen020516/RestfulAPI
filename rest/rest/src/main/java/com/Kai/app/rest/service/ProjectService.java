package com.Kai.app.rest.service;

import com.Kai.app.rest.model.Project;
import com.Kai.app.rest.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(String projectID) {
        return projectRepository.findById(projectID);
    }

    public Optional<Project> updateProject(String projectId, Project project) {
        Optional<Project> existingProject = projectRepository.findById(projectId);
        if (existingProject.isPresent()) {
            Project currentProject = existingProject.get();
            currentProject.setProjectName(project.getProjectName());

            return Optional.of(projectRepository.save(currentProject));
        }
        return Optional.empty();
    }

    public void deleteProject(String projectID) {
        projectRepository.deleteById(projectID);
    }
}
