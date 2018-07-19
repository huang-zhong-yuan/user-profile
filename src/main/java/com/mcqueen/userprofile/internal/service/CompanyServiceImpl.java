package com.mcqueen.userprofile.internal.service;

import com.mcqueen.userprofile.domain.CompanyBo;
import com.mcqueen.userprofile.domain.CompanyInfoRequest;
import com.mcqueen.userprofile.domain.CompanyRegisterRequest;
import com.mcqueen.userprofile.entity.CompanyPo;
import com.mcqueen.userprofile.enums.UserStatus;
import com.mcqueen.userprofile.mapper.CompanyMapper;
import com.mcqueen.userprofile.repo.CompanyRepo;
import com.mcqueen.userprofile.service.CompanyService;
import com.mcqueen.userprofile.util.DozerBeanMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService {
  
  @Autowired
  private CompanyRepo companyRepo;
  
  @Autowired
  private CompanyMapper companyMapper;
  
  @Override
  public CompanyBo getCompany(Long companyId) {
    CompanyPo companyPo = companyRepo.getCompanyById(companyId);
    return DozerBeanMapperUtil.map(companyPo, CompanyBo.class);
  }

  @Override
  public CompanyBo registerCompany(CompanyRegisterRequest request) {
    CompanyPo companyPo = companyMapper.findByBusinessKey(request.getRegisterNum(), CompanyPo.class);
    if (Objects.isNull(companyPo)) {
      companyPo = new CompanyPo();
      companyPo.setCompanyName(request.getCompanyName());
      companyPo.setRegisterNum(request.getRegisterNum());
      companyMapper.insert(companyPo);
      companyPo = companyMapper.findByBusinessKey(request.getRegisterNum(), CompanyPo.class);
    }
    return DozerBeanMapperUtil.map(companyPo, CompanyBo.class);
  }

  @Override
  public void updateCompanyInfo(int companyId, CompanyInfoRequest request) {
    CompanyPo companyPo = companyMapper.findById(companyId, CompanyPo.class);
    DozerBeanMapperUtil.copy(request, companyPo);
    companyMapper.update(companyPo);
  }

  @Override
  public void deleteCompany(int companyId) {
    CompanyPo companyPo = companyMapper.findById(companyId, CompanyPo.class);
    companyPo.setStatus(UserStatus.DELETED.ordinal());
    companyMapper.update(companyPo);
  }
}
