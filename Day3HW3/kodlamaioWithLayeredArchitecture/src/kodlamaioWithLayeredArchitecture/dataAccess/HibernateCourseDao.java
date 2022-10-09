package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Course;

public class HibernateCourseDao implements ICourseDao{

private List<Course> courses=new ArrayList<Course>();
	
	@Override
	public List<Course> getAllCourses() {
		System.out.println("Hibernate ile getirildi");
		return courses;
	}

	@Override
	public Course getCourse(int id) throws Exception {
		System.out.println("Hibernate ile getirildi");
		for (Course course: courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		throw new Exception("Kurs Bulunamadı");
	}

	@Override
	public void addCourse(Course course) {
		System.out.println("Hibernate ile "+course.getName()+" Adlı Kurs Eklendi.");
		this.courses.add(course);
	}

	@Override
	public void updateCourse(Course course) {
		System.out.println("Hibernate ile "+course.getName()+" Adlı Kurs Güncellendi.");
		
	}

	@Override
	public void deleteCourse(Course course) {
		System.out.println("Hibernate ile "+course.getName()+" Adlı Kurs Silindi.");
		
	}

}
