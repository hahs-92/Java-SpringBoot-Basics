package com.fundaments.springboot.fundaments;

import com.fundaments.springboot.fundaments.bean.MyBean;
import com.fundaments.springboot.fundaments.bean.MyBeanWithDependecy;
import com.fundaments.springboot.fundaments.bean.MyBeanWithProperties;
import com.fundaments.springboot.fundaments.component.ComponentDependency;
import com.fundaments.springboot.fundaments.entity.User;
import com.fundaments.springboot.fundaments.pojo.UserPojo;
import com.fundaments.springboot.fundaments.service.UserService;
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
	//service
	UserService userService;

	//constructor
	//@Qualifier -> le indicamos la clase que queremos que implement, en caso de que haya mas de una
	@Autowired // no es necesario
	public FundamentsApplication(
			@Qualifier("component2Implement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependecy myBeanWithDependecy,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository,
			UserService userService
	){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependecy = myBeanWithDependecy;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
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
		getInfoJpqlUser();
		saveWithErrorTransactional();
	}

	//
	private void saveWithErrorTransactional() {
		User user1 = new User("test1", "test1@mail.com", LocalDate.now());
		User user2 = new User("test2", "test2@mail.com", LocalDate.now());
		User user3 = new User("test3", "test3@mail.com", LocalDate.now());

		List<User> users = Arrays.asList(user1, user2, user3);

		userService.saveTransactional(users);

		userService.getAllUsers()
				.forEach(LOGGER::info);
	}

	private void getInfoJpqlUser() {
		/*
		LOGGER.info("User with email = " +
				userRepository.findByEmail("alex@gmail.com")
						.orElseThrow(() -> new RuntimeException("No se encontro el usuario"))
		);

		//no es necesario escribir todo el nombre del user
		userRepository.findAndSort("Al", Sort.by("id").descending())
				.forEach(LOGGER::info); // por si no se quiere usar stream, se usa el forEach de list
				//.stream()
				//.forEach(user -> LOGGER.info("USER SORT BY ID = " + user));

		//con query methods
		userRepository.findByName("Jess")
				.forEach(user -> LOGGER.info("User with Query Method: " + user));

		LOGGER.info("user with queryMethod: findByEmailAndName: " + userRepository.findByEmailAndName("daniela@domain.com", "Daniela")
				.orElseThrow(() -> new RuntimeException("User not found"))
		);

		//using LIKE sentence %""% -> contenga  ""% -> termine
		userRepository.findByNameLike("%ss%")
				.forEach(user -> LOGGER.info("USER LIKE: " + user));

		//OR puedo enviar solo un parametro
		userRepository.findByNameOrEmail(null, "alex@gmail.com")
				.forEach(user -> LOGGER.info("USER OR: " + user));



		//BETWEEN
		userRepository.findByBirthDateBetween(LocalDate.of(2021,8, 15), LocalDate.of(2021, 12, 11))
				.forEach(user -> LOGGER.info("BETWEEN: " + user));

		//LIKE + DESC
		userRepository.findByNameLikeOrderByIdDesc("Al%")
				.forEach(user -> LOGGER.info("DESC + LIKE: " + user));


		//CONTAIN -> parecido a like pero no hay que usa %%
		userRepository.findByNameContaining("Al")
				.forEach(user -> LOGGER.info("CONTENT: " + user));


		//IGNORECASE
		userRepository.findByNameIgnoreCase("aLeX")
				.forEach(user -> LOGGER.info("IGNORE_CASE: " + user));
		 */

		//JPQL NAMED PARAMS
		LOGGER.info("USERS JQPL: " +  userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,9,8), "daniela@domain.com")
				.orElseThrow(() -> new RuntimeException("User not found with JPQL"))
		);

		LOGGER.info("USER BY NAME DTO: "+ userRepository.getUserByName("Jess")
				.orElseThrow(() -> new RuntimeException("User not found with JPQL"))
		);

	}


	//metodo para registrar la informacion en la db
	private void saveUsersDB() {
		User user1 = new User("Alex","alex@gmail.com", LocalDate.of(2021, 12, 24));
		User user2 = new User("Jess","jess@gmail.com", LocalDate.of(2021, 8, 20));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Albaren", "karen@domain.com", LocalDate.of(2021, 1, 1));
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
