package com.sandoval.ada.apirest.entities;

import jakarta.persistence.*;

@Entity
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCompany;

  @Column(unique = true, nullable = false)
  private String codigoCompany;

  @Column(nullable = false)
  private String nameCompany;

  private String descriptionCompany;


  public Long getIdCompany() {
    return idCompany;
  }

  public void setIdCompany(Long idCompany) {
    this.idCompany = idCompany;
  }

  public String getCodigoCompany() {
    return codigoCompany;
  }

  public void setCodigoCompany(String codigoCompany) {
    this.codigoCompany = codigoCompany;
  }

  public String getNameCompany() {
    return nameCompany;
  }

  public void setNameCompany(String nameCompany) {
    this.nameCompany = nameCompany;
  }

  public String getDescriptionCompany() {
    return descriptionCompany;
  }

  public void setDescriptionCompany(String descriptionCompany) {
    this.descriptionCompany = descriptionCompany;
  }
}