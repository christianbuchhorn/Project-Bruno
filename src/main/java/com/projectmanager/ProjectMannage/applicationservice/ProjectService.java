package com.projectmanager.ProjectMannage.applicationservice;

import com.projectmanager.ProjectMannage.domain.entity.Project;
import com.projectmanager.ProjectMannage.infrasctructure.dto.dto.SaveProjectDataDTO;
import com.projectmanager.ProjectMannage.model.ProjectStatus;
import com.projectmanager.ProjectMannage.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject (SaveProjectDataDTO saveProjectDataDTO) {
    Project project = Project
            .builder()
            .name(saveProjectDataDTO.getName())
            .description(saveProjectDataDTO.getDescription())
            .initialDate(saveProjectDataDTO.getInitialDate())
            .finalDate(saveProjectDataDTO.getFinalDate())
            .status(ProjectStatus.PEDDING)
            .build();

        projectRepository.save(project);
        return project;
    }
}



