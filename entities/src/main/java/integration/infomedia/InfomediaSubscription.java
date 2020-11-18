/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import javax.persistence.Entity;

import com.idbmobile.mcore.Subscription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "subscription")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class InfomediaSubscription extends Subscription {

	// No extra fields needed

}
