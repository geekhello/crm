package com.crm.web.action;

import com.crm.domain.BaseDict;
import com.crm.domain.CstCustomer;
import com.crm.domain.CustomerModel;
import com.crm.service.CstCustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class CustomerAction extends ActionSupport
  implements ModelDriven<CustomerModel>
{
  private CustomerModel customerModel = new CustomerModel();
  private CstCustomerService customerService;

  public CstCustomerService getCustomerService()
  {
    return this.customerService;
  }
  public void setCustomerService(CstCustomerService customerService) {
    this.customerService = customerService;
  }

  public CustomerModel getModel() {
    return this.customerModel;
  }

  public String listCustomerByName()
  {
    List customers = this.customerService.findCustomerByName(this.customerModel.getCustName());
    this.customerModel.setCustomers(customers);
    return "listCustomerByName";
  }

  public String removeCustomer()
  {
    this.customerService.deleteCustomer(this.customerModel.getCustId());
    return "removeCustomer";
  }

  public String editCustomer()
  {
    CstCustomer customer = this.customerModel.getCustomer();
    String dictId = this.customerModel.getDictId();
    Long custId = this.customerModel.getCustId();
    BaseDict baseDict = this.customerService.findBaseDictById(dictId);
    customer.setCustId(custId);
    customer.setBaseDict(baseDict);
    this.customerService.updateCustomer(customer);
    return "editCustomer";
  }

  public String editCustomerUI()
  {
    CstCustomer customer = this.customerService.findCustomerById(this.customerModel.getCustId());
    this.customerModel.setCustomer(customer);
    return "editCustomerUI";
  }

  public String listCustomer()
  {
    List customers = this.customerService.findAllCustomer();
    this.customerModel.setCustomers(customers);
    return "listCustomer";
  }

  public String addCustomerUI()
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    List baseDicts = this.customerService.findAllCustomerSource();
    request.setAttribute("baseDicts", baseDicts);
    return "addCustomerUI";
  }

  public String addCustomer()
  {
    CstCustomer customer = this.customerModel.getCustomer();
    BaseDict baseDict = this.customerService.findBaseDictById(this.customerModel.getDictId());

    customer.setBaseDict(baseDict);

    this.customerService.saveCustomer(customer);
    return "addCustomer";
  }
}