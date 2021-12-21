package de.johanneswirth.apps.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.dropwizard.lifecycle.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class VerificationHelper implements Managed {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerificationHelper.class);

    private String pubKey;
    private RSAPublicKey publicKey;

    /**
     * Constructor
     */
    public VerificationHelper(String publicKey) {
        this.pubKey = publicKey;
    }

    public static RSAPublicKey loadPublic(String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        byte[] keyBytes = Files.readAllBytes(Paths.get(publicKey));
        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return (RSAPublicKey) kf.generatePublic(spec);
    }

    public DecodedJWT validateJWT(String ticket) throws JWTVerificationException {
        LOGGER.info("Trying to authorize with ticket " + ticket);
        Algorithm algorithm = Algorithm.RSA256(publicKey, null);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("app-center")
                .build(); //Reusable verifier instance
        return verifier.verify(ticket);
    }

    public static long userID(SecurityContext context) {
        return Long.parseLong(context.getUserPrincipal().getName());
    }

    @Override
    public void start() throws Exception {
        publicKey = loadPublic(pubKey);
    }

    @Override
    public void stop() throws Exception {

    }
}
