package com.chosen;

public class Main {
    public static void main(String[] args) {

        // Path for the specification directory -> pulls the current repository directory
        String specFileDirectory = System.getProperty("user.dir") + "\\src\\com\\chosen";

        // Creates a new file handler instance -> opens the file for writing to throughout the whole program
        Optimus_File_Handling specFile = new Optimus_File_Handling(specFileDirectory);
        specFile.WriteToFile("SPECIFICATIONS DOCUMENT\n----------------------\n");

        // Run the program -> pass the spec file in to start adding stuff to it
        // Call specFile.WriteToFile("put text in here");
        Optimus_Software_UI optimusUI = new Optimus_Software_UI(specFile);
        optimusUI.optimusUI_main_menu_processing(optimusUI);
        
        // MUST CLOSE THIS FILE AT THE END OF TERMINATION -> do not touch this
        specFile.CloseFile();
    }
}
