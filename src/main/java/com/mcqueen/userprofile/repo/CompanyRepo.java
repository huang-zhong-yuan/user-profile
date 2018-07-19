package com.mcqueen.userprofile.repo;

import com.mcqueen.userprofile.entity.CompanyPo;
import com.mcqueen.userprofile.exception.UserProfileException;
import com.mcqueen.userprofile.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class CompanyRepo {
  
  @Autowired
  private CompanyMapper companyMapper;

  /**
   * 根据companyId查询企业
   * @param companyId
   * @return
   */
  public CompanyPo getCompanyById(Long companyId) {
    CompanyPo companyPo = companyMapper.findById(companyId, CompanyPo.class);
    if (Objects.isNull(companyPo)) {
      throw new UserProfileException("No company user exists with id: " + companyId);
    }
    return companyPo;
  }
}
