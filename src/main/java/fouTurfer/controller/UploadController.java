package fouTurfer.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import fouTurfer.model.TurfInfos;
import fouTurfer.repository.TurfInfosRepository;
import fouTurfer.service.TurfInfoService;

@Controller
public class UploadController {
	
	@Autowired
	TurfInfosRepository turfInfosRepository;
	
	@Autowired
	TurfInfoService turfInfoService;

    @GetMapping("/")
    public String index(Model model) {
    	
    	 Set<String> dates = turfInfosRepository.findAll().stream()
 				.map(TurfInfos :: getJour)
 				.collect(Collectors.toSet());
    	 
//    	 System.out.println(dates.size());
//    	 System.out.println(dates.toString());

         
         model.addAttribute("dates", dates);
        return "upload";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFileByRace(@RequestParam("file") MultipartFile file, Model model) {
    	  System.out.println(turfInfosRepository.findAll().size() + "turfinforep.siz 1");

    	
    	List<TurfInfos> infos = new ArrayList<>();
    	
        // validate file
        if (file.isEmpty()) {
            model.addAttribute("messageempty", "Aucun fichier sélectionné, veuillez sélectionner un fichier.");
            model.addAttribute("status", false);
            // Envoyer les dates au model
            Set<String> dates = turfInfosRepository.findAll().stream()
    				.map(TurfInfos :: getJour)
    				.collect(Collectors.toSet());
            
            model.addAttribute("dates", dates);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<TurfInfos> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(TurfInfos.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                infos = csvToBean.parse();
//                if(infos.get(0).getKey().)

                // TODO: save users in DB?
               
                List<Integer> allPvch = turfInfosRepository.findAll().stream()
        				.map(TurfInfos :: getNumcourse)
        				.collect(Collectors.toList());
                
                for(TurfInfos info : infos) {
                	if(!allPvch.contains(info.getNumcourse()))
                	turfInfosRepository.save(info);
                }

                // Envoyer les dates au model
                Set<String> dates = turfInfosRepository.findAll().stream()
        				.map(TurfInfos :: getJour)
        				.collect(Collectors.toSet());
                
                model.addAttribute("dates", dates);

                model.addAttribute("infos", infos);
                model.addAttribute("pvch", turfInfosRepository.findAllByOrderByPourcVictChevalHippoDesc());
          	  System.out.println(turfInfosRepository.findAll().size() + "turfinforep.siz 2");

                
                model.addAttribute("status", true);
                model.addAttribute("messagesuccess", "Fichier importé avec succès");


            } catch (Exception ex) {
                model.addAttribute("messageerror", "Une erreur est apparue durant l'import du fichier.");
                model.addAttribute("status", false);
                // Envoyer les dates au model
                Set<String> dates = turfInfosRepository.findAll().stream()
        				.map(TurfInfos :: getJour)
        				.collect(Collectors.toSet());
                
                model.addAttribute("dates", dates);
            }
        }
        
        
        return "upload";
//        return "file-upload-status";
//        return "races-page";

    }
    
    @PostMapping("/day-infos")
    public String getDayInfos(@RequestParam("jour") String jour, Model model) {
    	
    	//Récuperer chaque reunion (1, 2, 3, 4...)
    	 Set<String> reunions = turfInfosRepository.findAllByJour(jour).stream()
 				.map(TurfInfos :: getR)
 				.collect(Collectors.toSet());
    	     	 
    	 
     	model.addAttribute("reunions", reunions);
    	model.addAttribute("jour", jour);
    	
    	return "day-infos";
    }
    
    @GetMapping("/reunion-infos")
    public String getReunionInfos(@RequestParam("jour") String jour,
    		@RequestParam("reunion") String reunion,
    		Model model) {    	
    	
    	model.addAttribute("date", jour);
    	
    	//RACELIST
    	List<TurfInfos> allReunionInfos = turfInfosRepository.findAllByJourAndByReunion(jour, reunion);
    	
    	//biglist
//		LinkedList<LinkedList<TurfInfos>> biglist = new LinkedList<LinkedList<TurfInfos>>();

    	//Num des courses
		Set<Integer> distinctNumraces = allReunionInfos.stream()
		.map(TurfInfos :: getC)
		.sorted()
		.collect(Collectors.toSet());
		List<Integer> list = new ArrayList<Integer>(distinctNumraces);
		Collections.reverse(list);
		distinctNumraces = new LinkedHashSet<>(list);
		
		  //Cast
//		 LinkedList<String> distinctNumracesString = new LinkedList<>();
//				 
//		    for(Integer i : distinctNumraces) {
//		    	distinctNumracesString.add(i.toString());
//		    }
		
		System.out.println(distinctNumraces.size());
		
		model.addAttribute("distinctnumraces", distinctNumraces);
		
		for(Integer num : distinctNumraces) {
					
			//Infos de la course en question
			List<TurfInfos> allraceInfos = 
					allReunionInfos
					.stream()
					.filter(ti -> ti.getC().equals(num))
					.collect(Collectors.toList());
			
			//création des listes filtrées et triées par parametre
			
			List<TurfInfos> listBypvch =  allraceInfos.stream()
					.sorted(Comparator.comparingDouble(TurfInfos::getPourcVictChevalHippo))
					.filter(ti -> !ti.getPourcVictChevalHippo().equals(0d))
					.collect(Collectors.toList());
			Collections.reverse(listBypvch);
			
			List<TurfInfos> listBypvjh =  allraceInfos.stream()
					.sorted(Comparator.comparingDouble(TurfInfos::getPourcVictJockHippo))
					.filter(ti -> !ti.getPourcVictJockHippo().equals(0d))
					.collect(Collectors.toList());
			Collections.reverse(listBypvjh);
			
			List<TurfInfos> listBypveh =  allraceInfos.stream()
					.sorted(Comparator.comparingDouble(TurfInfos::getPourcVictEntHippo))
					.filter(ti -> !ti.getPourcVictEntHippo().equals(0d))
					.collect(Collectors.toList());
			Collections.reverse(listBypveh);
			
			//CHRONOS
			List<TurfInfos> listByChronos =  allraceInfos.stream()
					.filter(ti -> ti.getChrono()!= null)
					.sorted(Comparator.comparingInt(TurfInfos::getChrono))
					.collect(Collectors.toList());
//			Collections.reverse(listBypvch);

			
			Optional<TurfInfos> optTinf = allraceInfos.stream().findFirst();
			if(optTinf.isPresent()) {
				TurfInfos tinf = optTinf.get();
			model.addAttribute(numToString(num) + "title","R" + tinf.getR() + "C" + num );
			model.addAttribute(numToString(num) + "pvch", listBypvch);
			model.addAttribute(numToString(num) + "pvjh", listBypvjh);
			model.addAttribute(numToString(num) + "pveh", listBypveh);
			
			model.addAttribute(numToString(num) + "chronoslist", listByChronos);
			model.addAttribute("chronos", false); //??????????????????

			model.addAttribute(numToString(num) + "exists", true);
						
			
					



			}

			//+ message model   num = true


	}
		
//		 -if 0% ne pas afficher
//		
//		 -place cheval hippodrome %
//		 
//		 
//		 -couple
//		 -v
//		 -vh
//		 -p
//		 -ph
//		 
//		 -entraineur: que sur l'hippodrome
//		 
//		 
//		 + nouvelle page pour entrer les chronos
//	
//		ORDRE:
//			-chronos
//			-vict ent hippo
//			-vict jock hippo
//			-vict chev 
//			-vict chev hippo
				
		
    	
    	return "reunion-infos";
    }
    
    ///////////////////////////////////////////////////////////////
    private String numToString(Integer num) {
    	
    	String str = null;
    	
    	 switch(num){
    	   
         case 1: 
             str = "one";
             break;
     
         case 2:
             str = "two";
             break;
     
         case 3:
             str = "three";
             break;
             
         case 4: 
             str = "four";
             break;
     
         case 5:
             str = "five";
             break;
     
         case 6:
             str = "six";
             break;
             
         case 7: 
                 str = "seven";
                 break;
         
             case 8:
                 str = "eight";
                 break;
         
             case 9:
                 str = "nine";
                 break;
                 
             case 10: 
                 str = "ten";
                 break;
         
             case 11:
                 str = "eleven";
                 break;
         
             case 12:
                 str = "twelve";
                 break;
             
//         default:
//             System.out.println("Choix incorrect");
//             break;
     }
    
    	return str;
    }
    
}