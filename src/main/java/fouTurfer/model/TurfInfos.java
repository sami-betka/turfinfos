package fouTurfer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "turf_infos"
//,
//uniqueConstraints=
//@UniqueConstraint(columnNames={"id", "numcourse"})
)
@SequenceGenerator(
		  name = "TURF_INFOS_SEQ_GENERATOR",
		  sequenceName = "BANKROLL_SEQ",
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
private String C;

@Column(name = "numcourse")
@CsvBindByName
private Integer numcourse;

  
//@Column(name = "")
@CsvBindByName
private String numero;

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

  public TurfInfos(Long id, String jour, String R, String C, Integer numcourse, String numero, String cheval, Double pourcVictChevalHippo, Double pourcVictJockHippo, Double pourcVictEntHippo) {
    this.id = id;
    this.R = R;
    this.C = C;
    this.pourcVictChevalHippo = pourcVictChevalHippo;
    this.pourcVictJockHippo = pourcVictJockHippo;
    this.pourcVictEntHippo = pourcVictEntHippo;
    this.numero = numero;
    this.cheval = cheval;
    this.jour = jour;
;

  }

  public TurfInfos() {
//	    this.turfKey = this.cheval + this.numcourse;

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

public String getNumero() {
	return numero;
}

public void setNumero(String numero) {
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

public String getC() {
	return C;
}

public void setC(String c) {
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
  
  

}