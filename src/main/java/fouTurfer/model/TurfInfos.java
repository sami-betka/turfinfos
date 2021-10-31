package fouTurfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "turf_infos"
//,
//uniqueConstraints=
//@UniqueConstraint(columnNames={"id", "numcourse"})
)
@SequenceGenerator(
		  name = "TURF_INFOS_SEQ_GENERATOR",
		  sequenceName = "TURF_INFOS_SEQ",
		  initialValue = 1, allocationSize = 1)

public class TurfInfos {

  @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TURF_INFOS_SEQ_GENERATOR")
  @Column(name = "id")
  @CsvBindByName
  private Long id;
  
//  @Column(name = "")
@CsvBindByName
private String jour;
  
//@Column(name = "")
@CsvBindByName
private String R;

//@Column(name = "")
@CsvBindByName
private Integer C;

@Column(name = "numcourse")
@CsvBindByName
private Integer numcourse;

  
//@Column(name = "")
@CsvBindByName
private Integer numero;

//@Column(name = "")
@CsvBindByName
private String cheval;

//  @Column(name = "")
  @CsvBindByName
//  @CsvNumber("###.##")
  private Double pourcVictChevalHippo;

//  @Column(name = "")
  @CsvBindByName
//  @CsvNumber("###.##")
  private Double pourcVictJockHippo;

//  @Column(name = "")
  @CsvBindByName
//  @CsvNumber("###.##")
  private Double pourcVictEntHippo;
  
//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double pourcPlaceChevalHippo;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double pourcPlaceJockHippo;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double pourcPlaceEntHippo;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double TxVictCouple;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double TxPlaceCouple;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double TxVictCoupleHippo;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Double TxPlaceCoupleHippo;

//@Column(name = "")
@CsvBindByName
//@CsvNumber("###.##")
private Integer recence;


  private Integer chrono;
  
  private Double noteProno;
  

  public TurfInfos(Long id, String jour, String R, Integer C, Integer numcourse, Integer numero, String cheval, Double pourcVictChevalHippo, Double pourcVictJockHippo, Double pourcVictEntHippo, Double pourcPlaceChevalHippo, Double pourcPlaceJockHippo, Double pourcPlaceEntHippo, Double TxVictCouple, Double TxPlaceCouple, Double TxVictCoupleHippo, Double TxPlaceCoupleHippo, Integer chrono, Integer noteProno, Integer recence) {
    this.id = id;
    this.R = R;
    this.C = C;
    this.pourcVictChevalHippo = pourcVictChevalHippo;
    this.pourcVictJockHippo = pourcVictJockHippo;
    this.pourcVictEntHippo = pourcVictEntHippo;
    this.numero = numero;
    this.cheval = cheval;
    this.jour = jour;
    this.pourcPlaceChevalHippo = pourcPlaceChevalHippo;
    this.pourcPlaceJockHippo = pourcPlaceJockHippo;
    this.pourcPlaceEntHippo = pourcPlaceEntHippo;
    this.TxVictCouple = TxVictCouple;
    this.TxPlaceCouple = TxPlaceCouple;
    this.TxVictCoupleHippo = TxVictCoupleHippo;
    this.TxPlaceCoupleHippo = TxPlaceCoupleHippo;
    this.recence = recence;

    //Paramètres crées
    
    this.chrono = chrono;
    this.noteProno = 0d;

  }
  
//  public void init() {
//	  
//	    this.noteProno = 0;
//
//  }

  public TurfInfos() {
	    this.noteProno = 0d;

  }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Double getPourcVictChevalHippo() {
	return pourcVictChevalHippo;
}

public void setPourcVictChevalHippo(Double pourcVictChevalHippo) {
	this.pourcVictChevalHippo = pourcVictChevalHippo;
}

public Double getPourcVictJockHippo() {
	return pourcVictJockHippo;
}

public void setPourcVictJockHippo(Double pourcVictJockHippo) {
	this.pourcVictJockHippo = pourcVictJockHippo;
}

public Double getPourcVictEntHippo() {
	return pourcVictEntHippo;
}

public void setPourcVictEntHippo(Double pourcVictEntHippo) {
	this.pourcVictEntHippo = pourcVictEntHippo;
}

public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public String getCheval() {
	return cheval;
}

public void setCheval(String cheval) {
	this.cheval = cheval;
}

public String getR() {
	return R;
}

public void setR(String r) {
	R = r;
}

public Integer getC() {
	return C;
}

public void setC(Integer c) {
	C = c;
}


public Integer getNumcourse() {
	return numcourse;
}

public void setNumcourse(Integer numcourse) {
	this.numcourse = numcourse;
}

public String getJour() {
	return jour;
}

public void setJour(String jour) {
	this.jour = jour;
}

public Integer getChrono() {
	return chrono;
}

public void setChrono(Integer chrono) {
	this.chrono = chrono;
}

public Double getPourcPlaceChevalHippo() {
	return pourcPlaceChevalHippo;
}

public void setPourcPlaceChevalHippo(Double pourcPlaceChevalHippo) {
	this.pourcPlaceChevalHippo = pourcPlaceChevalHippo;
}

public Double getPourcPlaceJockHippo() {
	return pourcPlaceJockHippo;
}

public void setPourcPlaceJockHippo(Double pourcPlaceJockHippo) {
	this.pourcPlaceJockHippo = pourcPlaceJockHippo;
}

public Double getPourcPlaceEntHippo() {
	return pourcPlaceEntHippo;
}

public void setPourcPlaceEntHippo(Double pourcPlaceEntHippo) {
	this.pourcPlaceEntHippo = pourcPlaceEntHippo;
}

public Double getTxVictCouple() {
	return TxVictCouple;
}

public void setTxVictCouple(Double txVictCouple) {
	TxVictCouple = txVictCouple;
}

public Double getTxPlaceCouple() {
	return TxPlaceCouple;
}

public void setTxPlaceCouple(Double txPlaceCouple) {
	TxPlaceCouple = txPlaceCouple;
}

public Double getTxVictCoupleHippo() {
	return TxVictCoupleHippo;
}

public void setTxVictCoupleHippo(Double txVictCoupleHippo) {
	TxVictCoupleHippo = txVictCoupleHippo;
}

public Double getTxPlaceCoupleHippo() {
	return TxPlaceCoupleHippo;
}

public void setTxPlaceCoupleHippo(Double txPlaceCoupleHippo) {
	TxPlaceCoupleHippo = txPlaceCoupleHippo;
}

public Double getNoteProno() {
	return noteProno;
}

public void setNoteProno(Double noteProno) {
	this.noteProno = noteProno;
}

public Integer getRecence() {
	return recence;
}

public void setRecence(Integer recence) {
	this.recence = recence;
}

  
}