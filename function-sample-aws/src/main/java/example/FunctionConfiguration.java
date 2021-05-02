package example;

import java.util.function.Consumer;
import java.util.function.Function;

import com.amazonaws.services.lambda.runtime.events.CloudWatchLogsEvent;
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FunctionConfiguration {

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
			// TODO Java8のDatetimeに対応させる
			ObjectMapper om = new ObjectMapper();
			try {
				return om.writerWithDefaultPrettyPrinter().writeValueAsString(e);
			} catch (JsonProcessingException jsonProcessingException) {
				jsonProcessingException.printStackTrace();
			}
			return null;
		};
	}
}