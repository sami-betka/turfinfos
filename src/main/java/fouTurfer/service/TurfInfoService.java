package fouTurfer.service;

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
	
    public void update(TurfInfos info) {
    	
    	TurfInfos infoToUpdate = turfInfosRepository.findByNumeroAndNumcourse(info.getNumero(), info.getNumcourse());
    	
    	infoToUpdate.setC(info.getC());
    	infoToUpdate.setCheval(info.getCheval());
    	infoToUpdate.setJour(info.getJour());
    	infoToUpdate.setNumcourse(info.getNumcourse());
    	infoToUpdate.setNumero(info.getNumero());
    	infoToUpdate.setPourcPlaceChevalHippo(info.getPourcPlaceChevalHippo());
    	infoToUpdate.setPourcPlaceEntHippo(info.getPourcPlaceEntHippo());
    	infoToUpdate.setPourcPlaceJockHippo(info.getPourcPlaceJockHippo());
    	infoToUpdate.setPourcVictChevalHippo(info.getPourcVictChevalHippo());
    	infoToUpdate.setPourcVictEntHippo(info.getPourcVictEntHippo());
    	infoToUpdate.setPourcVictJockHippo(info.getPourcVictJockHippo());
    	infoToUpdate.setR(info.getR());
    	infoToUpdate.setRecence(info.getRecence());
    	infoToUpdate.setTxPlaceCouple(info.getTxPlaceCouple());
    	infoToUpdate.setTxPlaceCoupleHippo(info.getTxPlaceCoupleHippo());
    	infoToUpdate.setTxVictCouple(info.getTxVictCouple());
    	infoToUpdate.setTxVictCoupleHippo(info.getTxVictCoupleHippo());
    	
    	infoToUpdate.setCoursescheval(info.getCoursescheval());
//    	infoToUpdate.setCoursesentraineur(info.getCoursesentraineur());
//    	infoToUpdate.setCoursesjockey(info.getCoursesjockey());
    	infoToUpdate.setNbCourseCouple(info.getNbCourseCouple());
    	infoToUpdate.setNbrCourseChevalHippo(info.getNbrCourseChevalHippo());
    	infoToUpdate.setNbrCourseJockHippo(info.getNbrCourseJockHippo());
    	infoToUpdate.setNbrCourseEntHippo(info.getNbrCourseEntHippo());
    	infoToUpdate.setNbCourseCoupleHippo(info.getNbCourseCoupleHippo());
//    	infoToUpdate.setTypec(info.getTypec());
    	infoToUpdate.setEntraineur(info.getEntraineur());
    	infoToUpdate.setCl(info.getCl());
    	infoToUpdate.setCotedirect(info.getCotedirect());


    	
    	
//    	infoToUpdate.setNoteProno(null);
//    	infoToUpdate.setChrono(info.getChrono());
//    	infoToUpdate.setNumeroString(info.getNumero().toString());



    	
    	
    	turfInfosRepository.save(infoToUpdate);
    	
    }
	
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
