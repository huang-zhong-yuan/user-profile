package com.mcqueen.userprofile.controller;

import com.mcqueen.userprofile.domain.CompanyBo;
import com.mcqueen.userprofile.domain.CompanyInfoRequest;
import com.mcqueen.userprofile.domain.CompanyRegisterRequest;
import com.mcqueen.userprofile.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "CompanyController", description = "企业相关api")
public class CompanyController {
  
  @Autowired
  private CompanyService companyService;
  
  @ApiOperation(value = "根据companyId查询企业信息", notes = "")
  @GetMapping(value = "/v1/companies/{companyId}", 
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public CompanyBo getCompany(@PathVariable final Long companyId) {
    return companyService.getCompany(companyId);
  }
  
  @PostMapping(value = "/v1/companies",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public CompanyBo registerCompany(@RequestBody final CompanyRegisterRequest request) {
    return companyService.registerCompany(request);
  }
  
  @PutMapping(value = "/v1/companies/{companyId}",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void updateCompanyInfo(@PathVariable final int companyId, @RequestBody final CompanyInfoRequest request) {
    companyService.updateCompanyInfo(companyId, request);
  }
  
  @DeleteMapping(value = "/v1/companies/{companyId}",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public void deleteCompany(@PathVariable final int companyId) {
    companyService.deleteCompany(companyId);
  }
}
