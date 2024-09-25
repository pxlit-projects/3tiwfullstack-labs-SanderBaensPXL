package be.pxl.services.controller;

import be.pxl.services.controller.dto.EmployeeRequest;
import be.pxl.services.controller.dto.EmployeeResponse;
import be.pxl.services.services.EmployeeService;
import be.pxl.services.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.addEmployee(employeeRequest);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getEmployees(){
        return new ResponseEntity(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "department/{departmentId}")
    public ResponseEntity getEmployeesByDepartment(@PathVariable Long departmentId) {
        return new ResponseEntity(employeeService.findByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping(path = "organization/{organizationId}")
    public ResponseEntity getEmployeesByOrganization(@PathVariable Long organizationId) {
        return new ResponseEntity(employeeService.findByOrganization(organizationId), HttpStatus.OK);
    }
}
