/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.rabbitmq.second")
public class SecondRabbitConfiguration extends AbstractRabbitConfiguration {

	@Bean(name = "secondConnectionFactory")
	public ConnectionFactory secondConnectionFactory() {
		return super.connectionFactory();
	}

	@Bean(name = "secondRabbitTemplate")
	public RabbitTemplate secondRabbitTemplate(
			@Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}

	@Bean(name = "secondFactory")
	public SimpleRabbitListenerContainerFactory secondFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer,
			@Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory) {
		final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}

	@Bean(value = "secondRabbitAdmin")
	public RabbitAdmin secondRabbitAdmin(@Qualifier("secondConnectionFactory") ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
}