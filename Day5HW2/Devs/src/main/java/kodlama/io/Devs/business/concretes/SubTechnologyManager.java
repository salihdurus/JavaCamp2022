package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnologies.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.FindByIdSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnologies.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {

	SubTechnologyRepository technologyRepository;
	ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository technologyRepository,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		super();
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	private boolean isNameEmpty(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isSubTechnologyExisting(String subTechnologyName) {
		List<SubTechnology> technologies = technologyRepository.findAll();
		for (SubTechnology technology : technologies) {
			if (technology.getName().equals(subTechnologyName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> technologies = technologyRepository.findAll();
		List<GetAllSubTechnologiesResponse> getAllSubTechnologiesResponses = new ArrayList<GetAllSubTechnologiesResponse>();

		for (SubTechnology technology : technologies) {
			GetAllSubTechnologiesResponse response = new GetAllSubTechnologiesResponse();
			response.setId(technology.getId());
			response.setName(technology.getName());
			response.setProgrammingLanguageName(technology.getProgrammingLanguage().getName());
			getAllSubTechnologiesResponses.add(response);
		}
		return getAllSubTechnologiesResponses;

	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		if (!isNameEmpty(createSubTechnologyRequest.getName())
				&& !isNameEmpty(createSubTechnologyRequest.getProgrammingLanguageName())
				&& !isSubTechnologyExisting(createSubTechnologyRequest.getName())) {
			SubTechnology subTechnology = new SubTechnology();
			subTechnology.setName(createSubTechnologyRequest.getName());

			List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();

			ProgrammingLanguage language = new ProgrammingLanguage();

			for (ProgrammingLanguage programmingLanguage : languages) {
				if (programmingLanguage.getName().equals(createSubTechnologyRequest.getProgrammingLanguageName())) {
					language = programmingLanguage;
					break;
				}
			}
			if (language != null) {
				SubTechnology technology = new SubTechnology();
				technology.setName(createSubTechnologyRequest.getName());
				technology.setProgrammingLanguage(language);
				technologyRepository.save(technology);
			}
		}
	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		SubTechnology subTechnology = technologyRepository.findById(deleteSubTechnologyRequest.getId()).get();
		technologyRepository.delete(subTechnology);

	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		if (!isNameEmpty(updateSubTechnologyRequest.getNewName())
				&& !isSubTechnologyExisting(updateSubTechnologyRequest.getNewName())) {
			SubTechnology technology = technologyRepository.findById(updateSubTechnologyRequest.getId()).get();
			technology.setName(updateSubTechnologyRequest.getNewName());
			technologyRepository.save(technology);
		}

	}

	@Override
	public GetByIdSubTechnologyResponse getById(FindByIdSubTechnologyRequest byIdSubTechnologyRequest) {
		GetByIdSubTechnologyResponse response=new GetByIdSubTechnologyResponse();
		SubTechnology technology = technologyRepository.findById(byIdSubTechnologyRequest.getId()).get();
		response.setId(technology.getId());
		response.setName(technology.getName());
		response.setProgrammingLanguage(technology.getProgrammingLanguage().getName());
		return response;
		
	}

}
