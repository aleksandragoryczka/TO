package com.View;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    public FileHandler() throws IOException {
        File obj = new File("names.txt");
        if(obj.createNewFile()){
            System.out.println("New file created");
        }else{
            System.out.println("File in this ready existed");
        }

    }
}
