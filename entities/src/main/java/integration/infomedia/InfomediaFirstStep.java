/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import javax.persistence.Entity;

import com.idbmobile.mcore.FirstStep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity(name = "first_step")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class InfomediaFirstStep extends FirstStep {

	// No extra fields needed
}
