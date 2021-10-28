package fouTurfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fouTurfer.model.TurfInfos;


public interface TurfInfosRepository extends JpaRepository<TurfInfos, Long> {

//	List<TurfInfos> saveAll(List<TurfInfos> infos);
	
	List<TurfInfos> findAllByOrderByPourcVictChevalHippoDesc();
	
	TurfInfos findByNumcourse(Integer numcourse);
	
	List<TurfInfos> findAllByNumcourse(Integer numcourse);
	
	List<TurfInfos> findAllByJour(String jour);
	

}
