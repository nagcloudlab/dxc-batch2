package com.example.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
public class EmployeeId {

    private int empId;
    private String depId;

}
