package com.example.emp.Repository;

import com.example.emp.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long> {
    Optional<EmployeeEntity> findByName(String name);
}
