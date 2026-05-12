package com.projectmanager.ProjectMannage.infrasctructure.dto.dto;

import com.projectmanager.ProjectMannage.domain.entity.Project;
import com.projectmanager.ProjectMannage.model.ProjectStatus;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ProjectDTO{

        private final String id;
        private final String name;
        private final String description;
        private final LocalDate initialDate;
        private final LocalDate finalDate;
        private final ProjectStatus status;

        public static ProjectDTO create(Project project){

            return new ProjectDTO(
                    project.getId(),
                    project.getName(),
                    project.getDescription(),
                    project.getInitialDate(),
                    project.getFinalDate(),
                    project.getStatus()
            );

    }


}
