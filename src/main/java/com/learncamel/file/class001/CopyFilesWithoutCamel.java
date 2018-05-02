package com.learncamel.file.class001;

import java.io.*;

public class CopyFilesWithoutCamel {
    public static void main(String[] args) throws IOException {
        //Step 1: Create a file Object to read the directories
        //Step 2: Read the files from the directory and iterate them
        //Step 3: Create the output stream to read the files
        //Step 4: Close the streams

        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        File[] files = inputDirectory.listFiles();

        for(File source : files) {
            if(source.isDirectory()) return;

            File dest = new File(outputDirectory.getPath() + File.separator + source.getName());

            OutputStream oStream = new FileOutputStream(dest);
            byte[] buffer = new byte[(int) source.length()];
            FileInputStream iStream = new FileInputStream(source);
            iStream.read(buffer);

            try {
                oStream.write(buffer);
            } finally {
                oStream.close();
                iStream.close();
            }
        }
    }
}
