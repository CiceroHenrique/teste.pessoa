package br.com.api.test.application.auth.services;

import br.com.api.test.application.auth.dtos.UserDto;
import br.com.api.test.application.base.services.IBaseService;
import br.com.api.test.domain.auth.entites.User;

public interface IUserService extends IBaseService<UserDto, User> {}
