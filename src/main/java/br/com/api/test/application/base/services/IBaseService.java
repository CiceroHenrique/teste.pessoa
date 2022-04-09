package br.com.api.test.application.base.services;

import br.com.api.test.application.base.dtos.IdentityDto;
import br.com.api.test.domain.base.entities.EntityBase;
import java.io.Serializable;
import java.util.List;

public interface IBaseService<TDto extends IdentityDto, TEntity extends EntityBase> {
  public <TId extends Serializable> TDto getById(TId id);

  public List<TDto> getAll();

  public TDto create(TDto dto);

  public TDto update(TDto dto);

  public <TId extends Serializable> int delete(TId id);

  public void commit();
}
