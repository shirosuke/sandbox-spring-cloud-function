package example;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FunctionConfiguration {
	@Autowired
	ObjectMapper om;

	public static void main(String[] args) {
		SpringApplication.run(FunctionConfiguration.class, args);
	}

	@Bean
	public Function<String, String> uppercase() {
		return String::toUpperCase;
	}

	@Bean
	public Function<String, Integer> wordcount() {
		return String::length;
	}

	@Bean
	public Function<ScheduledEvent, String> eventinfo() {
		return e -> {
			try {
				return om.writerWithDefaultPrettyPrinter().writeValueAsString(e);
			} catch (JsonProcessingException jsonProcessingException) {
				jsonProcessingException.printStackTrace();
			}
			return null;
		};
	}
}