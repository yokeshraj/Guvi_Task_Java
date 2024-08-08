package com.example.demo.Controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Show form
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    // Handle form submission
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees/all";
    }

    // Display all employees
    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable String id, Model model) {
        Optional<Employee> employee = employeeRepository.findById(id);
        model.addAttribute("employee", employee.orElse(null));
        return "employeeDetail";
    }
}
