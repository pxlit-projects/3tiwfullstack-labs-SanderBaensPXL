package be.pxl.services.controller;

import be.pxl.services.controller.dto.OrganizationResponse;
import be.pxl.services.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final IOrganizationService organizationService;

    @GetMapping(path = "{id}")
    public ResponseEntity<OrganizationResponse> findById(@PathVariable Long id) {
        return new ResponseEntity<>(organizationService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "{id}/with-departments")
    public ResponseEntity<OrganizationResponse> findByIdWithDepartments(@PathVariable Long id) {
        return new ResponseEntity<>(organizationService.findByIdWithDepartments(id), HttpStatus.OK);
    }

    @GetMapping(path = "{id}/with-departments-and-employees")
    public ResponseEntity<OrganizationResponse> findByIdWithDepartmentsAndEmployees(@PathVariable Long id) {
        return new ResponseEntity<>(organizationService.findByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }

    @GetMapping(path = "{id}/with-employees")
    public ResponseEntity<OrganizationResponse> findByIdWithEmployees(@PathVariable Long id) {
        return new ResponseEntity<>(organizationService.findByIdWithEmployees(id), HttpStatus.OK);
    }
}
