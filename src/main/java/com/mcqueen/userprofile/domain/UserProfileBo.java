package com.mcqueen.userprofile.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserProfileBo {
  private int userId;
  private Date birthday;
  private String country;
  private String nation;
  private int gender;
  private int marriage;
  private String companyPhone;
  private String companyEmail;
  private String privateEmail;
  private Date createDate;
  private Date lastUpdatedDate;
}
