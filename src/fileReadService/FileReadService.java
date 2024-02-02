package fileReadService;

import utils.FilePath;

import java.io.FileReader;
import java.io.IOException;

public class FileReadService {
    FilePath filePath = new FilePath();

    public String getFile(String customFileNameForRead) {
        try (FileReader reader = new FileReader(filePath.BASE_URL + customFileNameForRead + ".txt")) {
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
}






