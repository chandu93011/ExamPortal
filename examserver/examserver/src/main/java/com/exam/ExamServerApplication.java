package com.exam;

import com.exam.helper.userFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {

		SpringApplication.run(ExamServerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("starting code");

			User user = new User();
			user.setFirstName("chandan");
			user.setLastName("yadav");
			user.setUsername("chandan9803");
			user.setPassword(this.bCryptPasswordEncoder.encode("abcd"));
			user.setEmail("cy93011@gmail.com");
			user.setProfile("what.png");

			Role role1 = new Role();
			role1.setRoleId(45L);
			role1.setRoleName("ADMIN");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();

			userRole.setRole(role1);

			userRole.setUser(user);

			userRoleSet.add(userRole);

			this.userService.createUser(user, userRoleSet);
			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());
		}catch (userFoundException e){
		e.printStackTrace();
		}

	}
}
