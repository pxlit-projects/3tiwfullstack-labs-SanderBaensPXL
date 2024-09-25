package be.pxl.services.services;

import be.pxl.services.controller.dto.EmployeeRequest;
import be.pxl.services.controller.dto.EmployeeResponse;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> findAll();

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse findById(Long id);

    List<EmployeeResponse> findByDepartment(long departmentId);

    List<EmployeeResponse> findByOrganization(Long organizationId);
}
