package be.pxl.services.services;

import be.pxl.services.controller.dto.DepartmentRequest;
import be.pxl.services.controller.dto.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {
    void addDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse findById(Long id);

    List<DepartmentResponse> findAll();

    List<DepartmentResponse> findByOrganization(Long organizationId);

    List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId);
}
