package fouTurfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fouTurfer.model.TurfInfos;
import fouTurfer.repository.TurfInfosRepository;

@Controller
public class TurfInfoController {
	
	@Autowired
	TurfInfosRepository repo;
	
	   @PostMapping("/set-chronos")
	    public String enterChronos(
	    		@RequestParam(name = "one", required = false) String one, 
	    		@RequestParam(name = "two", required = false) String two,
	    		@RequestParam(name = "three", required = false) String three,
	    		@RequestParam(name = "four", required = false) String four,
	    		@RequestParam(name = "five", required = false) String five,
	    		@RequestParam(name = "six", required = false) String six,
	    		@RequestParam(name = "seven", required = false) String seven,
	    		@RequestParam(name = "eight", required = false) String eight,
	    		@RequestParam(name = "jour", required = false) String jour,
	    		@RequestParam(name = "reunion", required = false) String reunion
	    ) {
		   
		   

		   if(one != null && one != "") {
			  TurfInfos tinf = repo.findById(Long.valueOf(one)).get();
			  tinf.setChrono(1);
			  repo.save(tinf);

		   }
		   if(two != null && two != "") {
				  TurfInfos tinf = repo.findById(Long.valueOf(two)).get();
				  tinf.setChrono(2);
				  repo.save(tinf);

			   } if(three != null && three != "") {
					  TurfInfos tinf = repo.findById(Long.valueOf(three)).get();
					  tinf.setChrono(3);
					  repo.save(tinf);

				   } if(four != null && four != "") {
						  TurfInfos tinf = repo.findById(Long.valueOf(four)).get();
						  tinf.setChrono(4);
						  repo.save(tinf);

					   } if(five != null && five != "") {
							  TurfInfos tinf = repo.findById(Long.valueOf(five)).get();
							  tinf.setChrono(5);
							  repo.save(tinf);

						   } if(six != null && six != "") {
								  TurfInfos tinf = repo.findById(Long.valueOf(six)).get();
								  tinf.setChrono(6);
								  repo.save(tinf);

							   } if(seven != null && seven != "") {
									  TurfInfos tinf = repo.findById(Long.valueOf(seven)).get();
									  tinf.setChrono(7);
									  repo.save(tinf);

								   }if(eight != null && eight != "") {
										  TurfInfos tinf = repo.findById(Long.valueOf(eight)).get();
										  tinf.setChrono(8);
										  repo.save(tinf);
									   }


			return "redirect:/reunion-infos?jour=" + jour + "&reunion=" + reunion;
	    }

}
