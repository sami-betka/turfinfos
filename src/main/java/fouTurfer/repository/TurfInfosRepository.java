package fouTurfer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fouTurfer.model.TurfInfos;


public interface TurfInfosRepository extends JpaRepository<TurfInfos, Long> {

//	List<TurfInfos> saveAll(List<TurfInfos> infos);
	
	List<TurfInfos> findAllByOrderByPourcVictChevalHippoDesc();
}
