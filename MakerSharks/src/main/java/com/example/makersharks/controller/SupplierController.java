package com.example.makersharks.controller;

import com.example.makersharks.entities.SupplierDetails;
import com.example.makersharks.repository.SupplierRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @PostMapping("save")
    public ResponseEntity<SupplierDetails> saveSupplier(@Valid @RequestBody SupplierDetails supplierDetails){
        SupplierDetails savedSupplier = supplierRepository.save(supplierDetails);
        return ResponseEntity.ok(savedSupplier);
    }

    @GetMapping("suppliers-info")
    public ResponseEntity<Page<SupplierDetails>> getSuppliers(
            @RequestParam String location,
            @RequestParam SupplierDetails.NatureOfBusiness natureOfBusiness,
            @RequestParam SupplierDetails.ManufacturingProcesses manufacturingProcesses,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<SupplierDetails> suppliersPage = supplierRepository
                .findByLocationAndNatureOfBusinessAndManufacturingProcesses(location, natureOfBusiness, manufacturingProcesses, pageable);

        return ResponseEntity.ok(suppliersPage);
    }

    @GetMapping("getAllData")
    public ResponseEntity<List<SupplierDetails>> getAllSupplierData(){
        List<SupplierDetails> suppliers = supplierRepository.findAll();
        return ResponseEntity.ok(suppliers);
    }
}
