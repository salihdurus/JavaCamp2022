package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguages.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguages.FindByIdProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.programmingLanguages.GetAllProgrammingLanguagesWithSubTechnologiesResponse;
import kodlama.io.Devs.business.responses.programmingLanguages.GetByIdProgrammingLanguageResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetSubTechnologyOnlyName;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.SubTechnology;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository languageRepository;
	private SubTechnologyRepository technologyRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository languageRepository,
			SubTechnologyRepository technologyRepository) {
		super();
		this.languageRepository = languageRepository;
		this.technologyRepository=technologyRepository;
	}

	private boolean isLanguageEmpty(String language) {
		if (language == null || language.isEmpty() || language.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isLanguageExisting(String language) {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		for (ProgrammingLanguage l : languages) {
			if (l.getName().equals(language)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();

		for (ProgrammingLanguage language : languages) {
			GetAllProgrammingLanguagesResponse languagesResponse = new GetAllProgrammingLanguagesResponse();
			languagesResponse.setId(language.getId());
			languagesResponse.setName(language.getName());
			getAllProgrammingLanguagesResponses.add(languagesResponse);
		}
		return getAllProgrammingLanguagesResponses;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage language = new ProgrammingLanguage();
		language.setName(createProgrammingLanguageRequest.getName());

		if (!isLanguageEmpty(createProgrammingLanguageRequest.getName())
				&& !isLanguageExisting(createProgrammingLanguageRequest.getName()))
			languageRepository.save(language);
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(
			FindByIdProgrammingLanguageRequest findByIdProgrammingLanguageRequest) {
		ProgrammingLanguage language = languageRepository.findById(findByIdProgrammingLanguageRequest.getId()).get();
		GetByIdProgrammingLanguageResponse languageResponse = new GetByIdProgrammingLanguageResponse();
		languageResponse.setId(language.getId());
		languageResponse.setName(language.getName());
		return languageResponse;
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		ProgrammingLanguage language = languageRepository.findById(deleteProgrammingLanguageRequest.getId()).get();
		languageRepository.delete(language);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguage) {
		ProgrammingLanguage language = languageRepository.findById(updateProgrammingLanguage.getId()).get();

		if (!isLanguageEmpty(updateProgrammingLanguage.getNewName())
				&& !isLanguageExisting(updateProgrammingLanguage.getNewName()))
			language.setName(updateProgrammingLanguage.getNewName());
		languageRepository.save(language);
	}

	@Override
	public List<GetAllProgrammingLanguagesWithSubTechnologiesResponse> getAllWithSubTechnologies() {
		List<ProgrammingLanguage> languages = languageRepository.findAll();
		List<SubTechnology> technologies = technologyRepository.findAll();
		List<GetAllProgrammingLanguagesWithSubTechnologiesResponse> languagesWithSubTechnologies = new ArrayList<GetAllProgrammingLanguagesWithSubTechnologiesResponse>();
		
		for (ProgrammingLanguage language : languages) {
			GetAllProgrammingLanguagesWithSubTechnologiesResponse response = new GetAllProgrammingLanguagesWithSubTechnologiesResponse();
			response.setId(language.getId());
			response.setName(language.getName());
			
			List<GetSubTechnologyOnlyName> t = new ArrayList<GetSubTechnologyOnlyName>();
			for (SubTechnology technology : technologies) {
				if(technology.getProgrammingLanguage().getId()==language.getId()) {
					GetSubTechnologyOnlyName subTechnologyOnlyName = new GetSubTechnologyOnlyName();
					subTechnologyOnlyName.setName(technology.getName());
					t.add(subTechnologyOnlyName);
				}
					
					
			}
			response.setTechnologies(t);
			languagesWithSubTechnologies.add(response);
		}
		return languagesWithSubTechnologies;
	}

}
