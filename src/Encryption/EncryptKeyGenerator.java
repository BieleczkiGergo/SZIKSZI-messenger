package Encryption;

public class EncryptKeyGenerator {
    public static short makeKey(){

        return (short) Math.floor(Math.random()*65535);
    }

}
