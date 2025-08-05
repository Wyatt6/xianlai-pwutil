package fun.xianlai.pwutil;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author Wyatt6
 * @date 2025/8/5
 */
public class AESUtil {
    private static final String ALGORITHM = "AES";

    /**
     * Encryption
     *
     * @param plaintext Plain text that needs to be encrypted
     * @param keyString The key used for encryption and decryption
     * @return Cipher text
     */
    public static String encrypt(String plaintext, String keyString) {
        try {
            // --- Step 1: turn key string into 128-bit secret key ---
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            // this 3 lines replace the init() method bellow, to solve below error occurred in macOS/Linux
            // "Given final block not properly padded. Such issues can arise if a bad key is used during decryption."
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(keyString.getBytes());   // use key string as random seed
            kgen.init(128, random);
            // kgen.init(128, new SecureRandom(keyString.getBytes()));
            SecretKey secretKey = kgen.generateKey();

            // --- Step 2: encryption ---
            byte[] encodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(encodeFormat, ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return new Base64().encodeToString(cipher.doFinal(plaintext.getBytes()));    // byte[] --> String
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Decryption
     *
     * @param ciphertext Cipher text that needs to be decrypted
     * @param keyString  The key used for encryption and decryption
     * @return Plain text
     */
    public static String decrypt(String ciphertext, String keyString) {
        try {
            // --- Step 1: turn key string into 128-bit secret key ---
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            // this 3 lines replace the init() method bellow, to solve below error occurred in macOS/Linux
            // "Given final block not properly padded. Such issues can arise if a bad key is used during decryption."
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(keyString.getBytes());   // use key string as random seed
            kgen.init(128, random);
            //kgen.init(128, new SecureRandom(keyString.getBytes()));
            SecretKey secretKey = kgen.generateKey();

            // --- Step 2: decryption ---
            byte[] encodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(encodeFormat, ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.decodeBase64(ciphertext)));    // String --> byte[]
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
