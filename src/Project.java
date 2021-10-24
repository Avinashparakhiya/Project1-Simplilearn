import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

public class Project implements FileMenu {
    static List<String> viewAllFile = new ArrayList<>();
    static String pathToDirectory = "C:/Users/Abhishek/Desktop/Project1/File_managment/Files/";

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
        System.out.println("----Please Enter Your File Name----");
        fileName = sc.next();
        return fileName.toLowerCase();
    }

    public static int userInputInt() {
        Scanner sc = new Scanner(System.in);
        int userInputInt = 0;
        System.out.println("----Please enter only number of between 1 to 5----");
        try {
            userInputInt = sc.nextInt();
        } catch (Exception e) {
            System.out.println("---You Enter Alphabet---");
            System.out.println("----Please Enter Number only Between 1 to 5----");
        }
        return userInputInt;
    }
    public void viewAllFile() {
        viewAllFile = new ArrayList<>();
        Path path = FileSystems.getDefault().getPath(pathToDirectory).toAbsolutePath();
        File[] myFile = path.toFile().listFiles();
        for (File file : myFile) {
            viewAllFile.add(file.getName());
        }

        String[] allFiles = new String[viewAllFile.size()];
        for (int i = 0; i < viewAllFile.size(); i++) {
            allFiles[i] = viewAllFile.get(i);
        }

        //Bubble sort for ascending order of file
        for (int j = 0; j < allFiles.length; j++) {
            String temp = null;
            for (int i = j + 1; i < allFiles.length; i++) {
                // comparing adjacent allFile stings
                if (allFiles[i].compareTo(allFiles[j]) < 0) {
                    temp = allFiles[j];
                    allFiles[j] = allFiles[i];
                    allFiles[i] = temp;
                }
            }
        }
        viewAllFile = Arrays.asList(allFiles);
    }

    public void creatFile(String fileName) {
        File myFile = new File(pathToDirectory + fileName);
        try {
            if (myFile.createNewFile()) {
                System.out.println("----File created----");
            } else {
                System.out.println("Please enter the Different file name");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void searchFile(String fileName) {
        viewAllFile();
        for (String x : viewAllFile) {
            if (x.equals(fileName)) {
                System.out.println("----File found----");
                return;
            }
        }
        System.out.println("----File was not found Because you Enter wrong File name----");
    }

    public void deleteFile(String fileName) {
        File deleateFile = new File(pathToDirectory + fileName);
        try {
            if (deleateFile.delete()) {
                System.out.println("your file is DELETE");
            } else {
                System.out.println("your file was NOT FOUND so i can NOT DELETE any file");
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
        while (i != 5) {
            fileMenu();
            i = userInputInt();
            switch (i) {
                case 1:
                    obj.viewAllFile();
                    System.out.println(viewAllFile);
                    break;
                case 2:
                    fileName = userInputString();
                    obj.creatFile(fileName);
                    break;
                case 3:
                    fileName = userInputString();
                    obj.searchFile(fileName);
                    break;
                case 4:
                    fileName = userInputString();
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
