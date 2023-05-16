package codegym.vn.springboot.service;

import codegym.vn.springboot.entity.ClassName;
import codegym.vn.springboot.repository.ClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameServiceImpl implements ClassNameService {
    @Autowired
    ClassNameRepository repository;

    @Override
    public void create(ClassName className) {
        repository.save(className);
    }

    @Override
    public void update(ClassName className) {
        repository.save(className);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClassName> findAll() {
        return repository.findAll();
    }

    @Override
    public ClassName findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
