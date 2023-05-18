package Messenger;

import java.io.File;
import java.io.FileNotFoundException;

public class Messenger {
    private final File out;
    private final File back;
    private final File decrypted;
    private final File received;
    private final File config;
    private final File keys;
    private final MessageMaintainer maintainer;

    public Messenger(File out, File back, File received, File config, File decrypted, File keys) throws FileNotFoundException{
        if(!out.exists()) throw new FileNotFoundException("out directory not found");
        if(!back.exists()) throw new FileNotFoundException("back directory not found");
        if(!received.exists()) throw new FileNotFoundException("received directory not found");
        if(!config.exists()) throw new FileNotFoundException("config file not found");
        if(!decrypted.exists()) throw new FileNotFoundException("decrypted direcoty not found");
        if(!keys.exists()) throw new FileNotFoundException("keys file not found");

        this.keys = keys;
        this.back = back;
        this.out = out;
        this.received = received;
        this.config = config;
        this.decrypted = decrypted;

        this.maintainer = new MessageMaintainer(back, decrypted, keys);
        this.maintainer.start();

    }

    public void newMessage(){
        Message msg = new Message();

    }

    public void getMessage(){

    }



    //public String[] messages(){}
}
