package sphy.images;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
@Configuration
public class ECDSA {

   /* public static void generateKeys() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeySpecException {
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
        KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
        g.initialize(ecSpec, new SecureRandom());
        KeyPair keypair = g.generateKeyPair();
        PublicKey publicKey = keypair.getPublic();
        PrivateKey privateKey = keypair.getPrivate();
        String pub = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String priv= Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println("pub "+pub);
        System.out.println("priv "+priv);
    }*/

    public static ECPrivateKey reconstructPrivateKey(String base64Value) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory kf = KeyFactory.getInstance("EC");
        byte[] bytes = Base64.getDecoder().decode(base64Value);
        return (ECPrivateKey) kf.generatePrivate(new PKCS8EncodedKeySpec(bytes));
    }

    public static ECPublicKey reconstructPublicKey(String base64Value) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory kf = KeyFactory.getInstance("EC");
        byte[] bytes = Base64.getDecoder().decode(base64Value);
        return (ECPublicKey) kf.generatePublic(new X509EncodedKeySpec(bytes));
    }



}
