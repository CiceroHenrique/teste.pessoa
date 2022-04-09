package br.com.api.test.domain.base.repository;

import br.com.api.test.domain.base.entities.EntityBase;
import java.io.Serializable;
import java.util.List;

public interface IBaseRepository<
    TEntity extends EntityBase<TIdentity>, TIdentity extends Serializable> {
  TEntity getById(TIdentity id);

  <TId extends Serializable> TEntity getByIdType(TId id);

  List<TEntity> getAll();

  void add(TEntity entity);

  void attach(TEntity entity);

  void remove(TIdentity id);

  <TId extends Serializable> void removeByIdType(TId id);

  void commit();

  void saveChanges();

  void beginTransaction();

  void rollback() throws Exception;
}
