package com.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /*File myObjc = new File("C:\\Users\\vaish\\IdeaProjects\\First\\src\\com\\file\\info.txt");
        if ( myObjc.exists() ){
            System.out.println( myObjc.getName() );
            System.out.println("Readable -> "+myObjc.canRead());
            System.out.println("Writable -> " + myObjc.canWrite());
        }
        else {
            System.out.println(" File does not exist.");
        }*/

       /* FileWriter myWriter = new FileWriter("C:\\Users\\vaish\\IdeaProjects\\First\\src\\com\\file\\info.txt");
        myWriter.write("Java is a prominent language");
        myWriter.close();*/

        FindUniqueWords f = new FindUniqueWords();
        f.findUnique();

    }
}
