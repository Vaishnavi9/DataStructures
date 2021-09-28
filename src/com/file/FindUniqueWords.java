package com.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindUniqueWords {

    void findUnique() throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf("C:\\Users\\vaish\\IdeaProjects\\First\\src\\com\\file\\info.txt")));

        Set<String> wordsOfArticle = new HashSet<>();
        String line = reader.readLine();

        while(line != null){
            if(!line.trim().equals("")){
                String[] words = line.split(" ");
                for(String word : words) {
                    String cleanedUpWords = word.toLowerCase()
                                            .replace(",","")
                                            .replace(".","")
                                            .replace("\\","");
                    wordsOfArticle.add(cleanedUpWords);
                }
                line = reader.readLine();
            }

        }
        System.out.println(wordsOfArticle);
    }

}
