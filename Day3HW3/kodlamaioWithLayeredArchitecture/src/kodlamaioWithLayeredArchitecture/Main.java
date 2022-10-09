package kodlamaioWithLayeredArchitecture;

import java.util.ArrayList;
import java.util.List;

import kodlamaioWithLayeredArchitecture.business.CategoryManager;
import kodlamaioWithLayeredArchitecture.business.CourseManager;
import kodlamaioWithLayeredArchitecture.business.InstructorManager;
import kodlamaioWithLayeredArchitecture.core.logging.DatabaseLogger;
import kodlamaioWithLayeredArchitecture.core.logging.ILogger;
import kodlamaioWithLayeredArchitecture.core.logging.MailLogger;
import kodlamaioWithLayeredArchitecture.core.logging.SmsLogger;
import kodlamaioWithLayeredArchitecture.dataAccess.HibernateCourseDao;
import kodlamaioWithLayeredArchitecture.dataAccess.HibernateInstructorDao;
import kodlamaioWithLayeredArchitecture.dataAccess.JdbcCategoryDao;
import kodlamaioWithLayeredArchitecture.dataAccess.JdbcInstructorDao;
import kodlamaioWithLayeredArchitecture.entities.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Instructor instructor = new Instructor(1, "Salih", "Dürüs", "Gelişmekte olan bir öğrenci", "");
		Instructor instructor2 = new Instructor(2, "Engin", "Demiroğ", "PMP,ITIL", "");

		Category category = new Category(1, "Yazılım");
		Category category2 = new Category(2, "Veritabanı");
		Category category3 = new Category(3, "Görüntü İşleme");
		Category category4 = new Category(4, "Yazılım");

		Course course = new Course(1, "(2022) Yazılım Geliştirici Yetiştirme Kampı", "Kamp", -20, "", category,
				instructor2);
		Course course2 = new Course(2, "Programlamaya Giriş için Temel Kurs", "Kamp", 20, "", category, instructor2);
		Course course3 = new Course(3, "Programlamaya Giriş için Temel Kurs", "Kamp", 30, "", category, instructor2);

		List<ILogger> loggers = new ArrayList<ILogger>();
		loggers.add(new DatabaseLogger());
		loggers.add(new MailLogger());
		loggers.add(new SmsLogger());

		InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(), loggers);
		instructorManager.add(instructor);

		InstructorManager instructorManager2 = new InstructorManager(new HibernateInstructorDao(), loggers);
		instructorManager2.add(instructor2);

		CategoryManager categoryManager = new CategoryManager(loggers, new JdbcCategoryDao());
		categoryManager.add(category);
		categoryManager.add(category2);
		categoryManager.add(category3);
//		categoryManager.add(category4);

		CourseManager courseManager=new CourseManager(loggers, new HibernateCourseDao());
		courseManager.add(course);
		courseManager.add(course2);
//		courseManager.add(course3);
	}

}
