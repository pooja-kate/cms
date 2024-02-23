package com.altimetrik.cms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.sql.Date;
// Annotations Are VVVVVVVIIIMMMMMMPPPPPPPPPPPP
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Customer {
    @Id
//    @NotNull(message = "Customer Id should not be null value")
    private int customerId;
    @NotBlank(message = "Customer name should not be blank ")
    private String customerName;
    @Past(message = "Date Of Birth should be past date")
    private Date date;
    private boolean isIndian;
//    private String name;
}
