package utilities;

//send sms imports
import java.io.BufferedReader;
import java.io.InputStreamReader;

//send email imports
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.util.Date;
import java.util.Properties;

//JWT imports
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.DatatypeConverter;

import com.iitr.kwue.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Utilities {
	private static final String FROM_EMAIL = "kwue.notifications@gmail.com";
	private static final String FROM_EMAIL_PASSWORD = "Password!23";
	private static final String SECRET_KEY = "KWYE";
	private static final String ISSUER = "KWYE";
	
	public static String createJWT(User u) {
		 
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	 
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	 
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	 
	    try {
	    	String userJsonString = new com.fasterxml.jackson.databind.ObjectMapper().writeValueAsString(u);

		    //Let's set the JWT Claims
		    JwtBuilder builder = Jwts.builder().setId(u.getPhone_no())
		                                .setIssuedAt(now)
		                                .setSubject(userJsonString)
		                                .setIssuer(ISSUER)
		                                .signWith(signatureAlgorithm, signingKey);
		  //Builds the JWT and serializes it to a compact, URL-safe string
		    return builder.compact();
		} catch (Exception e) {
			return "";
		}	    
	}
	 
	public static User parseJWT(String jwtToken) {
	 
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()         
	       .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
	       .parseClaimsJws(jwtToken).getBody();
	    
	    try {
	    	return new com.fasterxml.jackson.databind.ObjectMapper().readValue(claims.getSubject(), User.class);
		} catch (Exception e) {
			return null;
		}	
	    
	}
	
	public static boolean sendEmail(String toEmail, String subject, String body, String fromEmail, String fromEmailPassword){
		final String fromEmail_ = fromEmail == null ? FROM_EMAIL : fromEmail;
		final String fromEmailPassword_ = fromEmailPassword == null ? FROM_EMAIL_PASSWORD : fromEmailPassword;

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
		        //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail_, fromEmailPassword_);
			}
		};
		Session session = Session.getInstance(props, auth);
	    
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	      return true;
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      return false;
	    }
	}
	
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
