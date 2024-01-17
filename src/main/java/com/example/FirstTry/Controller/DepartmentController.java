package com.example.FirstTry.Controller;

import com.example.FirstTry.Entity.Department;
import com.example.FirstTry.Repos.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "api/department/")
public class DepartmentController {
    public final DepartmentRepository departmentRepository;
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public void registerNewDepartment(@RequestBody Department department){
        departmentRepository.save(department);
    }
    @GetMapping
    public List<String> getAllDepartmentNames() {
        return departmentRepository.findAll().stream()
                .map(Department::getDepartment) // Ensure this matches the getter method in Department
                .collect(Collectors.toList());
    }
}
