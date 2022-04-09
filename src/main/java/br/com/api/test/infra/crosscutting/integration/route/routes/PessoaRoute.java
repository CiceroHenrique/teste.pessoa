package br.com.api.test.infra.crosscutting.integration.route.routes;

import br.com.api.test.infra.crosscutting.integration.processors.ParamDateHourLatestProcessor;
import br.com.api.test.infra.crosscutting.integration.route.RouteBase;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
        .log("Before Unmarshel - ${body}")
        .setProperty("paramDateHourLatest", simple("${body}"))
        .log("After Unmarshel - ${body}");
    // .bean("ProductBean", "listProductsToIntegrateBean(${body})")
    // .split(body())
    // .parallelProcessing()
    // .bean("ProductBean", "convertProduct")
    // .log(
    // LoggingLevel.INFO,
    // "${body.source}.${body.data.sourceId}.${body.data.refId} - Enviando produto
    // para o"
    // + " tópico : {{kafka.test.products}} - ${body.toJsonString}")
    // .marshal()
    // .json(JsonLibrary.Jsonb)
    // .to("direct:kafka-product")
    // .log(
    // LoggingLevel.INFO,
    // "SUCESSO - Produto enviado para o tópico : {{kafka.test.products}} -
    // ${body}")
    // .end()
    // .process(paramDateHourLatestProcessor)
    // .to("jpa:" + ParamDateHourLatest.class.getName() + "?useExecuteUpdate=true");

    from("direct:kafka-pessoa")
        .log("{{kafka.test.pessoas}}{{kafka.test.brokers}}{{kafka.test.params}}");
    // .toD("{{kafka.test.products}}{{kafka.test.brokers}}{{kafka.test.params}}");
  }
}
