package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.Devs.entities.concretes.ProgramingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgramingLanguageService languageService;

	@Autowired
	public ProgrammingLanguagesController(ProgramingLanguageService languageService) {
		this.languageService=languageService;
	}
	
	@GetMapping("/getall")
	public List<ProgramingLanguage> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(ProgramingLanguage language) throws Exception {
		languageService.add(language);
	}
	
	@DeleteMapping("/delete")
	public void delete(ProgramingLanguage language){
		languageService.delete(language);
	}
	
	@GetMapping("/getId")
	public ProgramingLanguage getId(int id) {
		return languageService.getId(id);
	}
	
	@PostMapping("/update")
	public void update(String language,String newLanguage) throws Exception {
		languageService.update(language, newLanguage);
	}
}
