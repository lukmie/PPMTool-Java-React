package com.lukmie.ppmtool.controller;

import com.lukmie.ppmtool.entity.Project;
import com.lukmie.ppmtool.service.MapValidationErrorService;
import com.lukmie.ppmtool.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping
    public ResponseEntity<?> saveProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
        if (Objects.nonNull(errorMap)) return errorMap;

        Project project1 = projectService.saveProject(project);
        return new ResponseEntity<>(project1, HttpStatus.CREATED);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> findProjectByProjectIdentifier(@PathVariable String projectIdentifier) {
        Project project = projectService.findProjectByProjectIdentifier(projectIdentifier);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

}
