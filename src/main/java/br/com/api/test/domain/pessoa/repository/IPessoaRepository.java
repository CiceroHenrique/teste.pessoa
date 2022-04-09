package br.com.api.test.domain.pessoa.repository;

import br.com.api.test.domain.base.repository.IBaseRepository;
import br.com.api.test.domain.pessoa.entities.Pessoa;
import java.time.LocalDateTime;
import java.util.List;

public interface IPessoaRepository extends IBaseRepository<Pessoa, Long> {

  List<Pessoa> listPessoasIntegrationRepository(
      LocalDateTime paramDateHourLatest, LocalDateTime paramDateHourNow);
}
