import Encryption.Encryptor;
import Encryption.XOREncryptor;
import Messenger.Message;
import Messenger.Messenger;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Main file is mainly used for testing

        File outDir = new File("G:/Messenger/valaki/out");
        File backDir = new File("G:/Messenger/valaki/back");
        File decryptDir = new File("G:/Messenger/valaki/decrypted");
        File receivedDir = new File("G:/Messenger/local/received");
        File configFile = new File("G:/Messenger/local/config.txt");
        File keysFile = new File("G:/Mesenger/local/keys.txt");

        try{
            Messenger messenger = new Messenger(outDir, backDir, receivedDir, configFile, decryptDir, keysFile);

        }catch(Exception e){
            e.printStackTrace();

        }

        File inFile = new File("G:/Messenger/testfile.txt");
        File outFile = new File("G:/Messenger/testfile.txt");
        Encryptor encryptor = new XOREncryptor((short) 69);

        try {
            Message msg = new Message(inFile);
            if (msg.localEncrypted){
                msg.decryptLocal(encryptor);

            }else{
                msg.encryptlocal(encryptor);

            }

            System.out.println(msg);
            msg.export(outFile);

        }catch (Exception e){
            System.out.println(e);

        }

    }
}