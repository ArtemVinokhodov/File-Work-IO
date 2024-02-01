package fileWriteService;

import utils.FilePath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {
    public static File file;

    public static void createFile(String customFileName, String customContentText) throws IOException {
        try {
            file = new File(FilePath.BASE_URL + customFileName + ".txt");
            file.createNewFile();
            System.out.println("Created " + FilePath.BASE_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getPath())) {
            String data = customContentText;
            byte[] bytes = data.getBytes();
            fileOutputStream.write(bytes);
            System.out.println("Text added");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
