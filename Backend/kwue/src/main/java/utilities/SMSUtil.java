package utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SMSUtil {
	
	public static boolean sendSms(String phoneNo, String content) {
		try {
			// Construct data
			String apiKey = "apikey=" + "6kx29F++sAQ-Emoam7ukiOid86f1eO7Yp84zP43qyX	";
			String message = "&message=" + content;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + phoneNo;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			System.out.println(stringBuffer.toString());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
