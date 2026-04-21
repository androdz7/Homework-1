package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.DepartmentInfoDTO;
import ge.ibsu.demo.entities.Department;
import ge.ibsu.demo.entities.Employee;
import ge.ibsu.demo.services.DepartmentService;
import ge.ibsu.demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    public DepartmentController(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    @GetMapping("/search")
    public List<DepartmentInfoDTO> search(@RequestParam(required = false) String country,
                                          @RequestParam(required = false) String city) {
        return departmentService.search(country, city);
    }

    @GetMapping("/all")
    public List<Department> getAll() {
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) throws Exception {
        return departmentService.getById(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable Long id) {
        return employeeService.getByDepartment(id);
    }

    @PostMapping("/add")
    public Department add(@RequestBody Department department) {
        return departmentService.save(department);
    }
}
