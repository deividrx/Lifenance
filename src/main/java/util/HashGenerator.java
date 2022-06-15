package util;

import models.exceptions.HashGenerationException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

    public static String generateSHA256(String message) throws HashGenerationException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));

            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new HashGenerationException();
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte arrayByte : arrayBytes) {
            stringBuffer.append(Integer.toString((arrayByte & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }

}
