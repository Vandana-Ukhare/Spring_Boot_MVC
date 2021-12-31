package com.vandu.Controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vandu.Entity.Employee;
import com.vandu.Service.IEmployeeMgmtService;

@Controller("controller")
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService service;

	@GetMapping("/")
	public String showHome() {
		System.out.println("EmployeeController.showHome()");
		return "home";

	}
//to get employee report(all employee record)
	/*@GetMapping("/emp_report")
	public String getEmpReport(Map<String, Object> map) {
		System.out.println("EmployeeController.getEmpReport()");
		// use service class
		Iterable<Employee> empList = service.getAllEmployee();
		empList.forEach(System.out::print);
		System.out.println("EmployeeController.getEmpReport()empList.size:");
		map.put("empList", empList);
		// return LVN
		return "report";
	}*/
	
	//to get Pagination data
	@GetMapping("/emp_report")
	public String getEmpReport(@PageableDefault(page = 0,size = 3,sort="empno",direction = Sort.Direction.ASC) Pageable pageable, Map<String, Object> map) {
		System.out.println("EmployeeController.getEmpReport()");
		// use service class
		Page<Employee> pageData= service.showPageData(pageable);
		
		map.put("pageData", pageData);
		// return LVN
		return "report";
	}

	@GetMapping("/insert_employee")
	public String showAddEmployeeForm(@ModelAttribute("emp")Employee emp) {
		System.out.println("EmployeeController.showAddEmployeeForm()");
		return "add_employee";
	}
//(insert operation using PRG pattern)
	@PostMapping("/insert_employee")
	public String addEmployee(RedirectAttributes rd, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.addEmployee()");
		String result = service.insertEmployee(emp);
		rd.addFlashAttribute(result);
		return "redirect:emp_report";
	}
	
	//(insert operation using Session obj)
	/*@PostMapping("/insert_employee")
	public String addEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.addEmployee()");
		String result = service.insertEmployee(emp);
		ses.setAttribute("result", result);
		return "redirect:emp_report";
	}*/
	
	
	
	@GetMapping("/edit_employee")
	public String showEditForm(@RequestParam("empno") int no,@ModelAttribute("emp")Employee emp) {
		//use service class
		Employee emp1=service.getEmployeeById(no);
		BeanUtils.copyProperties(emp1, emp);
		return "edit";
		
	}
	@PostMapping("/edit_employee")
	public String editEmployee(RedirectAttributes rd,@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeController.editEmployee()");
		//use service class
		String result=service.updateEmployeeByID(emp);
		rd.addAttribute("result",result);
		return "redirect:emp_report";
		
	}
	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam("empno") int eno,HttpSession ses) {
		System.out.println("EmployeeController.deleteEmployee()");
		//use service class
		String result=service.removeEmployeeById(eno);
		//rd.addAttribute("result", result);
		//rd.addFlashAttribute("result",result);
		ses.setAttribute("result", result);
		return "redirect:emp_report";
	}
	

}
