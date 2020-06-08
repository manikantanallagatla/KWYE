package utilities;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.iitr.kwue.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
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
		    JwtBuilder builder = Jwts.builder().setId(u.phone_no)
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
}
