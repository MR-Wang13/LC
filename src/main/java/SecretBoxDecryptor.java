import org.abstractj.kalium.crypto.SecretBox;

import java.util.Base64;

public class SecretBoxDecryptor {
    public static void main(String[] args) {
        // 第一组数据
        String base64Key = "dGhpc2lzYWtleXdpdGgzMmxldHRlcnNpbml0ZmV0Y2g=";
        String base64Nonce1 = "usbsgmFzQNjwMEEZVqJ6Hdy8MOJwMOiq";
        String base64Value1 = "usbsgmFzQNjwMEEZVqJ6Hdy8MOJwMOiq4OxKbmluN/Ec7gS9EVVeh82JsqgcCUfxmAXXAx3xqmDz+dA8+JTtRknQwgjekROmuAbLiiYCQgddczHcu9xRGf1g0/KKeqnrcfbdIj1PUlK0W5iL22v98ZK+5gTFpPoHdqOHCJ2wesES6a18/t1C0CI7F40AnTrL2kengA0FCh4s4MY4";

        // 第二组数据（如果需要解密多组数据，可类似处理）
        String base64Nonce2 = "/KSIvzD+EfD2ohTDS8YyXWfpzHjVrp1i";
        String base64Value2 = "/KSIvzD+EfD2ohTDS8YyXWfpzHjVrp1iMQBE3XbIMi0G/BowKduAtkW9uvBwoRDicvmeFfDvaez3xw==";

        // 使用 Java 内置 Base64 解码器解码数据
        byte[] key = Base64.getDecoder().decode(base64Key);
        byte[] nonce1 = Base64.getDecoder().decode(base64Nonce1);
        byte[] cipherText1 = Base64.getDecoder().decode(base64Value1);
        byte[] nonce2 = Base64.getDecoder().decode(base64Nonce2);
        byte[] cipherText2 = Base64.getDecoder().decode(base64Value2);

        // 使用 Kalium 创建 SecretBox 对象（密钥必须为 32 字节）
        SecretBox box = new SecretBox(key);

        // 解密第一组数据
        byte[] decrypted1 = box.decrypt(nonce1, cipherText1);
        if (decrypted1 == null) {
            System.out.println("第一组数据解密失败");
        } else {
            System.out.println("第一组数据解密结果: " + new String(decrypted1));
        }

        // 解密第二组数据
        byte[] decrypted2 = box.decrypt(nonce2, cipherText2);
        if (decrypted2 == null) {
            System.out.println("第二组数据解密失败");
        } else {
            System.out.println("第二组数据解密结果: " + new String(decrypted2));
        }
    }
}
