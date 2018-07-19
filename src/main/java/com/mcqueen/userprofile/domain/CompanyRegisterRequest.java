package com.mcqueen.userprofile.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class CompanyRegisterRequest {
  private String companyName;
  @NotEmpty(message = "{company.register.num.notempty}")
  private String registerNum;
}
