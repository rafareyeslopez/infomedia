/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia.json.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conf {

	@SerializedName("Status")
	@Expose
	public String status;
	@SerializedName("Description")
	@Expose
	public String description;
	@SerializedName("PortedMCC")
	@Expose
	public String portedMCC;
	@SerializedName("PortedMNC")
	@Expose
	public String portedMNC;

}