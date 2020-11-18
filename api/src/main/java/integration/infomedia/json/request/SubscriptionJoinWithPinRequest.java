/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia.json.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubscriptionJoinWithPinRequest {

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
	@JsonProperty("Params")
	public List<Param> params = null;

}