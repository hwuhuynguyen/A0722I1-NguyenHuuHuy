package codegym.vn.springboot.service;

import codegym.vn.springboot.entity.Student;
import codegym.vn.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        System.out.println("Method findAll()");
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Student> findAllWithPaging(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Slice<Student> findAllWithSlice(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> findAllByNameAndEmail(String name, String email) {
        return studentRepository.findAllByNameContainsIgnoreCaseAndEmailContainsIgnoreCase(name, email);
    }

    @Override
    public void deleteAll(String[] ids) {
        studentRepository.deleteAllByIdIn(ids);
    }

    @Override
    public List<Student> findAllBySearchAll(String name, String email, String phoneNumber) {
        return studentRepository.findAllByNameContainingOrEmailContainingOrPhoneNumberContaining(name, email, phoneNumber);
    }
}
