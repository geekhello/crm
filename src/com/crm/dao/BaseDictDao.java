package com.crm.dao;

import com.crm.domain.BaseDict;
import java.util.List;

public abstract interface BaseDictDao extends IBaseDao<BaseDict>
{
  public abstract List<BaseDict> findAllBaseDict(String paramString);
}
