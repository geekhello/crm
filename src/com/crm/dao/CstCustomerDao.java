package com.crm.dao;

import com.crm.domain.CstCustomer;
import java.util.List;

public abstract interface CstCustomerDao extends IBaseDao<CstCustomer>
{
  public abstract List<CstCustomer> findAllCustomer();

  public abstract List<CstCustomer> findCustomerByName(String paramString);
}
