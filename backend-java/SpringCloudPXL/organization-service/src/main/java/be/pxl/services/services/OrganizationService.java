package be.pxl.services.services;

import be.pxl.services.controller.dto.OrganizationResponse;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService{

    private final OrganizationRepository organizationRepository;

    private OrganizationResponse mapToResponse(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(organization.getDepartments())
                .employees(organization.getEmployees())
                .build();
    }

    @Override
    public OrganizationResponse findById(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        return mapToResponse(organization);
    }

    @Override
    public OrganizationResponse findByIdWithDepartments(Long id) {
        return null;
    }

    @Override
    public OrganizationResponse findByIdWithDepartmentsAndEmployees(Long id) {
        return null;
    }

    @Override
    public OrganizationResponse findByIdWithEmployees(Long id) {
        return null;
    }
}
