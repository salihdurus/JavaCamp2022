package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Course;

public interface ICourseDao {
	List<Course> getAllCourses();
	Course getCourse(int id) throws Exception;
	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(Course course);
	
}
