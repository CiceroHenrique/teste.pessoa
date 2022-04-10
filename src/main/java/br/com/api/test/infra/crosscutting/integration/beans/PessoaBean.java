package br.com.api.test.infra.crosscutting.integration.beans;

import br.com.api.test.application.pessoa.dtos.PessoaDto;
import br.com.api.test.application.pessoa.services.IPessoaService;
import br.com.api.test.domain.pessoa.entities.ParamDateHourLatest;
import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@ApplicationScoped
@Named("PessoaBean")
public class PessoaBean {

  IPessoaService pessoaService;

  public PessoaBean(IPessoaService pessoaService) {

    super();
    this.pessoaService = pessoaService;
  }

  public List<PessoaDto> listPessoasToIntegrateBean(ParamDateHourLatest paramDateHourLatest) {

    final LocalDateTime LAST_DATE = paramDateHourLatest.getLastProcessingDate().withNano(0);
    final LocalDateTime NOW_DATE = LocalDateTime.now().withNano(0);

    log.info("Interval Processing - LAST_PROCESSING: {} - CURRENT: {} ", LAST_DATE, NOW_DATE);

    var pessoasToIntegrate = pessoaService.listPessoasIntegrationService(LAST_DATE, NOW_DATE);

    return pessoasToIntegrate;
  }

  // public PessoaOutputDto convertPessoa(PessoaDto pessoa) {
  // return new PessoaOutputDto(pessoa);
  // }
}
