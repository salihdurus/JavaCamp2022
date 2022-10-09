package kodlamaioWithLayeredArchitecture.business;

import java.util.List;

import kodlamaioWithLayeredArchitecture.core.logging.ILogger;
import kodlamaioWithLayeredArchitecture.dataAccess.IInstructorDao;
import kodlamaioWithLayeredArchitecture.entities.Instructor;

public class InstructorManager {
	
	private IInstructorDao instructorDao;
	private List<ILogger> loggers;
	
	public InstructorManager(IInstructorDao instructorDao,List<ILogger> loggers) {
		this.instructorDao=instructorDao;
		this.loggers=loggers;
	}
	
	public void add(Instructor instructor) {
		instructorDao.addInstructor(instructor);
		for(ILogger logger:loggers) {
			logger.log(instructor.getFirstName()+" Eklendi");
		}
	}
	
	public void update(Instructor instructor) {
		instructorDao.updateInstructor(instructor);
		for(ILogger logger:loggers) {
			logger.log(instructor.getFirstName()+" Güncellendi");
		}
	}
	
	public void delete(Instructor instructor) {
		instructorDao.deleteInstructor(instructor);
		for(ILogger logger:loggers) {
			logger.log(instructor.getFirstName()+" Silindi");
		}
	}
}
