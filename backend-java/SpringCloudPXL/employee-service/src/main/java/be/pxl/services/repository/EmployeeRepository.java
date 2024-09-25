package be.pxl.services.repository;

import be.pxl.services.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDepartmentId(long departmentId);
    List<Employee> findAllByOrganizationId(long organizationId);
}
