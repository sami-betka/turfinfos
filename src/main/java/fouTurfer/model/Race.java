package fouTurfer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "race"
//,
//uniqueConstraints=
//@UniqueConstraint(columnNames={"id", "turfkey"})
)
@SequenceGenerator(name = "RACE_SEQ_GENERATOR", sequenceName = "RACE_SEQ", initialValue = 1, allocationSize = 1)

public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RACE_SEQ_GENERATOR")
	@Column(name = "id")
	@CsvBindByName
	private Long id;

	//@Column(name = "")
	@CsvBindByName
	private String R;

	//@Column(name = "")
	@CsvBindByName
	private String C;

//	@Column(name = "")
	@CsvBindByName
	private Integer numcourse;
	
//	private List<Horse> horses;

}
