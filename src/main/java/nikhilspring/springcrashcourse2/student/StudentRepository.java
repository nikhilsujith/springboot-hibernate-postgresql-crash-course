package nikhilspring.springcrashcourse2.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Integer>  {  //<Student, type of student.id>

/*//    AUTO completed
//    Equivalent to SELECT * FROM STUDENT WHERE EMAIL = "email"
    Optional<Student> findStudentByEmail(String email);*/

//    OR
//    JBQL not SQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
