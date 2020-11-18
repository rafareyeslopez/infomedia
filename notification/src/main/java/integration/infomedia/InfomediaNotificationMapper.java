/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.idbmobile.mcore.BillingNotificationStatus;
import com.idbmobile.mcore.Notification;
import com.idbmobile.mcore.NotificationTypes;

/**
 * Mapper for Infomedia notification to ours using Mapstruct.
 *
 * @author Rafael Reyes Lopez
 * @email rafael.reyes.lopez@idbmobile.com
 * @date 2020-10-26
 *
 */
@Mapper(componentModel = "spring", imports = { LocalDateTime.class, LocalDate.class })
public interface InfomediaNotificationMapper {

	public InfomediaNotificationMapper INSTANCE = Mappers.getMapper(InfomediaNotificationMapper.class);

	@Mapping(source = "pt", target = "correlationId")
	@Mapping(source = "type", target = "action", qualifiedByName = "providerActionToAction")
	@Mapping(source = "transactionStatus", target = "billingStatus", qualifiedByName = "providerBillingResult")
	@Mapping(target = "carrierId", constant = "302653")
	@Mapping(target = "tariff", constant = "4.99f")
	// @Mapping(target = "pk.date", defaultExpression = "java(LocalDate.now())")
	@Mapping(target = "timestamp", defaultExpression = "java(LocalDateTime.now())")
	Notification providerNotificationToNotification(InfomediaNotification providerNotification);

	@Named("providerActionToAction")
	static NotificationTypes providerActionToAction(final String providerAction) { // throws UnkownActionException {

		if (StringUtils.isNotEmpty(providerAction)) {

			if (providerAction.equals("1") || providerAction.equals("3")) {
				return NotificationTypes.SIGNUP;
			} else if (providerAction.equals("2")) {
				return NotificationTypes.SIGNOFF;
			} else if (providerAction.equals("5")) {
				return NotificationTypes.BILLING;
			} else {
				return NotificationTypes.BILLING;
			}
		} else {
			return null;
		}
	}

	@Named("providerBillingResult")
	static BillingNotificationStatus providerBillingResultToBillingResult(final String providerBillingResult) {

		if (StringUtils.isNotEmpty(providerBillingResult)) {
			if (providerBillingResult.equals("00")) {
				return BillingNotificationStatus.BILLED;
			} else if (providerBillingResult.equals("AA")) {
				return BillingNotificationStatus.NO_FUNDS;
			} else {
				return BillingNotificationStatus.ERROR;
			}
		} else {
			return null;
		}
	}

}