package br.com.api.test.domain.auth.services;

import br.com.api.test.application.auth.dtos.UserDto;
import br.com.api.test.application.auth.services.IUserService;
import br.com.api.test.domain.auth.entites.User;
import br.com.api.test.domain.auth.repository.IUserRepository;
import br.com.api.test.domain.base.services.BaseService;
import javax.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class UserService extends BaseService<UserDto, User> implements IUserService {

  private IUserRepository baseRepository;

  public UserService(IUserRepository baseRepository, ModelMapper mapper) {
    super(baseRepository, mapper);
    this.baseRepository = baseRepository;
  }
}
