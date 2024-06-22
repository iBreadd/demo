package com.example.gitHub_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employeeList";
    }

    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @PostMapping
    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
}
