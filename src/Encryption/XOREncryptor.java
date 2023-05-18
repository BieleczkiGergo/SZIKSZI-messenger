package Encryption;

public class XOREncryptor implements Encryptor{

    private short key = 69;

    public XOREncryptor(short key){
        this.key = key;

    }

    @Override
    public String encrypt(String text) {
        String encrypted = "";

        for (int i=0; i<text.length()-1; i++){
            encrypted = encrypted.concat(String.valueOf((char) (text.charAt(i) ^ key)));


        }
        return encrypted;
    }

    @Override
    public String decrypt(String text) {
        String decrypted = "";
        for (int i=0; i<text.length()-1; i++){
            decrypted = decrypted.concat(String.valueOf((char) (text.charAt(i) ^ key)));


        }
        return decrypted;
    }
}
