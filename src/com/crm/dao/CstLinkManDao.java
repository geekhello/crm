package com.crm.dao;

import com.crm.domain.CstLinkMan;
import java.util.List;

public abstract interface CstLinkManDao extends IBaseDao<CstLinkMan>
{
  public abstract List<CstLinkMan> findAllLinkMan();

  public abstract List<CstLinkMan> findLinkManByName(String paramString);
}
