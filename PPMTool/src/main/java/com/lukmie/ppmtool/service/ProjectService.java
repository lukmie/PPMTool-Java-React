package com.lukmie.ppmtool.service;

import com.lukmie.ppmtool.entity.Project;
import com.lukmie.ppmtool.exception.ProjectIdException;
import com.lukmie.ppmtool.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
