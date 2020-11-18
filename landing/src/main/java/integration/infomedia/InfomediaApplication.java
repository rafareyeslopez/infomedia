/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rafael Reyes Lopez
 * @email rafael.reyes.lopez@idbmobile.com
 * @date 2020-10-26
 *
 */
@SpringBootApplication
@ComponentScan({ "com.idbmobile", "integration.infomedia" })
public class InfomediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfomediaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}

}
