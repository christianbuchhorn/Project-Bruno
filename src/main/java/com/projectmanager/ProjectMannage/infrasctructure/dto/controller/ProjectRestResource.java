package com.projectmanager.ProjectMannage.infrasctructure.dto.controller;
import com.projectmanager.ProjectMannage.applicationservice.ProjectService;
import com.projectmanager.ProjectMannage.domain.entity.Project;
import com.projectmanager.ProjectMannage.infrasctructure.dto.dto.ProjectDTO;
import com.projectmanager.ProjectMannage.infrasctructure.dto.dto.SaveProjectDataDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.projectmanager.ProjectMannage.infrasctructure.dto.Constant.RestConstants.PATH_PROJECTS;

@RestController
@RequestMapping(PATH_PROJECTS)
@AllArgsConstructor
public class ProjectRestResource {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody SaveProjectDataDTO saveProjectDataDTO)
    {
        Project project = projectService.createProject(saveProjectDataDTO);
        return ResponseEntity.created(URI.create("PATH_PROJECTS"+project.getId())).body(ProjectDTO.create(project));
    }
}
