package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Category;

public class HibernateCategoryDao implements ICategoryDao{

private List<Category> categories=new ArrayList<Category>();
	
	@Override
	public List<Category> getAllCategories() {
		System.out.println("Hibernate ile Getirildi");
		return categories;
	}

	@Override
	public Category getCategory(int id) throws Exception {
		System.out.println("Hibernate ile getirildi");
		for (Category category: categories) {
			if (category.getId() == id) {
				return category;
			}
		}
		throw new Exception("Kategori Bulunamadı");
	}

	@Override
	public void addCategory(Category category) {
		System.out.println("Hibernate ile "+category.getName()+" adlı kategori veritabanına eklendi.");
		this.categories.add(category);
	}

	@Override
	public void updateCategory(Category category) {
		System.out.println("Hibernate ile "+category.getName()+" adlı kategori güncellendi");
	}

	@Override
	public void deleteCategory(Category category) {
		System.out.println("Hibernate ile "+category.getName()+" adlı kategori güncellendi");
		
	}

}
