/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia;

import java.util.Map;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idbmobile.mcore.JsonObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractApi {

	@Autowired
	protected RestTemplate restTemplate;

	protected ResponseEntity<String> sendGetRequest(@URL String providerUrl, Map<String, String> parameters) {

		final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(providerUrl);

		parameters.entrySet().stream().forEach(e -> builder.queryParam(e.getKey(), e.getValue()));

		return restTemplate.getForEntity(builder.toUriString(), String.class);

	}

	protected ResponseEntity<String> sendPostMapParamsRequest(@URL String providerUrl, Map<String, String> parameters,
			MediaType mediaType) {

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);

		final HttpEntity<Map<String, String>> request = new HttpEntity<>(parameters, headers);

		return restTemplate.postForEntity(providerUrl, request, String.class);

	}

	protected ResponseEntity<String> sendPostObjectRequest(@URL String providerUrl, Object object, MediaType mediaType)
			throws JsonProcessingException {

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		final String jsonToPost = JsonObjectMapper.getInstance().writeValueAsString(object);
		headers.setContentLength(jsonToPost.getBytes().length);

		final HttpEntity<Object> request = new HttpEntity<>(jsonToPost, headers);

		log.debug("sendPostObjectRequest: url:" + providerUrl + " json to send " + jsonToPost
				+ " headers: content length " + headers.getContentLength() + " media type " + headers.getContentType()
				+ " rest of header: " + headers);

		return restTemplate.postForEntity(providerUrl, request, String.class);

	}
}
