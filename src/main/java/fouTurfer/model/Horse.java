//package fouTurfer.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//
//import com.opencsv.bean.CsvBindByName;
//
//@Entity
//@Table(name = "horse"
////,
////uniqueConstraints=
////@UniqueConstraint(columnNames={"id", "turfkey"})
//)
//@SequenceGenerator(name = "HORSE_SEQ_GENERATOR", sequenceName = "HORSE_SEQ", initialValue = 1, allocationSize = 1)
//
//public class Horse {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HORSE_SEQ_GENERATOR")
//	@Column(name = "id")
//	@CsvBindByName
//	private Long id;
//
//	@Column(name = "turfkey")
//	@CsvBindByName
//	private String turfKey;
//
//}
