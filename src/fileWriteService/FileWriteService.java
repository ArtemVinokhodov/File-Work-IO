package fileWriteService;

import fileReadService.FileReadService;
import utils.FilePath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {
    public static File file;
    public String newFilename;
    FilePath filePath = new FilePath();
    FileReadService fileReadService = new FileReadService();

    public void createFile(String customFileName, String customContentText) throws IOException {
        try {
            file = new File(filePath.BASE_URL + customFileName + ".txt");
            if(file.createNewFile()) {
                System.out.println("Created " + filePath.BASE_URL + customFileName + ".txt");
            } else {
                System.out.println("File already exists: " + file.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getPath())) {
            byte[] bytes = customContentText.getBytes();
            fileOutputStream.write(bytes);
            newFilename = customFileName + ".txt";
            System.out.println("New Text added");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileReadService.getFile(newFilename);
    }
}
