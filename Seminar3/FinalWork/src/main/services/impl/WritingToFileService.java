package main.services.impl;

import main.data.Human;
import main.services.Writable;

import java.io.*;

public class WritingToFileService implements Writable {

    @Override
    public void write(Human human) {
        if(human == null) return;

        try(var br = new BufferedWriter(new FileWriter(human.getLastName(),true))){
            br.append(human.toString() + "\n");
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
