package br.com.api.test.infra.data.auth.repository;

import br.com.api.test.domain.auth.entites.User;
import br.com.api.test.domain.auth.repository.IUserRepository;
import br.com.api.test.infra.data.base.repository.BaseRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class UserRepository extends BaseRepository<User, String> implements IUserRepository {

  public UserRepository(EntityManager em) {
    super(em, User.class);
  }
}
