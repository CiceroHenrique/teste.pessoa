package br.com.api.test.infra.crosscutting.integration;

import br.com.api.test.domain.pessoa.entities.ParamDateHourLatest;
import br.com.api.test.infra.crosscutting.integration.route.RouteBase;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MainRoute extends RouteBase {

  @Override
  public void configure() throws Exception {

    from("timer://timer?period={{exec-params.process-time}}")
        .routeId("startRouterTimerReservation")
        .toD(
            "jpa:"
                + ParamDateHourLatest.class.getName()
                + "?query=select p from ParamDateHourLatest p where"
                + " p.integrationType_id=1&consumeLockEntity=false")
        .split(body())
        .to("direct:pessoa-producer")
        .end();
  }
}
