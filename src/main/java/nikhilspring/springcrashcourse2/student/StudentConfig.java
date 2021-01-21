package nikhilspring.springcrashcourse2.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {

        return args -> {
            Student john = new Student(
                    "John",
                    "John@name.com",
                    LocalDate.of(1998, Month.JANUARY, 01)
            );

            Student jane = new Student(
                    "Jane",
                    "Jane@name.com",
                    LocalDate.of(2000, Month.JANUARY, 02)
            );

//            Save to database by invoking the repository
            repository.saveAll(
                    List.of(john, jane)
            );
        };
    }
}
