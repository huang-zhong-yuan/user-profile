package com.mcqueen.userprofile.service;

import com.mcqueen.userprofile.domain.CompanyBo;
import com.mcqueen.userprofile.domain.CompanyInfoRequest;
import com.mcqueen.userprofile.domain.CompanyRegisterRequest;

public interface CompanyService {
  /**
   * 查询企业
   * @param companyId
   * @return
   */
  CompanyBo getCompany(Long companyId);

  /**
   * 注册企业
   * @param request
   * @return
   */
  CompanyBo registerCompany(CompanyRegisterRequest request);

  /**
   * 更新企业信息
   * @param companyId
   * @param request
   */
  void updateCompanyInfo(int companyId, CompanyInfoRequest request);

  /**
   * 删除企业
   * @param companyId
   */
  void deleteCompany(int companyId);
}
