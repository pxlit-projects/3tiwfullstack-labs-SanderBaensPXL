package be.pxl.services.controller;

import be.pxl.services.controller.dto.DepartmentRequest;
import be.pxl.services.controller.dto.DepartmentResponse;
import be.pxl.services.services.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.addDepartment(departmentRequest);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<DepartmentResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getDepartments(){
        return new ResponseEntity(departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "organization/{organizationId}")
    public ResponseEntity getDepartmentsByOrganization(@PathVariable Long organizationId) {
        return new ResponseEntity(departmentService.findByOrganization(organizationId), HttpStatus.OK);
    }

    @GetMapping(path = "organization/{organizationId}/with-employees")
    public ResponseEntity getDepartmentsByOrganizationWithEmployees(@PathVariable Long organizationId) {
        return new ResponseEntity(departmentService.findByOrganizationWithEmployees(organizationId), HttpStatus.OK);
    }
}
