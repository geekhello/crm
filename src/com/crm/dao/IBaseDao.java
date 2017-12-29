package com.crm.dao;

import java.io.Serializable;

public abstract interface IBaseDao<T>
{
  public abstract void save(T paramT);

  public abstract void delete(Serializable paramSerializable);

  public abstract void update(T paramT);

  public abstract T findById(Serializable paramSerializable);
}
