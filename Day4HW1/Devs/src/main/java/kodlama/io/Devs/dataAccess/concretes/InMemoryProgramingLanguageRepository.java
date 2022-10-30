package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgramingLanguage;

@Repository
public class InMemoryProgramingLanguageRepository implements ProgramingLanguageRepository {

	List<ProgramingLanguage> languages;

	public InMemoryProgramingLanguageRepository() {
		languages = new ArrayList<ProgramingLanguage>();
	}

	@Override
	public void add(ProgramingLanguage language) {
		languages.add(language);

	}

	@Override
	public void delete(ProgramingLanguage language){
		for(ProgramingLanguage l:languages) {
			if(l.getName().equals(language.getName())) {
				languages.remove(l);
				return;
			}
		}
	}

	@Override
	public void update(String Language, String newLanguage) {
		for (ProgramingLanguage l : languages) {
			if (l.getName().equals(Language) ) {
				l.setName(newLanguage);
				return;
			}
		}
	}

	@Override
	public ProgramingLanguage getId(int id) {
		for(ProgramingLanguage language:languages) {
			if(language.getId()==id) {
				return language;
			}
		}
		return null;
	}

	@Override
	public List<ProgramingLanguage> getAll() {
		return languages;
	}

}
