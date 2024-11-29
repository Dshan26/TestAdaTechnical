package com.sandoval.ada.apirest.services;

import com.sandoval.ada.apirest.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

  List<Company> getFindAll();

  Optional<Company> findById(Long id);

  Optional<Company> findByCompanyName(String companyName);

  Company save(Company users);

  Optional<Company> update(Company users,Long id);

  void deleteById(Long id);

  List<Company> findDistinctCompanies();
}
