package com.example.finaltest.service.company;

import com.example.finaltest.entity.Company;
import com.example.finaltest.repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void removeById(String id) {
        companyRepository.deleteById(id);
    }
}
