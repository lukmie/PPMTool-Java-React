package com.lukmie.ppmtool.controller;

import com.lukmie.ppmtool.domain.Project;
import com.lukmie.ppmtool.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

}
