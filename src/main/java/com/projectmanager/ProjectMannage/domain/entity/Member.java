package com.projectmanager.ProjectMannage.domain.entity;

import com.projectmanager.ProjectMannage.model.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Member
{
    private String id;
    private String secret;
    private String name;
    private String email;
    private Boolean deleted;
    private List<Project> project;
}
