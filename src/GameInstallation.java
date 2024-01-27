import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameInstallation {

    public static void main(String[] args) {
        String gamesPath = "/Users/kseniamatveeva/Games";


        List<String> directories = new ArrayList<>();
        directories.add("src");
        directories.add("src/main");
        directories.add("src/test");
        directories.add("res");
        directories.add("res/drawables");
        directories.add("res/vectors");
        directories.add("res/icons");
        directories.add("savegames");
        directories.add("temp");


        List<String> files = new ArrayList<>();
        files.add("src/main/Main.java");
        files.add("src/main/Utils.java");
        files.add("temp/temp.txt");


        installGame(gamesPath, directories, files);
    }

    private static void installGame(String gamesPath, List<String> directories, List<String> files) {

        for (String directory : directories) {
            createDirectory(gamesPath, directory);
        }


        for (String file : files) {
            createFile(gamesPath, file);
        }


        StringBuilder log = new StringBuilder();
        log.append("Установка завершена. Все файлы и директории созданы успешно.");

        writeLogToFile(gamesPath + "/temp/temp.txt", log.toString());
    }

    private static void createDirectory(String parentPath, String directoryName) {
        File directory = new File(parentPath, directoryName);
        boolean success = directory.mkdir();
        System.out.println("Создана директория: " + directory.getAbsolutePath() + " - " + (success ? "Успешно" : "Неудача"));

        // Добавляем запись в лог
        logToFile(parentPath + "/temp/temp.txt", "Создана директория: " + directory.getAbsolutePath() + " - " + (success ? "Успешно" : "Неудача"));
    }

    private static void createFile(String parentPath, String filePath) {
        File file = new File(parentPath, filePath);
        try {
            boolean success = file.createNewFile();
            System.out.println("Создан файл: " + file.getAbsolutePath() + " - " + (success ? "Успешно" : "Неудача"));

            // Добавляем запись в лог
            logToFile(parentPath + "/temp/temp.txt", "Создан файл: " + file.getAbsolutePath() + " - " + (success ? "Успешно" : "Неудача"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLogToFile(String filePath, String log) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(log);
            System.out.println("Лог успешно записан в файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logToFile(String filePath, String log) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(log + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
