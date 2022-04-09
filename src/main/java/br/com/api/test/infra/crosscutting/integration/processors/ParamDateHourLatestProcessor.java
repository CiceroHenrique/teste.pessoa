package br.com.api.test.infra.crosscutting.integration.processors;

import br.com.api.test.domain.pessoa.entities.ParamDateHourLatest;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@ApplicationScoped
public class ParamDateHourLatestProcessor implements Processor {
  @Override
  public void process(Exchange exchange) throws Exception {

    final ParamDateHourLatest paramDateHourLatest =
        exchange.getProperty("paramDateHourLatest", ParamDateHourLatest.class);

    LocalDateTime dateTimeNow = LocalDateTime.now();

    paramDateHourLatest.setLastProcessingDate(paramDateHourLatest.getExecuteDate());
    // paramDateHourLatest.setLast_hour(dateTimeNow.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    paramDateHourLatest.setUpdateDate(dateTimeNow);
    exchange.getIn().setBody(paramDateHourLatest);
  }
}
