package com.example.emp.Service;

import com.example.emp.Entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeesService {
    List<EmployeeEntity>employeesList();
    public boolean createEmployees(EmployeeEntity employee);
  public EmployeeEntity detailsId(Long id);
  public Optional<EmployeeEntity> searchName(String name);
  public EmployeeEntity updatedetails(Long id,EmployeeEntity employee);
}
