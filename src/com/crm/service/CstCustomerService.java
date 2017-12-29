package com.crm.service;

import com.crm.domain.BaseDict;
import com.crm.domain.CstCustomer;
import com.crm.domain.CstLinkMan;
import com.crm.domain.SaleVisit;
import java.util.List;

public abstract interface CstCustomerService
{
  public abstract void saveCustomer(CstCustomer paramCstCustomer);

  public abstract List<CstCustomer> findAllCustomer();

  public abstract List<BaseDict> findAllCustomerSource();

  public abstract CstCustomer findCustomerById(Long paramLong);

  public abstract BaseDict findBaseDictById(String paramString);

  public abstract void updateCustomer(CstCustomer paramCstCustomer);

  public abstract void deleteCustomer(Long paramLong);

  public abstract List<CstCustomer> findCustomerByName(String paramString);

  public abstract void saveLinkMan(CstLinkMan paramCstLinkMan);

  public abstract List<CstLinkMan> findAllLinkMan();

  public abstract void editLinkMan(CstLinkMan paramCstLinkMan);

  public abstract void deleteLinkMan(Long paramLong);

  public abstract CstLinkMan findLinkMan(Long paramLong);

  public abstract List<CstLinkMan> findLinkManByName(String paramString);

  public abstract List<SaleVisit> findAllSaleVisit();

  public abstract void saveSaleVisit(SaleVisit paramSaleVisit);
}