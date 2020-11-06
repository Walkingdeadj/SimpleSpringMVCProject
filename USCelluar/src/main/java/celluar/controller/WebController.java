package celluar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import celluar.beans.CustomerContact;
import celluar.repository.CustomerRepository;

@Controller
public class WebController {
	@Autowired
	CustomerRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllContacts(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewContact(model);
		}
		model.addAttribute("contacts", repo.findAll());
		return "result";
	}
	
	@GetMapping("/inputContact")
	public String addNewContact(Model model) {
		CustomerContact c = new CustomerContact();
		model.addAttribute("newContact", c);
		return "input";
	}
	
	@PostMapping("/inputContact")
	public String addNewContact(@ModelAttribute CustomerContact c, Model model) {
		repo.save(c);
		return viewAllContacts(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateContact(@PathVariable("id") long id, Model model) {
		CustomerContact c = repo.findById(id).orElse(null);
		model.addAttribute("newContact", c);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseContact(CustomerContact c, Model model) {
		repo.save(c);
		return viewAllContacts(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		CustomerContact c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllContacts(model);
	}
}
