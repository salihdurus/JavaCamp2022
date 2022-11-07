package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguages.FindByIdProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.programmingLanguages.GetAllProgrammingLanguagesWithSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguageController {

	private ProgrammingLanguageService languageService;

	@Autowired
	public ProgrammingLanguageController (ProgrammingLanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest languageRequest) {
		languageService.add(languageRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdProgrammingLanguageResponse getById(FindByIdProgrammingLanguageRequest byIdProgrammingLanguageRequest) {
		return languageService.getById(byIdProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		languageService.delete(deleteProgrammingLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguage) {
		languageService.update(updateProgrammingLanguage);
	}
	
	@GetMapping("/getAllWithSubTechnologies")
	public List<GetAllProgrammingLanguagesWithSubTechnologiesResponse> getAllWithSubTechnologies(){
		return languageService.getAllWithSubTechnologies();
	}
}
