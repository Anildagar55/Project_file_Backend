package com.example.emp.Controller;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Service.EmployeesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeesServiceImp employeesServiceImp;
    @GetMapping
    public List<EmployeeEntity>showdetails(){
        return employeesServiceImp.employeesList();
    }
    @PostMapping
    public boolean createEmployee(@RequestBody EmployeeEntity employee){
        return employeesServiceImp.createEmployees(employee);
    }
    @GetMapping("/show/id/{id}")
    public EmployeeEntity details(@PathVariable Long id){
        return employeesServiceImp.detailsId(id);
    }
    @GetMapping("/show/name/{name}")
    public Optional<EmployeeEntity> searchName(@PathVariable String name){
        return employeesServiceImp.searchName(name);
    }
    @PatchMapping("/update/{id}")
    public EmployeeEntity updatedDetails(@PathVariable Long id,@RequestBody EmployeeEntity employeeEntity){
        return employeesServiceImp.updatedetails(id,employeeEntity);
    }
}
