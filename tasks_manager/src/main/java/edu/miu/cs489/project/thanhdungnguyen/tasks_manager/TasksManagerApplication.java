package edu.miu.cs489.project.thanhdungnguyen.tasks_manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Employee;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.model.Role;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.EmployeeRepository;
import edu.miu.cs489.project.thanhdungnguyen.tasks_manager.repository.RoleRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TasksManagerApplication {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TasksManagerApplication.class, args);
	}

	@PostConstruct
	public void initAdminUser() {
		var adminRole = new Role(null, "admin", null);
		roleRepository.save(adminRole);

		List<Role> listAdminRoles = new ArrayList<>();
		listAdminRoles.add(adminRole);

		var newAdminUser = new Employee(null, "Admin", "Admin", "Admin", "admin",
				passwordEncoder.encode("admin12345"), "admin@email.com", null, null,
				listAdminRoles, true, true, true, true);
		employeeRepository.save(newAdminUser);
	}

}
