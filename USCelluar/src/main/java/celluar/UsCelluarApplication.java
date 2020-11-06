package celluar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import celluar.beans.CustomerContact;
import celluar.beans.MailAddress;
import celluar.controller.BeanConfiguration;
import celluar.repository.CustomerRepository;


@SpringBootApplication
public class UsCelluarApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsCelluarApplication.class, args);
	}
	
	@Autowired
	CustomerRepository repo;
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		CustomerContact d = new CustomerContact("Eason", "New Iphone 12 Pro", 20201021);
		MailAddress a = new MailAddress("5678 Main Street", "Ames", "IA", 50010);
		d.setAddress(a);
		repo.save(d);
		
		
		CustomerContact b = new CustomerContact("Eric", "New Iphone 12 Pro Max", 20201023);
		MailAddress c = new MailAddress("3346 Main Street", "Des Moines", "IA", 50304);
		b.setAddress(c);
		repo.save(b);		
		
		
		List<CustomerContact> allMyContacts = repo.findAll();
		for(CustomerContact people: allMyContacts) {
			System.out.println(people.toString());
		}
	((AbstractApplicationContext) appContext).close();
	}
}
