package edu.thn.ciom;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("edu.thn.ciom.dao")
public class CiomApplication {

    public static void main(String[] args) {
        SpringApplication.run(CiomApplication.class, args);
    }
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		//generateArtifacts();
//	}

//	private void generateArtifacts() throws Exception {
//		List<String> warnings = new ArrayList<>();
//		ConfigurationParser cp = new ConfigurationParser(warnings);
//		Configuration config = cp.parseConfiguration(
//				this.getClass().getResourceAsStream("/generatorConfig.xml"));
//		DefaultShellCallback callback = new DefaultShellCallback(true);
//		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//		myBatisGenerator.generate(null);
//	}
}
