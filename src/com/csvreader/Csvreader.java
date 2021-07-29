package com.csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Csvreader {

    public static void main(String[] args) throws IOException {
        List<User> listOfUsers= readUsersFromCSV("C:\\Users\\vaish\\IdeaProjects\\First\\src\\com\\csvreader\\username.csv");
        for(User user: listOfUsers) {
            System.out.println(user.getUserName()+" "+user.getFirstName()+" "+user.getLastName()+" "+user.getId());
        }

    }

    private static List<User> readUsersFromCSV(String fileName) throws IOException {
        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get(fileName); // create an instance of BufferedReader // using try with resource, Java 7 feature to close resources
        long lines = Files.lines(pathToFile).count();

         try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the text file
             br.readLine(); // don't use first line
             String line = br.readLine(); // loop until all lines are read - start from second line

            while (lines>=1 && line != null) {
                // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter
                String[] attributes = line.split(",");
                User user = createUser(attributes);
                // adding book into ArrayList
                users.add(user);
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
                lines--; }
                }
            catch (IOException ioe) {
                    ioe.printStackTrace();
         }
         return users;
    }

    private static User createUser(String[] metadata) {
        String userName = metadata[0];
        Integer id = Integer.valueOf(metadata[1]);
        String firstName = metadata[2]; // create and return book of this metadata
        String lastName = metadata[3];
        return new User(userName, id, firstName, lastName);
    }


}

class User{
    private String userName;
    private Integer id;
    private String firstName;
    private String lastName;

    public User(String userName, Integer id, String firstName, String lastName){
        this.userName = userName;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
