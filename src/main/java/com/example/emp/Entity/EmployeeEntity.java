package com.example.emp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "emp")
public class EmployeeEntity {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String phoneNumber;
    private String email;
    private double salary;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[]image;
}
