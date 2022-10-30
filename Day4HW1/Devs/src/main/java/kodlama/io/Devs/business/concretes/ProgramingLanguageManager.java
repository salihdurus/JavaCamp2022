package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {

	ProgramingLanguageRepository languageRepository;

	@Autowired
	public ProgramingLanguageManager(ProgramingLanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	private boolean isLanguageEmpty(String language) {
		if (language == null || language.isEmpty() || language.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isLanguageExisting(String language) {
		for (ProgramingLanguage l : languageRepository.getAll()) {
			if (l.getName().equals(language)) {
				System.out.println("Burda");
				return true;
			}
		}
		return false;
	}

	private int getLastId() {
		int id = 0;
		for (ProgramingLanguage l : languageRepository.getAll()) {
			id = l.getId();
		}
		return id;
	}

	@Override
	public void add(ProgramingLanguage language) throws Exception {
		if (isLanguageEmpty(language.getName())) {
			throw new Exception("Programlama dili boş olamaz");
		} else if (isLanguageExisting(language.getName())) {
			throw new Exception("Bu programlama dili daha önce eklenmiş !");
		} else {
			int id = getLastId() + 1;
			language.setId(id);
			languageRepository.add(language);
		}

	}

	@Override
	public void delete(ProgramingLanguage language) {
		languageRepository.delete(language);
	}

	@Override
	public void update(String Language, String newLanguage) throws Exception {
		if (isLanguageEmpty(newLanguage)) {
			throw new Exception("Yeni programlama dili boş olamaz");
		} else if (isLanguageExisting(newLanguage)) {
			throw new Exception("Yeni girdiğiniz isim zaten var !");
		} else {
			languageRepository.update(Language, newLanguage);
		}
	}

	@Override
	public ProgramingLanguage getId(int id) {
		return languageRepository.getId(id);
	}

	@Override
	public List<ProgramingLanguage> getAll() {
		return languageRepository.getAll();
	}

}
