package edu.thn.ciom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.thn.ciom.dao")
public class CiomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiomApplication.class, args);
	}

}
