import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        System.out.println("Создание директорий, папок, файлов...");
        createDirectoriesSrcResSavegamesTempInGames(str);
        createDirectoriesMainAndTestInSrc(str);
        createFilesMainAndUtilsInMain(str);
        createDirectoriesDrawablesVectorsIconsInRes(str);
        createFileInTemp(str);

        System.out.println("Отправка отчета в 'temp.txt'...");
        writeReportOfCreateInFileTxt(str);

        System.out.println("Чтение отчета из 'temp.txt'...");
        readReportOfCreateFromFileTxt();
    }

    private static void createDirectoriesSrcResSavegamesTempInGames(StringBuilder str) {
        List<String> newDirectories = Arrays.asList("src", "res", "savegames", "temp");
        str.append("Этап1: ");
        for (String name : newDirectories) {
            File dir = new File("/Users/vladislav/Games/" + name);
            if (dir.mkdir())
                str.append("\n" + name + " complete");
            else
                str.append("\n" + name + " something wrong");
        }
    }

    private static void createDirectoriesMainAndTestInSrc(StringBuilder str) {
        List<String> newDirectories = Arrays.asList("main", "test");
        str.append("\nЭтап2: ");
        for (String name : newDirectories) {
            File dir = new File("/Users/vladislav/Games/src/" + name);
            if (dir.mkdir())
                str.append("\n" + name + " complete");
            else
                str.append("\n" + name + " something wrong");
        }
    }

    private static void createFilesMainAndUtilsInMain(StringBuilder str) {
        List<String> newFiles = Arrays.asList("Main.java", "Utils.java");
        str.append("\nЭтап3: ");
        for (String name : newFiles) {
            File myFile = new File("/Users/vladislav/Games/src/main/" + name);
            try {
                if (myFile.createNewFile())
                    str.append("\n" + name + " complete");
                else
                    str.append("\n" + name + " something wrong");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void createDirectoriesDrawablesVectorsIconsInRes(StringBuilder str) {
        List<String> newDirectories = Arrays.asList("drawables", "vectors", "icons");
        str.append("\nЭтап4: ");
        for (String name : newDirectories) {
            File dir = new File("/Users/vladislav/Games/res/" + name);
            if (dir.mkdir())
                str.append("\n" + name + " complete");
            else
                str.append("\n" + name + " something wrong");
        }
    }

    private static void createFileInTemp(StringBuilder str) {
        str.append("\nЭтап5: ");
        File myFile = new File("/Users/vladislav/Games/temp//temp.txt");
        try {
            if (myFile.createNewFile())
                str.append("\n'temp.txt' complete");
            else
                str.append("\n'temp.txt' something wrong");
        } catch (IOException ex) {
            str.append(ex.getMessage());
        }
    }

    private static void writeReportOfCreateInFileTxt(StringBuilder str) {
        try (FileWriter writer = new FileWriter("/Users/vladislav/Games/temp//temp.txt", false)) {
            writer.write(String.valueOf(str));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readReportOfCreateFromFileTxt() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("/Users/vladislav/Games/temp/temp.txt")
                )
        )) {
            String report;
            while ((report = br.readLine()) != null) {
                System.out.println(report);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}