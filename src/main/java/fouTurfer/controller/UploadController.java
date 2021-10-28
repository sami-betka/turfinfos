package fouTurfer.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
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
        
        
//        return "upload";
        return "file-upload-status";
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
    	
    	System.out.println(jour + reunion);
    	
    	model.addAttribute("reunionmap", turfInfoService.createReunionInfosMap(jour, reunion));
    	System.out.println(turfInfoService.createReunionInfosMap(jour, reunion).toString());
    	return "reunion-infos";
    }
    
}