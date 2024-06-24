package com.example.departmentservice.service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = Department.builder()
                .departmentName(departmentDto.getDepartmentName())
                .departmentDescription(departmentDto.getDepartmentDescription())
                .departmentCode(departmentDto.getDepartmentCode())
                .build();

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentDto.builder()
                .departmentName(savedDepartment.getDepartmentName())
                .departmentDescription(savedDepartment.getDepartmentDescription())
                .departmentCode(savedDepartment.getDepartmentCode())
                .build();

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if(department != null) {
            DepartmentDto departmentDto = DepartmentDto.builder()
                    .departmentName(department.getDepartmentName())
                    .departmentDescription(department.getDepartmentDescription())
                    .departmentCode(department.getDepartmentCode())
                    .build();
            return departmentDto;
        }

        return null;
    }
}
