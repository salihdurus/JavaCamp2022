package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.ProgramingLanguage;

public interface ProgramingLanguageRepository {
	void add(ProgramingLanguage language);

	void update(String Language, String newLanguage);

	void delete(ProgramingLanguage language);

	List<ProgramingLanguage> getAll();

	ProgramingLanguage getId(int id);
}
