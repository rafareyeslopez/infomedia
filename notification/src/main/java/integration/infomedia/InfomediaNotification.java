/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package integration.infomedia;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.idbmobile.mcore.notification.AbstractNotification;

import lombok.Data;

@Table(value = "notification")
@Data
//@AllArgsConstructor
public class InfomediaNotification extends AbstractNotification {

	@PrimaryKey
	LocalDateTime timestamp = LocalDateTime.now();
	UUID pt;
	String Type;
	String TransactionStatus;
	String MX;
	String MCC;
	String MNC;
	String ProductID;
	String ChargeAmount;
	String CurrencyCode;
	String ProductDescription;
	String txid;

	/**
	 * @param timestamp
	 * @param pt
	 * @param type
	 * @param transactionStatus
	 * @param mX
	 * @param mCC
	 * @param mNC
	 * @param productID
	 * @param chargeAmount
	 * @param currencyCode
	 * @param productDescription
	 * @param txid
	 */
	public InfomediaNotification(final UUID pt, final String type, final String transactionStatus, final String mX,
			final String mCC, final String mNC, final String productID, final String chargeAmount,
			final String currencyCode, final String productDescription, final String txid) {
		this.timestamp = LocalDateTime.now();
		this.pt = pt;
		Type = type;
		TransactionStatus = transactionStatus;
		MX = mX;
		MCC = mCC;
		MNC = mNC;
		ProductID = productID;
		ChargeAmount = chargeAmount;
		CurrencyCode = currencyCode;
		ProductDescription = productDescription;
		this.txid = txid;
	}

}
