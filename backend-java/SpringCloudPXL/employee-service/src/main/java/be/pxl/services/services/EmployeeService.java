package be.pxl.services.services;

import be.pxl.services.controller.dto.EmployeeRequest;
import be.pxl.services.controller.dto.EmployeeResponse;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .age(employee.getAge())
                .name(employee.getName())
                .position(employee.getPosition())
                .departmentId(employee.getDepartmentId())
                .organizationId(employee.getOrganizationId())
                .build();
    }

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .age(employeeRequest.getAge())
                .name(employeeRequest.getName())
                .position(employeeRequest.getPosition())
                .departmentId(employeeRequest.getDepartmentId())
                .organizationId(employeeRequest.getOrganizationId())
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponse findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return mapToEmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }

    @Override
    public List<EmployeeResponse> findByDepartment(long departmentId) {
        List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }

    @Override
    public List<EmployeeResponse> findByOrganization(Long organizationId) {
        List<Employee> employees = employeeRepository.findAllByOrganizationId(organizationId);
        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }
}
