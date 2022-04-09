package br.com.api.test.infra.data.pessoa.repository;

import br.com.api.test.domain.pessoa.entities.Pessoa;
import br.com.api.test.domain.pessoa.repository.IPessoaRepository;
import br.com.api.test.infra.data.base.repository.BaseRepository;
import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PessoaRepository extends BaseRepository<Pessoa, Long> implements IPessoaRepository {

  public PessoaRepository(EntityManager em) {
    super(em, Pessoa.class);
  }

  public List<Pessoa> listPessoasIntegrationRepository(
      LocalDateTime paramDateHourLatest, LocalDateTime paramDateHourNow) {

    var query = new StringBuilder();
    query
        .append(" SELECT DISTINCT p ")
        .append("   FROM Pessoa p ")
        .append("  WHERE p.dATUAPESS BETWEEN :originDate AND :nowDate");

    var listProductsIntegration =
        session
            .createQuery(query.toString(), Pessoa.class)
            .setParameter("originDate", paramDateHourLatest)
            .setParameter("nowDate", paramDateHourNow)
            .getResultList();

    return listProductsIntegration;
  }
}
