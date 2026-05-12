package com.projectmanager.ProjectMannage.domain.entity;

import com.projectmanager.ProjectMannage.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {

    private String id;
    private String tittle;
    private String description;
    private Integer numberOfDays;
    private TaskStatus status;
    private Project project;
    private Member assignMember;

}
