package com.mcqueen.userprofile.entity;

import com.mcqueen.userprofile.annotations.BusinessKey;
import com.mcqueen.userprofile.mybatis.entity.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode
@Table(name = "company")
public class CompanyPo extends BasePo {
  @Id
  @Column
  private int id;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "registered_address")
  private String registeredAddress;
  @Column(name = "operation_address")
  private String operationAddress;
  @Column
  private String phone;
  @BusinessKey
  @Column(name = "register_num")
  private String registerNum;
  @Column
  private String email;
  @Column
  private int status;
  @Column(name = "create_date")
  private Date createDate;
  @Column(name = "last_updated")
  private Date lastUpdatedDate;
  
}
