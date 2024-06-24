package com.example.departmentservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
