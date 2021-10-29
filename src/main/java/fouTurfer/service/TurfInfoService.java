package fouTurfer.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	
	
	
	
//	public  Map<String, Map<String, Object>> createReunionInfosMap(String jour, String R){
//		
//		Map<String, Map<String, Object>> reunionInfosMap = new HashMap<>();
//		
//		//Récupere toutes les infos de la réunion
//		List<TurfInfos> allReunionInfos = turfInfosRepository.findAllByJour(jour)
//				.stream()
//				.filter(ti -> ti.getR().equals(R))
//				.collect(Collectors.toList());
//		/////////////////////////////////////////////
////		List<TurfInfos> testlist = new ArrayList<>();
////		for(TurfInfos ti: turfInfosRepository.findAllByJour(jour)) {
////			
////			if(ti.getR())
////			
////		}
//		////////////////////////////////////////////
//		
//		System.out.println("R= " + R);
//		System.out.println(turfInfosRepository.findAllByJour(jour).size() + "taille de findAllByJourservice");
//		System.out.println(allReunionInfos.size() + "taille de ");
//
//
//
//		
//		//Compte le nombre de course (C) de la réunion
//		Set<Integer> distinctRaces = allReunionInfos.stream()
//				.map(TurfInfos :: getNumcourse)
//				.sorted()
//				.collect(Collectors.toSet());
	
////		System.out.println(distinctRaces.size() + "taille de distoinctraces service");
//		
//		for (Integer numcourse : distinctRaces) {
//			
//			reunionInfosMap.put(getCByNumcourse(numcourse), createRaceInfosMap(numcourse));	
//		}
//		
//		return reunionInfosMap;
//	}
	
	public LinkedList<List<String>> createRaceInfosList(List<TurfInfos> raceInfos){
		
		LinkedList<List<String>> raceInfosList = new LinkedList<>();
		
//		List<TurfInfos> raceInfos = turfInfosRepository.findAllByNumcourse(numcourse);
				
		//get(0)
	    List<Double> raceSortedByPvch =  raceInfos.stream()
 				.map(TurfInfos :: getPourcVictChevalHippo)
				.sorted()
				.collect(Collectors.toList());
	    //Cast
		 LinkedList<String> raceSortedByPvchString = new LinkedList<>();
	    for(Double d : raceSortedByPvch) {
	    	raceSortedByPvchString.add(d.toString());
	    }
		
		//get(1)
		List<Double> raceSortedByPvjh = raceInfos.stream()
 				.map(TurfInfos :: getPourcVictJockHippo)
				.sorted()
				.collect(Collectors.toList());
	    //Cast
		 LinkedList<String> raceSortedByPvjhString = new LinkedList<>();
		    for(Double d : raceSortedByPvjh) {
		    	raceSortedByPvjhString.add(d.toString());
		    }
		
		//get(2)
		List<Double> raceSortedByPveh = raceInfos.stream()
 				.map(TurfInfos :: getPourcVictEntHippo)
				.sorted()
				.collect(Collectors.toList());
	    //Cast
		 LinkedList<String> raceSortedByPvehString = new LinkedList<>();
		    for(Double d : raceSortedByPveh) {
		    	raceSortedByPvehString.add(d.toString());
		    }


		raceInfosList.add(raceSortedByPvchString);
		raceInfosList.add(raceSortedByPvjhString);
		raceInfosList.add(raceSortedByPvehString);

		
		return raceInfosList;
	}
	
	public LinkedList<Integer> orderedChronosList(List<TurfInfos> list){
			 

		return null;
	}

}
