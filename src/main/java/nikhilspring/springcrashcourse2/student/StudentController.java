package nikhilspring.springcrashcourse2.student;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")

public class StudentController {

//    Reference student service
    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    GET Request
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();

    }

//    POST Request
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){ // using @RequestBody to map the JSON blob from the clinet and map into the db
        studentService.addNewStudent(student);
    }

    // Delete Request
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);

    }
}


