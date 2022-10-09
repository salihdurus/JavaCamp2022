package kodlamaioWithLayeredArchitecture.business;

import java.util.List;

import kodlamaioWithLayeredArchitecture.core.logging.ILogger;
import kodlamaioWithLayeredArchitecture.dataAccess.ICourseDao;
import kodlamaioWithLayeredArchitecture.entities.Course;

public class CourseManager {

	private List<ILogger> loggers;
	private ICourseDao courseDao;

	public CourseManager(List<ILogger> loggers, ICourseDao courseDao) {
		this.loggers = loggers;
		this.courseDao = courseDao;
	}

	public void add(Course course) throws Exception {

		List<Course> courses = courseDao.getAllCourses();
		boolean isThere = false;
		for(Course course2:courses) {
			if(course.getName()==course2.getName()) {
				isThere=true;
				break;
			}
		}
		if(course.getPrice()<0) {
			throw new Exception("Bir kursun fiyatı 0 dan küçük olamaz");
		}
		else if(!isThere && !(course.getPrice()<0)) {
			courseDao.addCourse(course);
			for(ILogger logger:loggers) {
				logger.log(course.getName() +" Adlı Kurs Eklendi");
			}
		}
		else {
			throw new Exception("Kurs ismi tekrar edemez");
		}
	}

	public void update(Course course) {
		courseDao.updateCourse(course);
		for(ILogger logger:loggers) {
			logger.log(course.getName() +" Adlı Kurs Güncellendi");
		}
	}

	public void delete(Course course) {
		courseDao.deleteCourse(course);
		for(ILogger logger:loggers) {
			logger.log(course.getName() +" Adlı Kurs Silindi");
		}
	}

}
