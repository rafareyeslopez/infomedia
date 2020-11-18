/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia.sms;

import java.text.MessageFormat;
import java.util.UUID;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import integration.infomedia.sms.domain.ArrayOfMSISDNDetails;
import integration.infomedia.sms.domain.MSISDNDetails;
import integration.infomedia.sms.domain.SendMessageWithCampaign;
import integration.infomedia.sms.domain.SendMessageWithCampaignResponse;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * Web Service client for sending SMS.
 *
 * @author Rafael Reyes Lopez
 * @email rafael.reyes.lopez@idbmobile.com
 * @date 2020-10-26
 *
 */
@Slf4j
public class InfomediaSmsClient extends WebServiceGatewaySupport {

	/**
	 *
	 */
	private static final String PASSWORD_TEXT_TOKEN = "[PASSWORD]";
	
	private static final String USER_TEXT_TOKEN = "[USER]";

	private static final String SOAP_ACTION = "http://tempuri.org/SendMessageWithCampaign";

	private static final String WEB_SERVICE_URI = "https://sms.infomediatechnologies.com/hermes/hermes.asmx";

	private static final String SCHEDULED_TIME = "00000000000000";

	private static final String MESSAGE_TEXT = "Welcome to GameArena: http://gamearena.zone/. Your username is "+USER_TEXT_TOKEN+" and your password is " + PASSWORD_TEXT_TOKEN;

	private static final String CAMPAIGN_ID = "1523";

	private static final String MD5_HASH = "C0-9B-66-9C-81-68-6E-3F-E8-07-95-B4-69-E0-4C-85";

	private static final String USERNAME = "M081StAr";

	private static final String MCC = "302";

	private static final String MNC = "22";

	public SendMessageWithCampaignResponse sendSms(String msisdn, String contentPassword) {

		final SendMessageWithCampaign request = new SendMessageWithCampaign();
		request.setUsername(USERNAME);
		request.setMD5Hash(MD5_HASH);
		request.setCampaignID(CAMPAIGN_ID);
		request.setSMSMessage(MESSAGE_TEXT.replace(PASSWORD_TEXT_TOKEN, contentPassword).replace(USER_TEXT_TOKEN,msisdn));
		request.setScheduleFor(SCHEDULED_TIME);
		request.setUserMsgID(UUID.randomUUID().toString());

		final MSISDNDetails msisdnDetails = new MSISDNDetails();
		msisdnDetails.setMSISDN(msisdn);
		msisdnDetails.setMCC(MCC);
		msisdnDetails.setMNC(MNC);

		final ArrayOfMSISDNDetails value = new ArrayOfMSISDNDetails();

		value.getMSISDNDetails().add(msisdnDetails);

		request.setMSISDNList(value);

		final SendMessageWithCampaignResponse response = (SendMessageWithCampaignResponse) getWebServiceTemplate()
				.marshalSendAndReceive(WEB_SERVICE_URI, request, new SoapActionCallback(SOAP_ACTION));

		log.debug(MessageFormat.format("sendSms {0} - {1}", request.toString(), response));

		return response;
	}

}
