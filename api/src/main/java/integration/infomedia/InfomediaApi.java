/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import integration.infomedia.json.request.PINGenerateWithParamsRequest;
import integration.infomedia.json.request.Param;
import integration.infomedia.json.request.SubscriptionJoinWithPinRequest;
import integration.infomedia.json.request.SubscriptionUnsubscribeRequest;
import integration.infomedia.json.response.PINGenerateWithParamsResponse;
import integration.infomedia.json.response.SubscriptionJoinWithPinResponse;
import integration.infomedia.json.response.SubscriptionUnsubscribeResponse;
import integration.infomedia.sms.InfomediaSmsClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class InfomediaApi extends AbstractApi {

	private static final String SUCCESS_RESPONSE = "Success";

	private static final String SERVICE_DESCRIPTION = "description test";

	private static final String TARIFF = "0.10";

	// TODO: put into properties
	private static final String HOST = "https://iab.wbg.infomediatechnologies.com";

	private static final String GENERATE_PIN_PATH = "/v/1/6/Default.asmx/PINGenerateWithParams";

	private static final String SUBSCRIPTION_JOIN_PATH = "/v/1/6/Default.asmx/SubscriptionJoinWithParams";
	private static final String UNSUBSCRIPTION_PATH = "/v/1/6/Default.asmx/SubscriptionUnsubscribe";

	private static final String DECRYPT_MX_PATH = "/V/1/6/Default.asmx/DecryptMX";

	private static final String SUBSCRIPTION_ID = "92000306";

	private static final String PRODUCT_ID = "8000462";

	private static final String MCC = "302";

	private static final String MNC = "22";

	private static final String USERNAME = "M081StAr";

	private static final String PASSWORD = "eir0jtp4K*@";

	private static final Gson gson = new Gson();

	private final InfomediaSmsClient infomediaSmsClient;

	/**
	 *
	 * @see https://api-docs.infomedia.co.uk/#mobile-payments-api-pin-generate-with-params
	 *
	 * @param msisdn
	 * @return ApiResponse
	 * @throws JsonProcessingException
	 */
	public ApiResponse generatePinCode(String msisdn) throws JsonProcessingException {

		final List<Param> params = Arrays.asList(new Param("amount", TARIFF), new Param("frequency", "day"),
				new Param("language", "en"), new Param("description", SERVICE_DESCRIPTION));

		final PINGenerateWithParamsRequest infomediaPinGenerateRequest = new PINGenerateWithParamsRequest(PRODUCT_ID,
				msisdn, MCC, MNC, USERNAME, PASSWORD, params);

		final ResponseEntity<String> sendPostRequest = sendPostObjectRequest(HOST + GENERATE_PIN_PATH,
				infomediaPinGenerateRequest, MediaType.APPLICATION_JSON);

		log.debug(MessageFormat.format("generatePinCode {0} - {1}", sendPostRequest.getHeaders(),
				sendPostRequest.getBody()));

		if (gson.fromJson(sendPostRequest.getBody(), PINGenerateWithParamsResponse.class).getD().getStatus()
				.equalsIgnoreCase(SUCCESS_RESPONSE)) {
			return new ApiResponse(true, gson.fromJson(sendPostRequest.getBody(), PINGenerateWithParamsResponse.class)
					.getD().getDescription());
		} else {
			return new ApiResponse(false, gson.fromJson(sendPostRequest.getBody(), PINGenerateWithParamsResponse.class)
					.getD().getDescription());
		}

	}

	/**
	 * @see https://api-docs.infomedia.co.uk/#mobile-payments-api-subscription-join-with-params
	 *
	 * @param msisdn
	 * @param pinCode
	 * @return ApiResponse
	 * @throws JsonProcessingException
	 */
	public ApiResponse subscribeWithPin(String msisdn, String pinCode, String correlationId)
			throws JsonProcessingException {

		final List<Param> params = Arrays.asList(new Param("PIN", pinCode), new Param("PTSubscriberID", correlationId));

		final SubscriptionJoinWithPinRequest subscriptionJoinWithPinRequest = new SubscriptionJoinWithPinRequest(
				PRODUCT_ID, msisdn, MCC, MNC, USERNAME, PASSWORD, params);

		final ResponseEntity<String> sendPostRequest = sendPostObjectRequest(HOST + SUBSCRIPTION_JOIN_PATH,
				subscriptionJoinWithPinRequest, MediaType.APPLICATION_JSON);

		log.debug(MessageFormat.format("subscribeWithPin {0} - {1}", sendPostRequest.getHeaders(),
				sendPostRequest.getBody()));

		if (gson.fromJson(sendPostRequest.getBody(), SubscriptionJoinWithPinResponse.class).getD().getStatus()
				.equalsIgnoreCase(SUCCESS_RESPONSE)) {
			return new ApiResponse(true, gson.fromJson(sendPostRequest.getBody(), SubscriptionJoinWithPinResponse.class)
					.getD().getDescription());
		} else {
			return new ApiResponse(false,
					gson.fromJson(sendPostRequest.getBody(), SubscriptionJoinWithPinResponse.class).getD()
							.getDescription());
		}

	}

	/**
	 *
	 * @see https://api-docs.infomedia.co.uk/#mobile-payments-api-subscription-unsubscribe
	 * @param msisdn
	 * @return true if unsubscripction was success, false otherwise
	 * @throws JsonProcessingException
	 */
	public boolean unsubscribe(String msisdn) throws JsonProcessingException {

		final SubscriptionUnsubscribeRequest subscriptionUnsubscribeRequest = new SubscriptionUnsubscribeRequest(
				SUBSCRIPTION_ID, msisdn, MCC, MNC, USERNAME, PASSWORD);

		final ResponseEntity<String> sendPostRequest = sendPostObjectRequest(HOST + UNSUBSCRIPTION_PATH,
				subscriptionUnsubscribeRequest, MediaType.APPLICATION_JSON);

		log.debug(
				MessageFormat.format("unsubscribe {0} - {1}", sendPostRequest.getHeaders(), sendPostRequest.getBody()));

		return gson.fromJson(sendPostRequest.getBody(), SubscriptionUnsubscribeResponse.class).getD().getStatus()
				.equalsIgnoreCase(SUCCESS_RESPONSE);
	}

	/**
	 * @see https://api-docs.infomedia.co.uk/#sms-api
	 *
	 * @param msisdn
	 * @param contentPassword
	 * @return
	 */
	public String sendSms(String msisdn, String contentPassword) {

		return infomediaSmsClient.sendSms(msisdn, contentPassword).getSendMessageWithCampaignResult().getStatus();

	}

}
