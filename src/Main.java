import fileReadService.FileReadService;
import fileWriteService.FileWriteService;
import utils.FilePath;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriteService fileWriteService = new FileWriteService();
        FileReadService fileReadService = new FileReadService();
        FilePath filePath = new FilePath();

        System.out.println("Input '1' if you want read or '2' if you want write file");
        String menu = scanner.nextLine();

        switch (menu) {
            case "1":
                System.out.println("Input name of file");
                String customFileNameForRead = scanner.nextLine();
                if(new File(filePath.BASE_URL + customFileNameForRead + ".txt").exists()) {
                    System.out.println("File contain Text: " + fileReadService.getFile(customFileNameForRead));
                } else {
                    System.out.println("File does not exist. Creating a new file...");
                    System.out.println("Input name of file");
                    String customFileName = scanner.nextLine();
                    System.out.println("Input Text to file");
                    String customContentText = scanner.nextLine();
                    fileWriteService.createFile(customFileName, customContentText);
                }
                break;
            case "2":
                System.out.println("Input name of file");
                String customFileName = scanner.nextLine();
                System.out.println("Input Text to file");
                String customContentText = scanner.nextLine();
                fileWriteService.createFile(customFileName, customContentText);
                break;
            default:
                System.out.println("You inputted wrong number");
        }
    }
}