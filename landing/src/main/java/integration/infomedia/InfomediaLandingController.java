/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.idbmobile.mcore.CountryIsoValue;
import com.idbmobile.mcore.landing.AbstractLandingController;
import com.idbmobile.mcore.landing.InvalidMsisdnException;
import com.idbmobile.mcore.landing.LandingPagesFlowSteps;

import lombok.extern.slf4j.Slf4j;

/**
 * Landing page for subscription flow over Infomedia in Canada.
 *
 * @author Rafael Reyes Lopez
 * @email rafael.reyes.lopez@idbmobile.com
 * @date 2020-10-26
 *
 * @param <T>
 */
@Controller
@RequestMapping("ca")
@Slf4j
public class InfomediaLandingController<T> extends AbstractLandingController<InfomediaFirstStep> {

	@Autowired
	private InfomediaApi infomediaApi;

	public InfomediaLandingController() {

		this.country = CountryIsoValue.CA;
		this.pageToShow = LandingPagesFlowSteps.ENTER_MSISDN;
		this.pageAction = LandingPagesFlowSteps.ENTER_PIN;

	}

	@GetMapping("/{pagePath}")
	public String initFlow(final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam(value = "cid", required = true) final Integer campaignId,
			@PathVariable(value = "pagePath", required = true) final String pagePath) throws JsonProcessingException {

		log.debug(MessageFormat.format("initFlow: {0} - page path -{1}", request.getQueryString(), pagePath));

		return super.startFlow(request, response, campaignId, pagePath, LandingPagesFlowSteps.ENTER_MSISDN,
				LandingPagesFlowSteps.ENTER_PIN);
	}

	@GetMapping("/{pagePath}/entermsisdn")
	public String showenterMsisdn(final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable(value = "pagePath", required = true) final String pagePath,
			@RequestParam(value = "token", required = true) final String token) throws JsonProcessingException {

		log.debug(MessageFormat.format("showenterMsisdn: {0}", request.getQueryString()));

		return buildNextUrl(request.getServerName(), pagePath, LandingPagesFlowSteps.ENTER_MSISDN,
				LandingPagesFlowSteps.ENTER_PIN, token, extractCorrelationIdFromToken(token));

	}

	@GetMapping("/{pagePath}/enterpin")
	public String showEnterPin(final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable(value = "pagePath", required = true) final String pagePath,
			@RequestParam(value = "msisdn", required = true) final String msisdn,
			@RequestParam(value = "token", required = true) final String token) throws JsonProcessingException {

		log.debug(MessageFormat.format("showEnterPin: {0}", request.getQueryString()));

		try {

			String tokenUpdated = token;

			final ApiResponse generatePinCodeResponse = infomediaApi.generatePinCode(msisdn);

			if (generatePinCodeResponse.isSuccess()) {

				createFirstStep(token, msisdn);

				tokenUpdated = updateTokenWithMsisdn(token, msisdn);

				return buildNextUrl(request.getServerName(), pagePath, LandingPagesFlowSteps.ENTER_PIN,
						LandingPagesFlowSteps.THANK_YOU, tokenUpdated, extractCorrelationIdFromToken(token));
			} else {
				return buildNextUrl(request.getServerName(), pagePath, LandingPagesFlowSteps.ENTER_MSISDN,
						LandingPagesFlowSteps.ENTER_PIN, tokenUpdated, extractCorrelationIdFromToken(token),
						generatePinCodeResponse.getMessage());
			}

		} catch (final InvalidMsisdnException | JsonProcessingException e) {
			return buildNextUrl(request.getServerName(), pagePath, LandingPagesFlowSteps.ENTER_MSISDN,
					LandingPagesFlowSteps.ENTER_PIN, token, extractCorrelationIdFromToken(token), e.getMessage());

		}
	}

	@GetMapping("/{pagePath}/thankyou")
	public String showThankyouPage(final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable(value = "pagePath", required = true) final String pagePath,
			@RequestParam(value = "pin", required = true) final String pin,
			@RequestParam(value = "token", required = true) final String token) throws JsonProcessingException {

		log.debug(MessageFormat.format("showThankyouPage: {0}", request.getQueryString()));

		final String msisdn = extractMsisdnFromToken(token);
		final String correlationId = extractCorrelationIdFromToken(token);

		final ApiResponse subscribeWithPinResponse = infomediaApi.subscribeWithPin(msisdn, pin, correlationId);

		if (subscribeWithPinResponse.isSuccess()) {
			return buildNextUrl(request.getServerName(), pagePath, LandingPagesFlowSteps.THANK_YOU,
					LandingPagesFlowSteps.THANK_YOU, token, extractCorrelationIdFromToken(token));
		} else {
			return buildNextUrl(request.getServerName(), pagePath, LandingPagesFlowSteps.ENTER_PIN,
					LandingPagesFlowSteps.THANK_YOU, token, extractCorrelationIdFromToken(token),
					subscribeWithPinResponse.getMessage());
		}
	}

}
