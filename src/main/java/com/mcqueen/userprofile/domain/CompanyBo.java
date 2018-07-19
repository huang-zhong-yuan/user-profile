package com.mcqueen.userprofile.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CompanyBo {
  private int id;
  private String companyName;
  private String registeredAddress;
  private String operationAddress;
  private String phone;
  private String registerNum;
  private String email;
  private int status;
  private Date createDate;
  private Date lastUpdatedDate;
}
