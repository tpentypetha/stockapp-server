package gr.mod.mil.stock.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

@Service
public class PasswordHasher {

    public PasswordHash createHash(String cleartext) throws Exception{
        String salt = createSalt();
        String hashedPassword = hash(cleartext, salt);
        return new PasswordHash(hashedPassword, salt);
    }

    public boolean matches(String cleartext, String storedHash, String storedSalt) throws Exception {
        String hashed = hash(cleartext, storedSalt);
        return storedHash.equals(hashed);
    }

    public class PasswordHash {
        private String hash;
        private String salt;

        public String getHash() { return hash; }
        public String getSalt() { return salt; }

        public PasswordHash(String hash, String salt) {
            this.hash = hash;
            this.salt = salt;
        }
    }

    private String hash(String input, String salt) {
        return DigestUtils.sha1Hex(input+salt);
    }

    private String createSalt() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

}
