package com.mcqueen.userprofile.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserProfileResponse {
  private Long id;
  private String userName;
  private String lastName;
  private String firstName;
  private String englishName;
  private String mobile;
  private String idNum;
  private int status;
  private Date userCreateDate;
  private Date userLastUpdatedDate;
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
