package fouTurfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fouTurfer.model.TurfInfos;


public interface TurfInfosRepository extends JpaRepository<TurfInfos, Long> {

//	List<TurfInfos> saveAll(List<TurfInfos> infos);
	
	List<TurfInfos> findAllByOrderByPourcVictChevalHippoDesc();
	
	TurfInfos findByNumcourse(Integer numcourse);
	
	List<TurfInfos> findAllByNumcourse(Integer numcourse);
	
	List<TurfInfos> findAllByJour(String jour);
	
	@Query("SELECT ti FROM TurfInfos ti "
			+ "WHERE ti.jour = :jour AND ti.R = :reunion")
	List<TurfInfos> findAllByJourAndByReunion(String jour, String reunion);

	

}
