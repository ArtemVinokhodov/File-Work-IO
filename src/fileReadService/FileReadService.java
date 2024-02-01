package fileReadService;

import utils.FilePath;
import java.io.*;

public class FileReadService {
    public static File file;
    public static String newFilename;

    public static String getFile() {
        try (FileReader reader = new FileReader(FilePath.BASE_URL + newFilename)) {
            // Читаємо по символам
            int sym;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);
            }
            return stringBuilder.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public static void createFile(String customFileNameForRead) throws IOException {
        try {
            file = new File(FilePath.BASE_URL + customFileNameForRead + ".txt");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getPath())) {
            String data = "This text in your file";
            byte[] bytes = data.getBytes();
            fileOutputStream.write(bytes);
            newFilename = customFileNameForRead + ".txt";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getFile();
    }
}






