package com.example.makersharks.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier_details")
public class SupplierDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;

    @NotNull( message = "The company name should not be blank")
    private String companyName;

    @NotNull( message = "The website url should not be blank")
    private String website;

    @NotNull( message = "The location should not be blank")
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "nature_of_business")
    @NotNull( message = "The nature of business should not be blank")
    private NatureOfBusiness natureOfBusiness;

    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturing_processes")
    @NotNull( message = "The manufactoring process should not be blank")
    private ManufacturingProcesses manufacturingProcesses;

    public enum NatureOfBusiness {
        SMALL_SCALE,
        MEDIUM_SCALE,
        LARGE_SCALE
    }

    public enum ManufacturingProcesses {
        MOULDING,
        THREE_D_PRINTING,
        CASTING,
        COATING
    }
}
