package com.crm.service.impl;

import com.crm.dao.BaseDictDao;
import com.crm.dao.CstCustomerDao;
import com.crm.dao.CstLinkManDao;
import com.crm.dao.SaleVisitDao;
import com.crm.domain.BaseDict;
import com.crm.domain.CstCustomer;
import com.crm.domain.CstLinkMan;
import com.crm.domain.SaleVisit;
import com.crm.service.CstCustomerService;
import java.util.List;

public class CstCustomerServiceImpl
  implements CstCustomerService
{
  private CstCustomerDao customerDao;
  private CstLinkManDao linkManDao;
  private BaseDictDao baseDictDao;
  private SaleVisitDao saleVisitDao;

  public SaleVisitDao getSaleVisitDao()
  {
    return this.saleVisitDao;
  }
  public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
    this.saleVisitDao = saleVisitDao;
  }

  public CstCustomerDao getCustomerDao() {
    return this.customerDao;
  }
  public void setCustomerDao(CstCustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  public CstLinkManDao getLinkManDao() {
    return this.linkManDao;
  }
  public void setLinkManDao(CstLinkManDao linkManDao) {
    this.linkManDao = linkManDao;
  }

  public BaseDictDao getBaseDictDao() {
    return this.baseDictDao;
  }
  public void setBaseDictDao(BaseDictDao baseDictDao) {
    this.baseDictDao = baseDictDao;
  }

  public BaseDict findBaseDictById(String dictId)
  {
    return (BaseDict)this.baseDictDao.findById(dictId);
  }

  public List<BaseDict> findAllCustomerSource()
  {
    return this.baseDictDao.findAllBaseDict("002");
  }

  public void saveCustomer(CstCustomer customer)
  {
    this.customerDao.save(customer);
  }

  public List<CstCustomer> findAllCustomer()
  {
    return this.customerDao.findAllCustomer();
  }

  public CstCustomer findCustomerById(Long custId)
  {
    return (CstCustomer)this.customerDao.findById(custId);
  }

  public void updateCustomer(CstCustomer customer)
  {
    this.customerDao.update(customer);
  }

  public void deleteCustomer(Long custId)
  {
    this.customerDao.delete(custId);
  }

  public List<CstCustomer> findCustomerByName(String custName)
  {
    return this.customerDao.findCustomerByName(custName);
  }

  public void saveLinkMan(CstLinkMan linkMan)
  {
    this.linkManDao.save(linkMan);
  }

  public List<CstLinkMan> findAllLinkMan()
  {
    return this.linkManDao.findAllLinkMan();
  }

  public void editLinkMan(CstLinkMan linkMan)
  {
    this.linkManDao.update(linkMan);
  }

  public void deleteLinkMan(Long lkmId)
  {
    this.linkManDao.delete(lkmId);
  }

  public CstLinkMan findLinkMan(Long lkmId)
  {
    return (CstLinkMan)this.linkManDao.findById(lkmId);
  }

  public List<CstLinkMan> findLinkManByName(String lkmName)
  {
    return this.linkManDao.findLinkManByName(lkmName);
  }

  public List<SaleVisit> findAllSaleVisit()
  {
    return this.saleVisitDao.findAllSaleVisit();
  }

  public void saveSaleVisit(SaleVisit saleVisit) {
    this.saleVisitDao.save(saleVisit);
  }
}