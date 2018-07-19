package com.mcqueen.userprofile.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class UserBo {
  private int id;
  @NotEmpty(message = "{user.companyId.notempty}")
  private int companyId;
  @NotEmpty(message = "{user.usernamme.notempty}")
  private String userName;
  private String lastName;
  private String firstName;
  private String englishName;
  private String mobile;
  private String idNum;
  private int status;
  private Date createDate;
  private Date lastUpdatedDate;
}
