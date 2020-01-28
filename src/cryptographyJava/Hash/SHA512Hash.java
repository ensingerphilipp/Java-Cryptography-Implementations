package cryptographyJava.Hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Standard Hashing Function for use with NON-SENSITIVE Information
 * Do NOT use SHA Algorithms for Hashing Passwords or other sensitive Information
 *
 */

public class SHA512Hash {

    /**
     * Algorithm for MessageDigest
     */
    public static final String ALGORITHM = "SHA-512";

    /**
     * Generate a SHA512 cryptographyJava.Hash of a given PlainText
     *
     * @param plainText plainText to be Hashed
     * @return SHA512 cryptographyJava.Hash of plainText
     */
    public static String hash(String plainText) throws NoSuchAlgorithmException {

        //Static Instance for SHA512 Hashing
        MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);

        //digest () calculates SHA-512 cryptographyJava.Hash from plainText
        byte[] digestedMessage = messageDigest.digest(plainText.getBytes());

        // Gets the Sign Representation of the digestedMessage
        BigInteger sign = new BigInteger(1, digestedMessage);

        // Convert digestedMessage (sign Representation) to Hex Value Representation
        StringBuilder hash = new StringBuilder(sign.toString(16));

        // IMPORTANT! Add Leading 0 Padding -- Conversion of byte to BigInteger deletes possible leading 0 which have to be added back
        while (hash.length() < 64) {
            hash.insert(0, "0");
        }
        return hash.toString();
    }
}
