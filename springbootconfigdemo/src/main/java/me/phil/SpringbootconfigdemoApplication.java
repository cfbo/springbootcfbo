package me.phil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
// Map properties to POJO
@EnableConfigurationProperties
public class SpringbootconfigdemoApplication {
	
	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.out.println("Setting project name " + projectName);
	}
	
	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("Setting environment: " + env.getProperty("configuration.projectName"));
	}
	
	@Autowired
	void setConfigurationProjectProperties(ConfigurationProjectProperties p) {
		System.out.println("Setting configuration project properties " + p);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootconfigdemoApplication.class, args);
	}
}


@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		System.out.println("Setting Configuration Project Properties project name = " + projectName);
		this.projectName = projectName;
	}
	
}