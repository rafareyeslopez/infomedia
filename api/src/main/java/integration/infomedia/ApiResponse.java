/**
 *
 */
package integration.infomedia;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author rafar
 *
 */
@Data
@AllArgsConstructor
public class ApiResponse {

	private boolean success;
	private String message;

}
