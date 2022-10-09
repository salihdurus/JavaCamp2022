package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Instructor;

public class HibernateInstructorDao implements IInstructorDao{
	
	private List<Instructor> instructors = new ArrayList<Instructor>();

	@Override
	public List<Instructor> getAllInstructors() {
		System.out.println("Hibernate ile getirildi");
		return instructors;
	}

	@Override
	public Instructor getInstructor(int id) throws Exception {
		System.out.println("Hibernate ile getirildi");
		for (Instructor instructor : instructors) {
			if (instructor.getId() == id) {
				return instructor;
			}
		}
		throw new Exception("Eğitmen Bulunamadı");
	}

	@Override
	public void addInstructor(Instructor instructor) {
		System.out.println("Hibernate ile "+instructor.getFirstName()+" veritabanına eklendi.");
		this.instructors.add(instructor);

	}

	@Override
	public void updateInstructor(Instructor instructor) {
		System.out.println("Hibernate ile "+instructor.getFirstName() + " Adlı Eğitmen Güncellendi");
	}

	@Override
	public void deleteInstructor(Instructor instructor) {
		System.out.println("Hibernate ile "+instructor.getFirstName() + " Adlı Eğitmen Silindi");

	}


}
