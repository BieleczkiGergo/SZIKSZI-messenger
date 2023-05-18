package Messenger;

import Helpers.RandomString;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MessageMaintainer extends Thread{

    private final File back;
    private final File decrypted;
    private final File keys;

    private final short KEYSIZE = 32;

    private HashMap<String, String> keyMap;
    public MessageMaintainer(File back, File decrypted, File keys) throws FileNotFoundException{
        super();

        this.keys = keys;
        this.back = back;
        this.decrypted = decrypted;

        //Read keys file
        Scanner keysInput;
        keysInput = new Scanner(keys);

        String[] pair;

        while (keysInput.hasNextLine()){
            pair = keysInput.nextLine().split("-");
            this.keyMap.put(pair[0], pair[1]);

        }

    }

    @Override
    public void run() {
        File[] messages = back.listFiles();

    }

    /**
     * Writes the key to the keyMap, so that it can be retrieved later
     * @param encryptKey
     * @return - The encryption ID
     */
    public String writeKey(String encryptKey){
        boolean keyExists = false;
        String key;
        do {
            key = RandomString.getRandomAlNumString(KEYSIZE);
            keyExists = this.keyMap.containsKey(key);

        } while (keyExists);
        this.keyMap.put(key, encryptKey);

        return null;
    }

    public String readKey(){
        return null;
    }
}
