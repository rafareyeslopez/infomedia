/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia.json.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionUnsubscribeRequest {

	@JsonProperty("SID")
	public String sID;
	@JsonProperty("MX")
	public String mX;
	@JsonProperty("MCC")
	public String mCC;
	@JsonProperty("MNC")
	public String mNC;
	@JsonProperty("U")
	public String u;
	@JsonProperty("P")
	public String p;

}