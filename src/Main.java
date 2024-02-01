import fileReadService.FileReadService;
import fileWriteService.FileWriteService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input '1' if you want read or '2' if you want write file");
        String menu = scanner.nextLine();

        switch (menu) {
            case "1":
                System.out.println("Input name of file");
                String customFileNameForRead = scanner.nextLine();
                FileReadService.createFile(customFileNameForRead);
                System.out.println(FileReadService.getFile());
            break;
            case "2":
                System.out.println("Input name of file");
                String customFileName = scanner.nextLine();
                System.out.println("Input content to file");
                String customContentText = scanner.nextLine();
                FileWriteService.createFile(customFileName, customContentText);
            default:
                System.out.println("You inputted wrong number");
        }
    }
}