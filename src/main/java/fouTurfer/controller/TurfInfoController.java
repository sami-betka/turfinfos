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
	    		@RequestParam(name = "one", required = false) Long one, 
	    		@RequestParam(name = "two", required = false) Long two,
	    		@RequestParam(name = "three", required = false) TurfInfos three,
	    		@RequestParam(name = "four", required = false) TurfInfos four,
	    		@RequestParam(name = "five", required = false) TurfInfos five,
	    		@RequestParam(name = "six", required = false) TurfInfos six,
	    		@RequestParam(name = "seven", required = false) TurfInfos seven,
	    		@RequestParam(name = "eight", required = false) TurfInfos eight,
	    		@RequestParam(name = "jour", required = false) String jour,
	    		@RequestParam(name = "reunion", required = false) String reunion
	    ) {
		   
		   
		   System.out.println(one);
		   System.out.println(two);
		   System.out.println(three);



//		   if(one != null) {
//			  TurfInfos tinf = repo.findById(one.getId()).get();
//			  tinf.setChrono(1);
//			  repo.save(tinf);
//
//		   }
//		   if(two != null) {
//				  TurfInfos tinf = repo.findById(two.getId()).get();
//				  tinf.setChrono(2);
//				  repo.save(tinf);
//
//			   } if(three != null) {
//					  TurfInfos tinf = repo.findById(three.getId()).get();
//					  tinf.setChrono(3);
//					  repo.save(tinf);
//
//				   } if(four != null) {
//						  TurfInfos tinf = repo.findById(four.getId()).get();
//						  tinf.setChrono(4);
//						  repo.save(tinf);
//
//					   } if(five != null) {
//							  TurfInfos tinf = repo.findById(five.getId()).get();
//							  tinf.setChrono(5);
//							  repo.save(tinf);
//
//						   } if(six != null) {
//								  TurfInfos tinf = repo.findById(six.getId()).get();
//								  tinf.setChrono(6);
//								  repo.save(tinf);
//
//							   } if(seven != null) {
//									  TurfInfos tinf = repo.findById(seven.getId()).get();
//									  tinf.setChrono(7);
//									  repo.save(tinf);
//
//								   }if(eight != null) {
//										  TurfInfos tinf = repo.findById(eight.getId()).get();
//										  tinf.setChrono(8);
//										  repo.save(tinf);
//									   }

		   
		   
		   
		   
		   

			return "redirect:/reunion-infos?jour=" + jour + "&reunion=" + reunion;
	    }

}
