package br.com.api.test.domain.pessoa.services;

import br.com.api.test.application.pessoa.dtos.PessoaDto;
import br.com.api.test.application.pessoa.services.IPessoaService;
import br.com.api.test.domain.base.services.BaseService;
import br.com.api.test.domain.pessoa.entities.Pessoa;
import br.com.api.test.domain.pessoa.repository.IPessoaRepository;
import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class PessoaService extends BaseService<PessoaDto, Pessoa> implements IPessoaService {

  private IPessoaRepository baseRepository;

  public PessoaService(IPessoaRepository baseRepository, ModelMapper mapper) {

    super(baseRepository, mapper);
    this.baseRepository = baseRepository;
  }

  public List<PessoaDto> listPessoasIntegrationService(
      LocalDateTime paramDateHourLatest, LocalDateTime paramDateHourNow) {

    var listPessoa =
        baseRepository.listPessoasIntegrationRepository(paramDateHourLatest, paramDateHourNow);

    List<PessoaDto> pessoasToIntegrate = mapAll(listPessoa, PessoaDto.class);

    return pessoasToIntegrate;
  }
}
