/**
 *
 */
package integration.infomedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author rafar
 *
 */
//TODO: pusll to framework!
@RestController
public class InfomediaSubscriptionController {

	@Autowired
	InfomediaSubscriptionRepository infomediaSubscriptionRepository;

	@Autowired
	InfomediaApi infomediaApi;

	@GetMapping("/login")
	public boolean login(@RequestParam final String msisdn, @RequestParam final String password) {

		return infomediaSubscriptionRepository.findByMsisdnAndContentPassword(msisdn, password).isPresent();

	}

	@PostMapping("/unsubscribe")
	public boolean unsubscribe(@RequestParam final String msisdn) throws JsonProcessingException {

		return infomediaApi.unsubscribe(msisdn);

	}

}
