package com.mcqueen.userprofile.entity;

import com.mcqueen.userprofile.mybatis.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode
@Table(name = "user_profile")
public class UserProfilePo extends BasePo {
  @Id
  @Column(name = "user_id")
  private int userId;
  @Column
  private Date birthday;
  @Column
  private String country;
  @Column
  private String nation;
  @Column
  private int gender;
  @Column
  private int marriage;
  @Column(name = "company_phone")
  private String companyPhone;
  @Column(name = "company_email")
  private String companyEmail;
  @Column(name = "private_email")
  private String privateEmail;
  @Column(name = "create_date")
  private Date createDate;
  @Column(name = "last_updated")
  private Date lastUpdatedDate;
}
