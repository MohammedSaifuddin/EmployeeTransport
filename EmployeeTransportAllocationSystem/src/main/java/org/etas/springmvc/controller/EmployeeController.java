package org.etas.springmvc.controller;

import java.util.List;

import org.etas.springmvc.bean.Employee;
import org.etas.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getEmployees(Model model) {

        List<Employee> listOfEmployees = employeeService.getAllEmployees();
        model.addAttribute("employee", new Employee());
        model.addAttribute("listOfEmployees", listOfEmployees);
        return "employeeDetails";
    }

    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }

        return "redirect:/getAllEmployees";
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", this.employeeService.getEmployee(id));
        model.addAttribute("listOfEmployees", this.employeeService.getAllEmployees());
        return "employeeDetails";
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/getAllEmployees";

    }
}
