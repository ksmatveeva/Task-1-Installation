import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstallation {

    public static void main(String[] args) {

        String gamesPath = "Games";


        createDirectory(gamesPath, "src");
        createDirectory(gamesPath + "/src", "main");
        createDirectory(gamesPath + "/src", "test");
        createDirectory(gamesPath, "res");
        createDirectory(gamesPath + "/res", "drawables");
        createDirectory(gamesPath + "/res", "vectors");
        createDirectory(gamesPath + "/res", "icons");
        createDirectory(gamesPath, "savegames");
        createDirectory(gamesPath, "temp");


        createFile(gamesPath + "/src/main", "Main.java");
        createFile(gamesPath + "/src/main", "Utils.java");
        createFile(gamesPath + "/temp", "temp.txt");


        writeLogToFile(gamesPath + "/temp/temp.txt");
    }


    private static void createDirectory(String parentPath, String directoryName) {
        File directory = new File(parentPath, directoryName);
        boolean success = directory.mkdir();
        System.out.println("Создана директория: " + directory.getAbsolutePath() + " - " + (success ? "Успешно" : "Неудача"));
    }


    private static void createFile(String parentPath, String fileName) {
        File file = new File(parentPath, fileName);
        try {
            boolean success = file.createNewFile();
            System.out.println("Создан файл: " + file.getAbsolutePath() + " - " + (success ? "Успешно" : "Неудача"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLogToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Установка завершена. Все файлы и директории созданы успешно.");
            System.out.println("Лог успешно записан в файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void installGame() {
    }
}