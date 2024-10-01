package be.pxl.services.services;

import be.pxl.services.controller.dto.DepartmentRequest;
import be.pxl.services.controller.dto.DepartmentResponse;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService{

    private final DepartmentRepository departmentRepository;

    private DepartmentResponse mapToResponse(Department department) {
        return DepartmentResponse.builder()
                .employees(department.getEmployees())
                .name(department.getName())
                .organizationId(department.getOrganizationId())
                .position(department.getPosition())
                .build();
    }

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .name(departmentRequest.getName())
                .organizationId(departmentRequest.getOrganizationId())
                .position(departmentRequest.getPosition())
                .build();
        departmentRepository.save(department);
    }

    @Override
    public DepartmentResponse findById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return mapToResponse(department);
    }

    @Override
    public List<DepartmentResponse> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<DepartmentResponse> findByOrganization(Long organizationId) {
        List<Department> departments = departmentRepository.findAllByOrganizationId(organizationId);
        return departments.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId) {
        List<Employee> employees = new ArrayList<>();
        List<Department> departments = departmentRepository.findAllByOrganizationId(organizationId);
        for(Department department : departments) {
            department.setEmployees(employees);
        }
        return departments.stream().map(this::mapToResponse).toList();
    }
}
