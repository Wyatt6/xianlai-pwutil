package fun.xianlai.pwutil;

/**
 * Usage:
 * <p>
 * Encryption: java -jar pwutil.jar $lang -e $plain_text $key_str
 * Decryption: java -jar pwutil.jar $lang -d $cipher_text $key_str
 * <p>
 * $lang            --zh - Simplified Chinese; --en - English
 * $plain_text      Text string that need to be encrypted
 * $cipher_text     Text string that need to be decrypted
 * $key_str         Key string used to encrypt or decrypt
 *
 * @author Wyatt6
 * @date 2025/8/5
 */
public class Application {
    public static void main(String[] args) {
        // COMMAND arg0 arg1 arg2 ...
        //      arg0 $lang
        //      arg1 -e/-d
        //      arg2 $plain_text/$cipher_text
        //      arg3 $key_str

        boolean zh = "--zh".equals(args[0]);

        if ("-e".equals(args[1])) {
            if (zh) {
                System.out.println("> 程序读取的明文：" + args[2]);
                System.out.println("> 程序读取的密钥：" + args[3]);
                System.out.println("> 程序加密后的密文：" + AESUtil.encrypt(args[2], args[3]));
            } else {
                System.out.println("> Plaintext read by program: " + args[2]);
                System.out.println("> Key string read by program: " + args[3]);
                System.out.println("> Encrypted ciphertext output by program: " + AESUtil.encrypt(args[2], args[3]));
            }
        } else if ("-d".equals(args[1])) {
            if (zh) {
                System.out.println("> 程序读取的密文：" + args[2]);
                System.out.println("> 程序读取的密钥：" + args[3]);
                System.out.println("> 程序解密后的明文：" + AESUtil.decrypt(args[2], args[3]));
            } else {
                System.out.println("> Ciphertext read by program: " + args[2]);
                System.out.println("> Key string read by program: " + args[3]);
                System.out.println("> Decrypted plaintext output by program: " + AESUtil.decrypt(args[2], args[3]));
            }
        }
    }
}
