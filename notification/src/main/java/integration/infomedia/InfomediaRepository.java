/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */


package integration.infomedia;

import org.springframework.stereotype.Repository;

import com.idbmobile.mcore.notification.AbstractNotification;
import com.idbmobile.mcore.notification.NotificationRepository;

@Repository
public interface InfomediaRepository<InfomediaNotification extends AbstractNotification, UUID>
		extends NotificationRepository<InfomediaNotification, UUID> {
	

}
