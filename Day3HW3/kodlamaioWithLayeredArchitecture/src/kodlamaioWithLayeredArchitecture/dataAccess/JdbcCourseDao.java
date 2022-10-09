package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Course;

public class JdbcCourseDao implements ICourseDao{

	private List<Course> courses=new ArrayList<Course>();
	
	@Override
	public List<Course> getAllCourses() {
		System.out.println("JDBC ile getirildi");
		return courses;
	}

	@Override
	public Course getCourse(int id) throws Exception {
		System.out.println("JDBC ile getirildi");
		for (Course course: courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		throw new Exception("Kurs Bulunamadı");
	}

	@Override
	public void addCourse(Course course) {
		System.out.println("JDBC ile "+course.getName()+" Adlı Kurs Eklendi.");
		this.courses.add(course);
	}

	@Override
	public void updateCourse(Course course) {
		System.out.println("JDBC ile "+course.getName()+" Adlı Kurs Güncellendi.");
		
	}

	@Override
	public void deleteCourse(Course course) {
		System.out.println("JDBC ile "+course.getName()+" Adlı Kurs Silindi.");
		
	}
}
