/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idbmobile.mcore.Notification;
import com.idbmobile.mcore.subscription.NotificationListener;

@Component
public class InfomediaNotificationListener
		extends NotificationListener<Notification, InfomediaFirstStep, InfomediaSubscription> {

	@Autowired
	InfomediaApi infomediaApi;

	@Override
	protected Optional<InfomediaSubscription> findSubscription(Notification notification) {
		return subscriptionRepository.findById(notification.getCorrelationId());

	}

	@Override
	protected Optional<InfomediaFirstStep> findFirstStep(Notification notification) {
		return firstStepRepository.findById(notification.getCorrelationId());
	}

	@Override
	protected void sendBillingAttempt(InfomediaSubscription newSubscription) {
		// do nothing

	}

	@Override
	protected void sendWelcomeMessage(InfomediaSubscription newSubscription) {
		infomediaApi.sendSms(newSubscription.getMsisdn(), newSubscription.getContentPassword());

	}

}
