package br.com.api.test.application.pessoa.services;

import br.com.api.test.application.base.services.IBaseService;
import br.com.api.test.application.pessoa.dtos.PessoaDto;
import br.com.api.test.domain.pessoa.entities.Pessoa;
import java.time.LocalDateTime;
import java.util.List;

public interface IPessoaService extends IBaseService<PessoaDto, Pessoa> {

  public List<PessoaDto> listPessoasIntegrationService(
      LocalDateTime paramDateHourLatest, LocalDateTime paramDateHourNow);
}
