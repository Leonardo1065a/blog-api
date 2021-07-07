package br.com.leonardo.blogui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.leonardo.blogui.config.property.BlogApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(BlogApiProperty.class)
public class BlogUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogUiApplication.class, args);
	}

}
