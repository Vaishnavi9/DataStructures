package com.Healthcare;

//Full Name: Khin Chaw Thazin
//
//Full time
//
//Tutorial Group: T07
//
//Declaration: This is my own work and
//i haven't passed my program to my friends
//
//File name: KhinChawThazin_A2.java

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner; //import Scanner class
import java.io.File;
import java.io.IOException;

enum Gender {
    Female,Male;



 }

class Date
{
    //Declare private instance variables
    private int day;
    private String month;
    private int year;

    //Dafault constructor
    public Date() { }

    //Other constructor
    public Date(int day,String month,int year)
    {
        setInfo(day,month,year);
    }

    //Copy constructor
    public Date (Date otherD)
    {
        this(otherD.day,otherD.month,otherD.year);
    }

    //Accessor methods
    public int getDay()
    {
        return day;
    }

    public String getMonth()
    {
        return month;
    }

    public int getYear()
    {
        return year;
    }

    public String getDateString()
    {
        int day = getDay();
        String month = getMonth();
        int year = getYear();

        String dob =day+" "+month+", "+year;
        return dob;
    }


    //mutator methods
    public void setInfo (int day,String month,int year)
    {
        this.day = day;
        this.month =month;
        this.year = year;
    }


}//end of Date class

class HealthProfile
{
    //Declare private instance variables
    private String firstName;
    private String lastName;
    private Date dob;
    private double height;
    private Gender g;
    private double weight;

    //Dafault constructor
    public HealthProfile()
    { }

    //Other constructor
    public HealthProfile (String firstName,String lastName,
                          Date dob,double height,Gender g,
                          double weight)
    {
        setInfo(firstName,lastName,dob,height,g,weight);
    }

    //Copy constructor
    public HealthProfile(HealthProfile hp)
    {
        this(hp.firstName,hp.lastName,hp.dob,
                hp.height,hp.g,hp.weight);
    }

    //Accessor methods
    public String getFirstname()
    {
        return firstName;
    }

    public String getLastname()
    {
        return lastName;
    }

    public Date getDOB()
    {
        return dob;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    //other methods
    private double computeBMI()
    {
        double BMI = weight/(height*height);
        return BMI;
    }

    public double getBMI()
    {
        double BMI = computeBMI();
        return BMI;
    }

    //Mutator methods
    public void setInfo(String firstName,String lastName,
                        Date dob,double height,
                        Gender g,double weight)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.height = height;
        this.g = g;
        this.weight = weight;
    }

    //display profile
    public void printProfile()
    {
        double BMI = this.getBMI();

        //display info
        System.out.println("Name:"+firstName+" "+lastName);
        System.out.printf("Date of Birth: %s%n",dob.getDateString());
        System.out.printf("Height: %.2f%n",height);
        System.out.printf("Gender: %s%n",String.valueOf(g));
        System.out.printf("Weight: %.1f%n",weight);
        System.out.printf("Your BMI: %.2f%n", BMI);
    }
}//end of Healthprofile class

class KhinChawThazin_A2
{
    public static void main (String[]args)throws IOException
    {

        Scanner input = new Scanner (new File("C:\\Users\\vaish\\IdeaProjects\\First\\src\\com\\Healthcare\\info.txt"));

        //Declare local variables
        String firstName;
        String lastName;
        int day;
        String month;
        int year;
        double height;
        Gender g;
        double weight;


        //Read the first patient
        firstName = input.nextLine();
        lastName = input.nextLine();
        day = input.nextInt();
        month = input.next();
        year = input.nextInt();
        height=input.nextDouble();
        input.nextLine();
        g = Gender.valueOf(input.nextLine());
        weight=input.nextDouble();


        System.out.println("Patient 1");
        Date doba=new Date(day,month,year);
        HealthProfile h1=new HealthProfile(firstName,lastName,doba,height,g,weight);
        h1.printProfile();

        //To get rid of input buffer
        input.nextLine();
        System.out.println();

        //Read the second patient
        firstName=input.nextLine();
        lastName=input.nextLine();
        day=input.nextInt();
        month=input.next();
        year=input.nextInt();
        height=input.nextDouble();
        input.nextLine();
        g=Gender.valueOf(input.next());
        weight=input.nextDouble();

        System.out.println("Patient 2");
        Date dobb=new Date(day,month,year);
        HealthProfile h2=new HealthProfile(firstName,lastName,
                dobb,height,g,weight);
        h2.printProfile();

    }
}











