package com.example.emp.Controller;

import com.example.emp.Entity.EmployeeEntity;
import com.example.emp.Service.EmployeesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://project-file-frontend.onrender.com")
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
    @GetMapping("/{id}")
    public Optional<EmployeeEntity> details(@PathVariable Long id){
        return employeesServiceImp.searchId(id);
    }
    @GetMapping("/name/{name}")
    public Optional<EmployeeEntity> searchName(@PathVariable String name){
        return employeesServiceImp.searchName(name);
    }
    @PutMapping("/update/{id}")
    public EmployeeEntity updatedDetails(@PathVariable Long id,@RequestBody EmployeeEntity employeeEntity){
        return employeesServiceImp.updatedetails(id,employeeEntity);
    }@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        if (employeesServiceImp.deleteEmp(id)){
            return ResponseEntity.ok("Employee delete successfully..");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

}
