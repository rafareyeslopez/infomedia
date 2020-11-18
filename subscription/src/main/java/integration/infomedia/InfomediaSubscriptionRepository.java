/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.idbmobile.mcore.subscription.SubscriptionRepository;

@Repository
public interface InfomediaSubscriptionRepository extends SubscriptionRepository<InfomediaSubscription, UUID> {

}
