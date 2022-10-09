package kodlamaioWithLayeredArchitecture.business;

import java.util.List;

import kodlamaioWithLayeredArchitecture.core.logging.ILogger;
import kodlamaioWithLayeredArchitecture.dataAccess.ICategoryDao;
import kodlamaioWithLayeredArchitecture.entities.Category;

public class CategoryManager {
	private List<ILogger> loggers;
	private ICategoryDao categoryDao;

	public CategoryManager(List<ILogger> loggers, ICategoryDao categoryDao) {
		this.loggers = loggers;
		this.categoryDao = categoryDao;
	}

	public void add(Category category) throws Exception {
		List<Category> categories =categoryDao.getAllCategories();
		boolean isThere=false;
		for(Category category2:categories) {
			if(category.getName()==category2.getName()) {
				isThere=true;
				break;
			}
		}
		
		if(!isThere) {
			categoryDao.addCategory(category);
			for(ILogger logger:loggers) {
				logger.log(category.getName()+ " İsimli Kategori Oluşturuldu.");
			}
		}
		else {
			throw new Exception("Kategori ismi tekrar edemez");
		}
		
	}

	public void update(Category category) {
		categoryDao.updateCategory(category);
		for(ILogger logger:loggers) {
			logger.log(category.getName()+ " İsimli Kategori Güncellendi.");
		}
	}

	public void delete(Category category) {
		categoryDao.deleteCategory(category);
		for(ILogger logger:loggers) {
			logger.log(category.getName()+ " İsimli Kategori Silindi.");
		}
	}

}
