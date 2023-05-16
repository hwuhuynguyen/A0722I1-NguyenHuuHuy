package codegym.vn.springboot.repository;

import codegym.vn.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByNameContainsIgnoreCaseAndEmailContainsIgnoreCase(String name, String email);
    void deleteAllByIdIn(String[] ids);
    List<Student> findAllByNameContainingOrEmailContainingOrPhoneNumberContaining(String name, String email, String phoneNumber);
}
