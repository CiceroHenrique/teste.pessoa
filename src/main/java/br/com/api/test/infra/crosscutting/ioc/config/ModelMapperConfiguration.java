package br.com.api.test.infra.crosscutting.ioc.config;

import io.quarkus.arc.DefaultBean;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Dependent
public class ModelMapperConfiguration {

  @Produces
  @DefaultBean
  public ModelMapper ModelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    // return new ModelMapper();
    return modelMapper;
  }
}
