package br.com.api.test.domain.pessoa.entities;

import br.com.api.test.domain.base.entities.EntityBase;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HSSPESS")
public class Pessoa extends EntityBase<Long> {

  // O Id Foi colocado na classe EntityBase
  // NNUMEPESS NUMBER NOT NULL ENABLE,
  @Column(name = "NNUMEPROF")
  private long numeroProfissional;

  @Column(name = "NFILIPESS")
  private long numeroFilial;

  @Column(name = "NNUMEATIVI")
  private long numeroAtividadePrincipal;

  @Column(name = "CNOMEPESS")
  public String cnomepess;

  @Column(name = "CFANTPESS")
  public String cfantpess;

  @Column(name = "DINCLPESS")
  public LocalDateTime dINCLPESS;

  @Column(name = "CNMAEPESS")
  public String cNMAEPESS;

  @Column(name = "CNPAIPESS")
  public String cNPAIPESS;

  @Column(name = "CCNPJPESS")
  public String cCNPJPESS;

  @Column(name = "CCPF_PESS")
  public String cCPF_PESS;

  @Column(name = "CRG__PESS")
  public String cRG__PESS;

  @Column(name = "CORRGPESS")
  public String cORRGPESS;

  @Column(name = "DEMRGPESS")
  public LocalDateTime dEMRGPESS;

  @Column(name = "CPIS_PESS")
  public String cPIS_PESS;

  @Column(name = "CINSCPESS")
  public String cINSCPESS;

  @Column(name = "CINSMPESS")
  public String cINSMPESS;

  @Column(name = "DNASCPESS")
  public LocalDateTime dNASCPESS;

  @Column(name = "CSEXOPESS")
  public String cSEXOPESS;

  @Column(name = "CESTCPESS")
  public String cESTCPESS;

  @Column(name = "CGINSPESS")
  public String cGINSPESS;

  @Column(name = "DOBITPESS")
  public String dOBITPESS;

  @Column(name = "CPASSPESS")
  public String cPASSPESS;

  @Column(name = "CCEI_PESS")
  public String cCEI_PESS;

  @Column(name = "NCHADPESS")
  public int nCHADPESS;

  @Column(name = "CSENHPESS")
  public String cSENHPESS;

  @Column(name = "CCNS_PESS")
  public String cCNS_PESS;

  @Column(name = "CCERTPESS")
  public String cCERTPESS;

  @Column(name = "NPAISPESS")
  public int nPAISPESS;

  @Column(name = "CCNESPESS")
  public String cCNESPESS;

  @Column(name = "CPESSPESS")
  public String cPESSPESS;

  @Column(name = "CDCNVPESS")
  public String cDCNVPESS;

  @Column(name = "CBENEPESS")
  public String cBENEPESS;

  @Column(name = "CEVENPESS")
  public String cEVENPESS;

  @Column(name = "CPRESPESS")
  public String cPRESPESS;

  @Column(name = "CFORNPESS")
  public String cFORNPESS;

  @Column(name = "CTITUPESS")
  public String cTITUPESS;

  @Column(name = "CVENDPESS")
  public String cVENDPESS;

  @Column(name = "CPROSPESS")
  public String cPROSPESS;

  @Column(name = "COPERPESS")
  public String cOPERPESS;

  @Column(name = "DSENVPESS")
  public String dSENVPESS;

  @Column(name = "DATUAPESS")
  public LocalDateTime dATUAPESS;

  @Column(name = "CISENPESS")
  public String cISENPESS;

  @Column(name = "CRACAPESS")
  public String cRACAPESS;

  @Column(name = "CCATEPESS")
  public String cCATEPESS;

  @Column(name = "CCIDNPESS")
  public String cCIDNPESS;

  @Column(name = "CESTNPESS")
  public String cESTNPESS;

  @Column(name = "NPNASPESS")
  public String nPNASPESS;

  @Column(name = "CHIGNPESS")
  public String cHIGNPESS;

  // @Column(name = "ALTERADO_CLEBER")
  // public String aLTERADO_CLEBER;

  @Column(name = "CRNE_PESS")
  public String cRNE_PESS;

  // @Column(name = "CFOTOPESS")
  // public String cFOTOPESS;

  @Column(name = "CCAEPPESS")
  public String cCAEPPESS;
}
