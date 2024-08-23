package com.example.makersharks.repository;

import com.example.makersharks.entities.SupplierDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierDetails, Long> {
    Page<SupplierDetails> findByLocationAndNatureOfBusinessAndManufacturingProcesses(
            String location,
            SupplierDetails.NatureOfBusiness natureOfBusiness,
            SupplierDetails.ManufacturingProcesses manufacturingProcesses,
            Pageable pageable);
}
