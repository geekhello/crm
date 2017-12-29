package com.crm.web.action;

import com.crm.domain.CstCustomer;
import com.crm.domain.CstLinkMan;
import com.crm.domain.LinkManModel;
import com.crm.service.CstCustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LinkManAction extends ActionSupport
  implements ModelDriven<LinkManModel>
{
  private LinkManModel linkManModel = new LinkManModel();
  CstCustomerService customerService;

  public CstCustomerService getCustomerService()
  {
    return this.customerService;
  }
  public void setCustomerService(CstCustomerService customerService) {
    this.customerService = customerService;
  }

  public LinkManModel getModel() {
    return this.linkManModel;
  }

  public String listLinkManByName()
  {
    String lkmName = this.linkManModel.getLkmName();

    if ((lkmName != null) || ("".equals(lkmName))) {
      List linkMans = this.customerService.findLinkManByName(lkmName);
      this.linkManModel.setLinkmans(linkMans);
    }
    return "listLinkManByName";
  }

  public String deleteLinkMan()
  {
    Long lkmId = this.linkManModel.getLkmId();
    this.customerService.deleteLinkMan(lkmId);
    return "deleteLinkMan";
  }

  public String editLinkMan()
  {
    Long lkmId = this.linkManModel.getLkmId();
    CstLinkMan linkMan = this.linkManModel.getLinkMan();
    Long custId = this.linkManModel.getCustId();

    System.out.println(lkmId);
    System.out.println(linkMan);
    System.out.println(custId);
    CstCustomer customer = this.customerService.findCustomerById(custId);
    linkMan.setCustomer(customer);
    linkMan.setLkmId(lkmId);
    this.customerService.editLinkMan(linkMan);
    return "editLinkMan";
  }

  public String editLinkManUI()
  {
    CstLinkMan linkMan = this.linkManModel.getLinkMan();
    Long lkmId = this.linkManModel.getLkmId();
    linkMan = this.customerService.findLinkMan(lkmId);
    List customers = this.customerService.findAllCustomer();
    this.linkManModel.setLinkMan(linkMan);
    this.linkManModel.setCustomers(customers);
    return "editLinkManUI";
  }

  public String addLinkMan()
  {
    CstLinkMan linkMan = this.linkManModel.getLinkMan();

    CstCustomer customer = this.customerService.findCustomerById(this.linkManModel.getCustId());
    linkMan.setCustomer(customer);

    this.customerService.saveLinkMan(linkMan);
    return "addLinkMan";
  }

  public String addLinkManUI()
  {
    List list = new ArrayList(0);
    list = this.customerService.findAllCustomer();
    this.linkManModel.setCustomers(list);
    return "addLinkManUI";
  }

  public String listLinkMan()
  {
    System.out.println("开始执行了");
    List linkMans = this.customerService.findAllLinkMan();
    this.linkManModel.setLinkmans(linkMans);
    return "listLinkMan";
  }
}