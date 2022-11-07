package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.subTechnologies.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.FindByIdSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {
	List<GetAllSubTechnologiesResponse> getAll();
	void add(CreateSubTechnologyRequest createSubTechnologyRequest);
	void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);
	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);
	GetByIdSubTechnologyResponse getById(FindByIdSubTechnologyRequest byIdSubTechnologyRequest);
}
