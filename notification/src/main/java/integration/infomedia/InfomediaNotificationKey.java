/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package integration.infomedia;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@PrimaryKeyClass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfomediaNotificationKey implements Serializable {

	private static final long serialVersionUID = 2727885633430660747L;

	@PrimaryKeyColumn(name = "date", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@Builder.Default
	LocalDate date = LocalDate.now();
	@PrimaryKeyColumn(name = "pt", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	UUID pt;

}