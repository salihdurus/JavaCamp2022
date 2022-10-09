package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Category;

public class JdbcCategoryDao implements ICategoryDao{

	private List<Category> categories=new ArrayList<Category>();
	
	@Override
	public List<Category> getAllCategories() {
		System.out.println("JDBC ile Getirildi");
		return categories;
	}

	@Override
	public Category getCategory(int id) throws Exception {
		System.out.println("JDBC ile getirildi");
		for (Category category: categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		throw new Exception("Kategori Bulunamadı");
	}

	@Override
	public void addCategory(Category category) {
		System.out.println("JDBC ile "+category.getName()+" adlı kategori veritabanına eklendi.");
		this.categories.add(category);
	}

	@Override
	public void updateCategory(Category category) {
		System.out.println("JDBC ile "+category.getName()+" adlı kategori güncellendi");
	}

	@Override
	public void deleteCategory(Category category) {
		System.out.println("JDBC ile "+category.getName()+" adlı kategori güncellendi");
		
	}

}
