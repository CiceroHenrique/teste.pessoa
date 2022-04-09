package br.com.api.test.domain.base.services;

import br.com.api.test.application.base.dtos.IdentityDto;
import br.com.api.test.application.base.services.IBaseService;
import br.com.api.test.domain.base.entities.EntityBase;
import br.com.api.test.domain.base.repository.IBaseRepository;
import com.google.common.reflect.TypeToken;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public abstract class BaseService<TDto extends IdentityDto<TDto, ?>, TEntity extends EntityBase<?>>
    implements IBaseService<TDto, TEntity> {

  private final IBaseRepository<TEntity, ?> baseRepository;

  private final ModelMapper mapper;

  protected BaseService() {
    super();
    baseRepository = null;
    mapper = null;
  }

  public BaseService(IBaseRepository<TEntity, ?> baseRepository, ModelMapper mapper) {
    this.baseRepository = baseRepository;
    this.mapper = mapper;
  }

  public <D> D map(Object from, Class<D> typeTo) {
    return mapper.map(from, typeTo);
  }

  public <D> D map(Object from, Type typeTo) {
    return mapper.map(from, typeTo);
  }

  public <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
    return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
  }

  @Override
  public <TId extends Serializable> TDto getById(TId id) {
    var entity = this.baseRepository.getByIdType(id);
    if (entity == null) {
      return null;
    }
    TDto dto = map(entity, new TypeToken<TDto>(getClass()) {}.getType());
    return dto;
  }

  @Override
  public List<TDto> getAll() {
    var entitys = this.baseRepository.getAll();
    if (entitys == null) {
      return null;
    }
    List<TDto> dtos = map(entitys, new TypeToken<List<TDto>>(getClass()) {}.getType());
    return dtos;
  }

  @Override
  public TDto create(TDto dto) {
    TEntity entity = map(dto, new TypeToken<TEntity>(getClass()) {}.getType());
    this.baseRepository.add(entity);
    this.baseRepository.saveChanges();
    dto = map(entity, new TypeToken<TDto>(getClass()) {}.getType());
    return dto;
  }

  @Override
  public TDto update(TDto dto) {
    var type = new TypeToken<TEntity>(getClass()) {}.getType();
    TEntity entity = map(dto, type);
    this.baseRepository.attach(entity);
    this.baseRepository.saveChanges();
    return dto;
  }

  @Override
  public <TId extends Serializable> int delete(TId id) {
    this.baseRepository.removeByIdType(id);
    this.baseRepository.saveChanges();
    return 0;
  }

  @Override
  public void commit() {
    this.baseRepository.commit();
  }
}
