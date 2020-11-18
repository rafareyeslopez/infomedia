/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import com.idbmobile.mcore.Notification;
import com.idbmobile.mcore.notification.NotificationControllerGet;

@RestController
public class InfomediaNotificationController<T> extends NotificationControllerGet<InfomediaNotification> {

	@Override
	protected Notification providerNotificationToNotification(@Valid final InfomediaNotification notification) {
		return InfomediaNotificationMapper.INSTANCE.providerNotificationToNotification(notification);
	}

}
