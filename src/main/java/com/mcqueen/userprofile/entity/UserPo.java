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
@Table(name = "user")
public class UserPo extends BasePo {
  @Column
  private int id;
  @Column(name = "company_id")
  private int companyId;
  @Id
  @Column(name = "user_name")
  private String userName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "english_name")
  private String englishName;
  @Column
  private String mobile;
  @Column(name = "id_num")
  private String idNum;
  @Column
  private int status;
  @Column(name = "create_date")
  private Date createDate;
  @Column(name = "last_updated")
  private Date lastUpdatedDate;
}
