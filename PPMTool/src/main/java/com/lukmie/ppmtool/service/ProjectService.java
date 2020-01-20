package com.lukmie.ppmtool.service;

import com.lukmie.ppmtool.domain.Project;
import com.lukmie.ppmtool.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
}
