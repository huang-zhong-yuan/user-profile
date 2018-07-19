package com.mcqueen.userprofile.domain;

import lombok.Data;

@Data
public class CompanyInfoRequest {
  private String companyName;
  private String registeredAddress;
  private String operationAddress;
  private String phone;
  private String email;
}
