package fouTurfer.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

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
import fouTurfer.model.User;
import fouTurfer.repository.TurfInfosRepository;

@Controller
public class UploadController {
	
	@Autowired
	TurfInfosRepository turfInfosRepository;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFileByRace(@RequestParam("file") MultipartFile file, Model model) {

    	
    	List<TurfInfos> infos = new ArrayList<>();
    	
        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
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
                for(TurfInfos info : infos) {
                	info.setTurfKey(info.getCheval()+info.getNumcourse());
                	turfInfosRepository.save(info);
                }

                // save users list on model
                model.addAttribute("infos", infos);
                model.addAttribute("pvch", turfInfosRepository.findAllByOrderByPourcVictChevalHippoDesc());
          	  System.out.println(turfInfosRepository.findAllByOrderByPourcVictChevalHippoDesc().size());

                
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        
        return "file-upload-status";
    }
}