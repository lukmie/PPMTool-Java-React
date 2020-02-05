package com.lukmie.ppmtool.service;

import com.lukmie.ppmtool.entity.Project;
import com.lukmie.ppmtool.exception.ProjectIdException;
import com.lukmie.ppmtool.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exist.");
        }
    }

    public Project findProjectByProjectIdentifier(String projectIdentifier) {
        return projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase())
                .orElseThrow(() -> new ProjectIdException("Project ID " + projectIdentifier + " does not exist."));
    }

    public Iterable<Project> getAll() {
        return projectRepository.findAll();
    }

    public void deleteByIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase())
                .orElseThrow(() -> new EntityNotFoundException("Project not found."));
        projectRepository.deleteById(project.getId());
    }

    public Project updateByIdentifier(Project project) {
        Project projectToUpdate = projectRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase())
                .orElseThrow(() -> new EntityNotFoundException("Project not found."));
        projectToUpdate.setProjectName(project.getProjectName());
        projectToUpdate.setProjectIdentifier(project.getProjectIdentifier());
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setStartDate(project.getStartDate());
        projectToUpdate.setEndDate(project.getEndDate());
        return projectRepository.save(projectToUpdate);
    }
}
