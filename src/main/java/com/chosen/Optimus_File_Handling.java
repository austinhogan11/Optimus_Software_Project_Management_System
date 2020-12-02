package com.chosen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Optimus_File_Handling {

    private FileWriter specWriter;
    private String pathToFile;
    public Optimus_File_Handling(String pathToFile) {

        this.pathToFile = pathToFile + "specFile.json";

        try {
            // Create the new file
            this.specWriter = new FileWriter(this.pathToFile, true);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Write to the file - return -1 if not written to for validation
    public void WriteToFile(String text) {
        try {
            File myObj = new File(pathToFile);
            myObj.delete();
            specWriter = new FileWriter(this.pathToFile, false);
            this.specWriter.write(text + "\n");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void CloseFile() {
        try {
            this.specWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Reader ReadFromFile() {
        Reader reader = null;
        try {
            reader = new FileReader(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }
}
