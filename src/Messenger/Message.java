package Messenger;

import Encryption.Encryptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Message {
    private String target;
    private String body;
    public boolean localEncrypted;
    public boolean remoteEncrypted;
    private String localKey;
    private String remoteKey;

    public Message(File inputFile) throws FileNotFoundException, NoSuchElementException {
        if (!inputFile.exists()){
            throw new FileNotFoundException("Message input file was not found.");

        }
        Scanner input = new Scanner(inputFile);
        String msgHead = input.nextLine();
        String[] headArray = msgHead.split(";");
        this.target = headArray[0];
        this.localEncrypted = headArray[1].charAt(0) == 'T';
        this.remoteEncrypted = headArray[1].charAt(1) == 'T';

        this.body = "";
        while (input.hasNextLine()){
            this.body = this.body.concat(input.nextLine()).concat("\n");

        }

    }
    public Message(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter destination: ");
        this.target = input.nextLine();
        System.out.println("Enter message body(empty line to end prompt): ");
        String temp;
        this.body = "";
        do {
            temp = input.nextLine();
            this.body = this.body.concat(temp).concat("\n");

        }while (!temp.isEmpty());

    }
    
    public void export(File outFile) throws IOException {
        FileWriter out = new FileWriter(outFile);
        out.write(this.toString());

        out.close();
    }

    public void encryptlocal(Encryptor encryptor){
        this.body = encryptor.encrypt(this.body);
        this.localEncrypted = true;

    }
    public void decryptLocal(Encryptor encryptor){
        this.body = encryptor.decrypt(this.body);
        this.localEncrypted = false;

    }
    public void encryptRemote(Encryptor encryptor){
        this.body = encryptor.encrypt(this.body);
        this.remoteEncrypted = true;

    }
    public void decryptRemote(Encryptor encryptor){
        this.body = encryptor.decrypt(this.body);
        this.remoteEncrypted = false;

    }

    public String getLocalKey(){
        return localKey;
    }
    public String getRemoteKey(){
        return remoteKey;
    }

    @Override
    public String toString() {
        return this.target + ";" + (this.localEncrypted? "T" : "F") + (this.remoteEncrypted? "T" : "F") + "\n" + this.body;
    }
}
