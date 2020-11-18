/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia.sms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 *
 * Configuration for Web Service client.
 *
 * @author Rafael Reyes Lopez
 * @email rafael.reyes.lopez@idbmobile.com
 * @date 2020-10-26
 *
 */
@Configuration
public class InfomediaSmsClientConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("integration.infomedia.sms.domain");
		return marshaller;
	}

	@Bean
	public InfomediaSmsClient infomediaSmsClient(Jaxb2Marshaller marshaller) {
		final InfomediaSmsClient client = new InfomediaSmsClient();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}