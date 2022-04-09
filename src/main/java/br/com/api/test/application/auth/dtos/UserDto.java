package br.com.api.test.application.auth.dtos;

import br.com.api.test.application.base.dtos.IdentityDto;
import javax.json.bind.annotation.JsonbProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto extends IdentityDto<UserDto, String> {
  @Getter(onMethod_ = {@JsonbProperty("login")})
  @Setter(onMethod_ = {@JsonbProperty("login")})
  private String login;
}
