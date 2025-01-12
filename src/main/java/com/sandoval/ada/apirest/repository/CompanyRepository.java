package com.sandoval.ada.apirest.repository;

import com.sandoval.ada.apirest.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
  Optional<Company> findByCompanyname(String username);

  //seleccionamos todos los nombres de las empresas distintas con un query
  @Query("SELECT c FROM Company c WHERE c.codigoCompany IN (" +
          "SELECT DISTINCT codigoCompany FROM Company)")
  List<Company> findDistinctCompanies();
}
