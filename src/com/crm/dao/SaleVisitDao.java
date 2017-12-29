package com.crm.dao;

import com.crm.domain.SaleVisit;
import java.util.List;

public abstract interface SaleVisitDao extends IBaseDao<SaleVisit>
{
  public abstract List<SaleVisit> findAllSaleVisit();
}
