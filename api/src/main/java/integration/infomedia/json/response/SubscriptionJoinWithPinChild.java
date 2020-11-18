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
public class SubscriptionJoinWithPinChild {

	@SerializedName("__type")
	@Expose
	public String type;
	@SerializedName("Status")
	@Expose
	public String status;
	@SerializedName("Description")
	@Expose
	public String description;
	@SerializedName("SID")
	@Expose
	public String sID;
	@SerializedName("MX")
	@Expose
	public String mX;
	@SerializedName("MCC")
	@Expose
	public String mCC;
	@SerializedName("MNC")
	@Expose
	public String mNC;
	@SerializedName("User")
	@Expose
	public User user;
	@SerializedName("TXID")
	@Expose
	public String tXID;
	@SerializedName("Conf")
	@Expose
	public Conf conf;

}
