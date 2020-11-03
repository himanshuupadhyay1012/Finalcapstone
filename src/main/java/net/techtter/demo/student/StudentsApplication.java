package net.techtter.demo.student;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 server.error.whitelabel.enabled=false
 @EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
	}
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})

}
