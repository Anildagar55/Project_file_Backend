package com.example.emp.Service;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImp implements EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;
    @Override
    public List<EmployeeEntity> employeesList() {
        return employeesRepository.findAll();
    }

    @Override
    public boolean createEmployees(EmployeeEntity employee) {
        employeesRepository.save(employee);
        return true;
    }

    @Override
    public EmployeeEntity detailsId(Long id) {
        return employeesRepository.getById(id);
}

    @Override
    public Optional<EmployeeEntity> searchName(String name) {
        return employeesRepository.getByName(name);
    }

    @Override
    public EmployeeEntity updatedetails(Long id,EmployeeEntity employee) {
        EmployeeEntity employeeEntity=employeesRepository.getById(id);
        employeeEntity.setType(employee.getType());
        employeeEntity.setName(employee.getName());
        employeeEntity.setSalary(employee.getSalary());
        return employeesRepository.save(employeeEntity);
    }


}
