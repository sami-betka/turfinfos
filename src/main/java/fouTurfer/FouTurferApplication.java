package fouTurfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fouTurfer.repository.TurfInfosRepository;

@SpringBootApplication
public class FouTurferApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FouTurferApplication.class, args);
		
		
//		TurfInfosRepository repository = ctx.getBean(TurfInfosRepository.class);

	}

}
