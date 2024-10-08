package be.pxl.services.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private long organizationId;
    private long departmentId;
    private String name;
    private int age;
    private String position;
}
