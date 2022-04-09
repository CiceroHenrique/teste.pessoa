package br.com.api.test.domain.auth.entites;

import br.com.api.test.domain.base.entities.EntityBase;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_test")
public class User extends EntityBase<String> {
  private String login;
}
