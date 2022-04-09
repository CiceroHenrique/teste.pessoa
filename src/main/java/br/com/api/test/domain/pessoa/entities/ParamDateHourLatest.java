package br.com.api.test.domain.pessoa.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_last_itegration_processing")
public class ParamDateHourLatest {

  @Id() private Long id;
  private Long integrationType_id = 1L;
  private LocalDateTime lastProcessingDate;
  private LocalDateTime specificProcessingDate;
  private LocalDateTime updateDate;
  @Transient private LocalDateTime executeDate = LocalDateTime.now();
}
