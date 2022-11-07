package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnologies.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.FindByIdSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;

@RestController
@RequestMapping("/api/subTechnologies")
public class SubTechnologyController {
	
	SubTechnologyService technologyService;
	
	@Autowired
	public SubTechnologyController(SubTechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		technologyService.add(createSubTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologiesResponse> getAll(){
		return technologyService.getAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		technologyService.delete(deleteSubTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		technologyService.update(updateSubTechnologyRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdSubTechnologyResponse getById(FindByIdSubTechnologyRequest request) {
		return technologyService.getById(request);
	}
}
