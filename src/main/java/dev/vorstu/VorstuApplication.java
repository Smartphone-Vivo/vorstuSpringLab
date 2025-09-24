package dev.vorstu;

//import dev.vorstu.customerRepository.Initializer; раскоментить
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VorstuApplication {


//	private static Initializer initiator;
//
//	@Autowired
//	public void setInitializer(Initializer initiator) {
//		VorstuApplication.initiator = initiator;
//	}




	public static void main(String[] args) {

		SpringApplication.run(VorstuApplication.class, args);
//		initiator.initial();
	}

}
