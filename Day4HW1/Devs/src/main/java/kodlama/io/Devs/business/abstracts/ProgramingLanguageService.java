package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageService {
	void add(ProgramingLanguage language) throws Exception;

	void delete(ProgramingLanguage language);

	void update(String Language, String newLanguage) throws Exception;

	ProgramingLanguage getId(int id);

	List<ProgramingLanguage> getAll();
	
}
