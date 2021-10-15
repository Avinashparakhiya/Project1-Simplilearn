import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Project implements FileMenu {
    static LinkedList<String> viewAllFile = new LinkedList<>();
    static String pathToDirectory ="C:/Users/Abhishek/IdeaProjects/File_managment/Files/";

    public static void title() {
        System.out.println("Welcome to our application");
        System.out.println("Develop By-AVINASH NARESHBHAI PARAKHIYA");
    }

    public static void fileMenu() {
        System.out.println("\nPlease Select Below any one number");
        System.out.println("1.View all file");
        System.out.println("2.Create a new file");
        System.out.println("3.Search File");
        System.out.println("4.Delete file");
        System.out.println("5.Exit the Application");
    }
    public static String userInputString() {
        Scanner sc = new Scanner(System.in);
        String fileName;
        System.out.println("Please Enter Your File Name");
        fileName = sc.next();
        return fileName;
    }
    public static int userInputInt() {
        Scanner sc = new Scanner(System.in);
        int userInputInt=0;
        System.out.println("Please enter the number between 1 to 5");
        try {
            userInputInt = sc.nextInt();
        } catch (Exception e) {
            System.out.println("error");
        }
        return userInputInt;
    }

    public void viewAllFile() {
        Path path = FileSystems.getDefault().getPath(pathToDirectory).toAbsolutePath();
        File[] myFile =  path.toFile().listFiles();
        for(File file : myFile){
            viewAllFile.add(file.getName());
        }
        Collections.sort(viewAllFile);
    }

    public void creatFile(String fileName) {
        File myFile = new File(pathToDirectory+fileName);
        try {
            if (myFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("Please enter the different file name");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchFile(String fileName) {
        viewAllFile();
        for (String x : viewAllFile) {
            if (x.equals(fileName)) {
                System.out.println("File found");
                return;
            }
        }
        System.out.println("File not found");
    }

    public void deleteFile(String fileName) {
        File deleateFile = new File(pathToDirectory+fileName);
        try {
            if (deleateFile.delete()) {
                System.out.println("your file is delete");
            } else {
                System.out.println("your file was not found so i can not delete any file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Project obj = new Project();
        int i = 0;
        String fileName;
        title();
        while (i!=5) {
            fileMenu();
            i=userInputInt();
            switch (i) {
                case 1:
                    obj.viewAllFile();
                    System.out.println(viewAllFile);
                    break;
                case 2:
                    fileName =userInputString();
                    obj.creatFile(fileName);
                    break;
                case 3:
                    fileName =userInputString();
                    obj.searchFile(fileName);
                    break;
                case 4:
                    fileName =userInputString();
                    obj.deleteFile(fileName);
                    break;
                case 5:
                    System.out.println("exit the application");
                    break;
                default:
                    System.out.println("Please Select only number of between 1 to 5");
            }
        }
    }
}
