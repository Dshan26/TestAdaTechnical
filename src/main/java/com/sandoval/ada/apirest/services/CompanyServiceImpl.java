package com.sandoval.ada.apirest.services;


import com.sandoval.ada.apirest.entities.Company;
import com.sandoval.ada.apirest.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

  private CompanyRepository companyRepository;

  @Override
  @Transactional(readOnly = true)
  public List<Company> getFindAll() {
    return companyRepository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Company> findById(Long id) {
    return companyRepository.findById(id);
  }

  @Override
  public Optional<Company> findByCompanyName(String companyName) {
    return companyRepository.findByCompanyname(companyName);
  }


  @Transactional
  @Override
  public Company save(Company users) {
    return companyRepository.save(users);
  }

  @Override
  @Transactional
  public Optional<Company> update(Company company, Long id) {

    Optional<Company> userOptional = this.findById(id);

    return userOptional.map(companyDB -> {
      companyDB.setCodigoCompany(company.getCodigoCompany());
      companyDB.setNameCompany(company.getNameCompany());

      return Optional.of(companyRepository.save(companyDB));
    }).orElseGet(Optional::empty);

  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    companyRepository.deleteById(id);

  }

  //Punto 3 examen semi senior creando el metodo para extraer las empresas distintas
  @Override
  public List<Company> findDistinctCompanies() {
    return companyRepository.findDistinctCompanies();
  }
}
