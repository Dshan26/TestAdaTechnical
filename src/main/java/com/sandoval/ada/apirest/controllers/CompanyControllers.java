package com.sandoval.ada.apirest.controllers;

import com.sandoval.ada.apirest.entities.Company;
import com.sandoval.ada.apirest.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyControllers {

  @Autowired
  private CompanyService companyService;


  @GetMapping
  public ResponseEntity<List<Company>> findAll() {
    return ResponseEntity.ok(companyService.getFindAll());
  }

  @PostMapping
  public ResponseEntity<Company> save(@RequestBody Company company) {
    return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(company));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Company> update(@RequestBody Company company, @PathVariable Long id) {
    return companyService.update(company, id).map(user -> ResponseEntity
            .status(HttpStatus.CREATED)
            .body(user)).orElseGet(() -> ResponseEntity.notFound().build());

  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> findById(@PathVariable Long id) {
    return companyService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

  }
  @GetMapping("/company/{companyname}")
  public ResponseEntity<Company> findByCompanyName(@PathVariable String companyname) {
    return companyService.findByCompanyName(companyname).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    companyService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/distinct")
  public ResponseEntity<List<Company>> getDistinctCompanies() {
    List<Company> distinctCompanies = companyService.findDistinctCompanies();
    return ResponseEntity.ok(distinctCompanies);
  }
}
