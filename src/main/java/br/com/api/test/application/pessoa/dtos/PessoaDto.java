package br.com.api.test.application.pessoa.dtos;

import br.com.api.test.application.base.dtos.IdentityDto;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PessoaDto extends IdentityDto<PessoaDto, Long> {

  private long numeroProfissional;

  private long numeroFilial;

  private long numeroAtividadePrincipal;

  public String cnomepess;

  public String cfantpess;

  public LocalDateTime dINCLPESS;

  public String cNMAEPESS;

  public String cNPAIPESS;

  public String cCNPJPESS;

  public String cCPF_PESS;

  public String cRG__PESS;

  public String cORRGPESS;

  public LocalDateTime dEMRGPESS;

  public String cPIS_PESS;

  public String cINSCPESS;

  public String cINSMPESS;

  public LocalDateTime dNASCPESS;

  public String cSEXOPESS;

  public String cESTCPESS;

  public String cGINSPESS;

  public String dOBITPESS;

  public String cPASSPESS;

  public String cCEI_PESS;

  public int nCHADPESS;

  public String cSENHPESS;

  public String cCNS_PESS;

  public String cCERTPESS;

  public int nPAISPESS;

  public String cCNESPESS;

  public String cPESSPESS;

  public String cDCNVPESS;

  public String cBENEPESS;

  public String cEVENPESS;

  public String cPRESPESS;

  public String cFORNPESS;

  public String cTITUPESS;

  public String cVENDPESS;

  public String cPROSPESS;

  public String cOPERPESS;

  public String dSENVPESS;

  public LocalDateTime dATUAPESS;

  public String cISENPESS;

  public String cRACAPESS;

  public String cCATEPESS;

  public String cCIDNPESS;

  public String cESTNPESS;

  public String nPNASPESS;

  public String cHIGNPESS;

  public String cRNE_PESS;

  public String cCAEPPESS;
}
