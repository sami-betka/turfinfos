package fouTurfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fouTurfer.model.CSVHelper;
import fouTurfer.model.TurfInfos;
import fouTurfer.service.CSVService;

//@CrossOrigin("http://localhost:8081")
//@RequestMapping("/api/csv")

@Controller
public class CSVController {

  @Autowired
  CSVService fileService;
  
//  @GetMapping
//  public String upload() {
//	  
//	  return "upload";
//  }

  @PostMapping("/upload")
  public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
    String message = "";
        
    System.out.println(file.getContentType() + "11");
    System.out.println(CSVHelper.hasCSVFormat(file) + "22");

    if (CSVHelper.hasCSVFormat(file)) {
      try {
        fileService.save(file);
        
        model.addAttribute("message", "Uploaded the file successfully: " + file.getOriginalFilename());

        return "upload";
      } catch (Exception e) {
          model.addAttribute("message", "Could not upload the file: " + file.getOriginalFilename() + "!");

          return "upload";
      }
    }

    model.addAttribute("message", "Please upload a csv file!");

    return "upload";
  }

  @GetMapping("/turfinfos")
  public String getAllTurfInfos(Model model) {
    try {
      List<TurfInfos> infos = fileService.getAllTurfInfos();

      if (infos.isEmpty()) {
    	    model.addAttribute("message", "Pas de contenu");

        return "upload";
      }

	    model.addAttribute("message", "OK");

        return "upload";
    } catch (Exception e) {
	    model.addAttribute("message", "Erreur interne");

        return "upload";
    }
  }

}
