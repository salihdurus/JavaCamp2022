package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Category;

public interface ICategoryDao {
	List<Category> getAllCategories();
	Category getCategory(int id) throws Exception;
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Category category);
}
