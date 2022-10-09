package kodlamaioWithLayeredArchitecture.dataAccess;

import java.util.List;

import kodlamaioWithLayeredArchitecture.entities.Instructor;

public interface IInstructorDao {
	List<Instructor> getAllInstructors();
	Instructor getInstructor(int id) throws Exception;
	void addInstructor(Instructor instructor);
	void updateInstructor(Instructor instructor);
	void deleteInstructor(Instructor instructor);
	
}
