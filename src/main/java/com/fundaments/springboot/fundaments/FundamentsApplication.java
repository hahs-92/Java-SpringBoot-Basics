package com.fundaments.springboot.fundaments;

import com.fundaments.springboot.fundaments.bean.MyBean;
import com.fundaments.springboot.fundaments.bean.MyBeanWithDependecy;
import com.fundaments.springboot.fundaments.bean.MyBeanWithProperties;
import com.fundaments.springboot.fundaments.component.ComponentDependency;
import com.fundaments.springboot.fundaments.entity.Post;
import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//repositories
import com.fundaments.springboot.fundaments.repository.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {
	//vamos a hacer una inyecion de dependencia
	private ComponentDependency componentDependency;

	//own dependencies
	private MyBean myBean;
	//dependecy with other dependency
	private MyBeanWithDependecy myBeanWithDependecy;
	//dependency with configuration
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	private final Log LOGGER = LogFactory.getLog(FundamentsApplication.class);

	//repository
	UserRepository userRepository;


	//constructor
	//@Qualifier -> le indicamos la clase que queremos que implement, en caso de que haya mas de una
	@Autowired // no es necesario
	public FundamentsApplication(
			@Qualifier("component2Implement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependecy myBeanWithDependecy,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository
	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependecy = myBeanWithDependecy;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		componentDependency.greet();
		myBean.print();
		myBeanWithDependecy.printWithDependecy();
		System.out.println("name = " +  myBeanWithProperties.getName());
		System.out.println("username =" + userPojo.getUsername());

		try {
			int value = 10/0;
			LOGGER.debug("my value es: " + value); // no llegara aqui
		} catch (Exception ex) {
			LOGGER.error("This is an Error " + ex.getMessage());
		}
		 */

		saveUsersDB();
	}

	//metodo para registrar la informacion en la db
	private void saveUsersDB() {
		User user1 = new User("Alex","alex@gmail.com", LocalDate.of(2021, 12, 24));
		User user2 = new User("Jess","jess@gmail.com", LocalDate.of(2021, 8, 20));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));

		List<User> listUsers = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9);
		userRepository.saveAll(listUsers);
		//otra forma de hacerlo
		//listUsers.stream().forEach(userRepository::save);
	}
}
