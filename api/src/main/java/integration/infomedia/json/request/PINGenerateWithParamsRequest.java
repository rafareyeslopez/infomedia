/**
 *
 */
package integration.infomedia.json.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PINGenerateWithParamsRequest {

	@JsonProperty("ProductID")
	private String productID;
	@JsonProperty("MX")
	private String mX;
	@JsonProperty("MCC")
	private String mCC;
	@JsonProperty("MNC")
	private String mNC;
	@JsonProperty("U")
	private String u;
	@JsonProperty("P")
	private String p;
	@JsonProperty("Params")
	private List<Param> params = null;
}
