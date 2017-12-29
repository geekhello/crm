package com.crm.web.action;

import com.crm.domain.SaleVisit;
import com.crm.pojo.SaleVisitModel;
import com.crm.pojo.SysModel;
import com.crm.service.CstCustomerService;
import com.crm.service.SystemService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport
  implements ModelDriven<SaleVisitModel>
{
  private CstCustomerService customerService;
  private SystemService systemService;
  private SaleVisitModel saleVisitModel = new SaleVisitModel();

  public SaleVisitModel getModel() {
    return this.saleVisitModel;
  }

  public SystemService getSystemService()
  {
    return this.systemService;
  }
  public void setSystemService(SystemService systemService) {
    this.systemService = systemService;
  }

  public CstCustomerService getCustomerService() {
    return this.customerService;
  }
  public void setCustomerService(CstCustomerService customerService) {
    this.customerService = customerService;
  }

  public String listSaleVisit()
  {
    this.saleVisitModel.setSaleVisits(this.customerService.findAllSaleVisit());
    return "listSaleVisit";
  }

  public String addUISaleVisit()
  {
    SysModel sysModel = null;

    this.saleVisitModel.setCstCustomers(this.customerService.findAllCustomer());

    this.saleVisitModel.setSysUsers(this.systemService.findAllSysUser(sysModel));
    return "addUISaleVisit";
  }

  public String addSaleVisit()
  {
    SaleVisit saleVisit = this.saleVisitModel.getSaleVisit();
    this.customerService.saveSaleVisit(this.saleVisitModel.getSaleVisit());
    return "addSaleVisit";
  }
}