package fouTurfer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fouTurfer.model.TurfInfos;
import fouTurfer.repository.TurfInfosRepository;

@Service
public class TurfInfoService {
	
	@Autowired
	TurfInfosRepository turfInfosRepository;
	
//	public Map<String, Object> getSelectedInfosLists() {
//		
//		Map<String, Object> map = new HashMap<>();
//		 List<TurfInfos> allInfosForRace = turfInfosRepository.findAll();
//		 
//         List<TurfInfos> pvch = allInfos.stream().	
//        		 
////        			prods2.sort((p1, p2) -> p1.getId().compareTo(p2.getId()));
//
//		return map;
//	}
	
	public  Map<String, Map<String, Object>> createReunionInfosMap(String jour, String R){
		
		Map<String, Map<String, Object>> reunionInfosMap = new HashMap<>();
		
		//Récupere toutes les infos de la réunion
		List<TurfInfos> allReunionInfos = turfInfosRepository.findAllByJour(jour)
				.stream()
				.filter(ti -> ti.getR().equals(R))
				.collect(Collectors.toList());
		/////////////////////////////////////////////
//		List<TurfInfos> testlist = new ArrayList<>();
//		for(TurfInfos ti: turfInfosRepository.findAllByJour(jour)) {
//			
//			if(ti.getR())
//			
//		}
		////////////////////////////////////////////
		
		System.out.println("R= " + R);
		System.out.println(turfInfosRepository.findAllByJour(jour).size() + "taille de findAllByJourservice");
		System.out.println(allReunionInfos.size() + "taille de ");



		
		//Compte le nombre de course (C) de la réunion
		Set<Integer> distinctRaces = allReunionInfos.stream()
				.map(TurfInfos :: getNumcourse)
				.sorted()
				.collect(Collectors.toSet());
//		System.out.println(distinctRaces.size() + "taille de distoinctraces service");
		
		for (Integer numcourse : distinctRaces) {
			
			reunionInfosMap.put(getCByNumcourse(numcourse), createRaceInfosMap(numcourse));	
		}
		
		return reunionInfosMap;
	}
	
	public Map<String, Object> createRaceInfosMap(Integer numcourse){
		
		Map<String, Object> raceInfosMap = new HashMap<>();
		
		List<TurfInfos> raceInfos = turfInfosRepository.findAllByNumcourse(numcourse);
				
//		RC1.sort(null);
		List<TurfInfos> raceSortedByPvch = raceInfos.stream()
// 				.map(TurfInfos :: getPourcVictChevalHippo)
				.sorted(Comparator.comparingDouble(TurfInfos::getPourcVictChevalHippo))
				.collect(Collectors.toList());
		
		List<TurfInfos> raceSortedByPvjh = raceInfos.stream()
// 				.map(TurfInfos :: getPourcVictJockHippo)
				.sorted(Comparator.comparingDouble(TurfInfos::getPourcVictJockHippo))
				.collect(Collectors.toList());
		
		List<TurfInfos> raceSortedByPveh = raceInfos.stream()
// 				.map(TurfInfos :: getPourcVictEntHippo)
				.sorted(Comparator.comparingDouble(TurfInfos::getPourcVictEntHippo))
				.collect(Collectors.toList());


		raceInfosMap.put("pvch", raceSortedByPvch);
		raceInfosMap.put("pvjh", raceSortedByPvjh);
		raceInfosMap.put("pveh", raceSortedByPveh);

		
		return raceInfosMap;
	}
	
	public String getCByNumcourse(Integer numcourse){
			 
		return turfInfosRepository.findAllByNumcourse(numcourse).stream().findFirst().get().getC();
	}

}
