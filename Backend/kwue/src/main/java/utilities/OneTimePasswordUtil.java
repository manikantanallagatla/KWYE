package utilities;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.iitr.kwue.Constants.Constants;
import com.iitr.kwue.entities.OneTimePassword;

public class OneTimePasswordUtil {
	
	public static Boolean isValidOTP(final OneTimePassword oneTimePassword, final String otpNumber) {
		final long thresholdTime = ZonedDateTime.now(ZoneId.of(Constants.UTC_ZONE_ID)).minusMinutes(15).toEpochSecond();
		if (thresholdTime > oneTimePassword.timeStamp) {
			return Boolean.FALSE;
		}
		return oneTimePassword.otpNumber.equals(otpNumber);
	}
	
}
