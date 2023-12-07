package gov.app4;

import java.io.*;  // Import the File class
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> shapes = new ArrayList<>();

    public static void Shapes() {

        shapes.add("triangle");
        shapes.add("square");
        shapes.add("circle");
    }

    public static void info() {

        System.out.println("Select 'a' for adding the elements from the file to the list");
        System.out.println("Select 'w' for writing the elements from the list to the file");
        System.out.println("Select 'c' for clearing the list");
        System.out.println("Select 'q' for closing the app");
        System.out.println("Select a command please: ");

    }

    public static void main(String[] args) throws IOException {

        info();
        Shapes();
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        boolean app = true;

        File myFile = new File("filename.txt");

        while(app) {
            switch(command){
                case "a": //it reads the file and add the lines to the list
                    try {
                        Scanner myReader = new Scanner(myFile);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            shapes.add(data);
                        }

                        myReader.close();

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                    break;

                case "w": //it writes the shapes list into the file
                    FileWriter myWriter = new FileWriter(myFile, true);
                    for (String str : shapes) {
                        myWriter.write(str + "\n");
                    }

                    myWriter.close();

                    break;

                case "c": //it clears the list
                    shapes.clear();

                    break;

                case "q": //it closes the app
                    app = false;
                    break;

                default:
                    System.out.println("Please give a valid command.");

            }

            if (command.equals("q")) {
                break;

            } else {
                System.out.println("Choose another command");
                Scanner input2 = new Scanner(System.in);
                String newCommand = input2.nextLine();
                command = newCommand;

            }
        }
    }
}