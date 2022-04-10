package br.com.api.test.infra.crosscutting.integration.route.routes;

import br.com.api.test.domain.pessoa.entities.ParamDateHourLatest;
import br.com.api.test.infra.crosscutting.integration.processors.ParamDateHourLatestProcessor;
import br.com.api.test.infra.crosscutting.integration.route.RouteBase;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.camel.LoggingLevel;
import org.apache.camel.model.dataformat.JsonLibrary;

@ApplicationScoped
public class PessoaRoute extends RouteBase {

  final ParamDateHourLatestProcessor paramDateHourLatestProcessor;

  @Inject
  public PessoaRoute(ParamDateHourLatestProcessor paramDateHourLatestProcessor) {
    this.paramDateHourLatestProcessor = paramDateHourLatestProcessor;
  }

  @Override
  public void configure() throws Exception {

    super.configure();

    from("direct:pessoa-producer")
        .routeId("pessoa-producer")
        .setProperty("paramDateHourLatest", simple("${body}"))
        .bean("PessoaBean", "listPessoasToIntegrateBean(${body})")
        .split(body())
        .parallelProcessing()
        // .bean("pessoaBean", "convertPessoa")
        .log(
            LoggingLevel.INFO,
            "${body} - Enviando Pessoa para o tópico : {{kafka.test.pessoas}} -"
                + " ${body.toJsonString}")
        .marshal()
        .json(JsonLibrary.Jsonb)
        .to("direct:kafka-pessoa")
        .log(
            LoggingLevel.INFO,
            "SUCESSO - Pessoa enviado para o tópico : {{kafka.test.pessoas}} -  ${body}")
        .end()
        .process(paramDateHourLatestProcessor)
        .to("jpa:" + ParamDateHourLatest.class.getName() + "?useExecuteUpdate=true");

    from("direct:kafka-pessoa")
        // .log("{{kafka.test.pessoas}}{{kafka.test.brokers}}{{kafka.test.params}}");
        .toD("{{kafka.test.pessoas}}{{kafka.test.brokers}}{{kafka.test.params}}");
  }
}
