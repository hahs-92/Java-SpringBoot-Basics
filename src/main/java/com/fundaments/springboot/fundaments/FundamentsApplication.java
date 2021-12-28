package com.fundaments.springboot.fundaments;

import com.fundaments.springboot.fundaments.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentsApplication implements CommandLineRunner {
	//vamos a hacer una inyecion de dependencia
	private ComponentDependency componentDependency;

	//constructor
	//@Qualifier -> le indicamos la clase que queremos que implement, en caso de que haya mas de una
	@Autowired // no es necesario
	public FundamentsApplication(@Qualifier("component2Implement") ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
	}
}
