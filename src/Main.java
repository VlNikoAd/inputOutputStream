import java.io.*;

public class Main {

    private static final String[] nameDirectories = {"src" , "res" , "savegames", "temp", "main", "test", "drawables", "vectors", "icons"};

    private static final String[] nameFiles = {"Main.java", "Utils.java", "temp.txt"};

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        createDirectories(str, nameDirectories);
        createFiles(str, nameFiles);
        writeReportOfCreateInFileTxt(str);
        readReportOfCreateFromFileTxt();
    }

    private static void createDirectories(StringBuilder str, String[] nameDirectories) {
        str.append("Создание папок: ");
        File dir;
        for (String name : nameDirectories) {
            switch (name) {
                case "src", "res", "savegames", "temp" -> {
                    dir = new File("/Users/vladislav/Games/" + name);
                    testCreateDir(dir, name, str);
                }

                case "main", "test" -> {
                    dir = new File("/Users/vladislav/Games/src/" + name);
                    testCreateDir(dir, name, str);
                }

                case "drawables", "vectors", "icons" -> {
                    dir = new File("/Users/vladislav/Games/res/" + name);
                    testCreateDir(dir, name, str);
                }
            }
        }
    }

    private static void testCreateDir(File dir, String name, StringBuilder str) {
        if (dir.mkdir())
            str.append("\n" + name + " complete");
        else
            str.append("\n" + name + " something wrong");
    }

    private static void createFiles (StringBuilder str, String[] nameFiles) {
        str.append("\nСоздание файлов: ");
        File file;
        for (String name : nameFiles) {
            switch (name) {
                case "Main.java", "Utils.java" -> {
                    file = new File("/Users/vladislav/Games/src/main/" + name);
                    testCreateFiles(file, name, str);
                }

                case "temp.txt" -> {
                    file = new File("/Users/vladislav/Games/temp/" + name);
                    testCreateFiles(file, name, str);
                }
            }
        }
    }

    private static void testCreateFiles(File file, String name, StringBuilder str) {
        try {
            if (file.createNewFile())
                str.append("\n" + name + " complete");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void writeReportOfCreateInFileTxt(StringBuilder str) {
        System.out.println("Отправка отчета в 'temp.txt'...");
        try (FileWriter writer = new FileWriter("/Users/vladislav/Games/temp//temp.txt", false)) {
            writer.write(String.valueOf(str));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readReportOfCreateFromFileTxt() {
        System.out.println("Чтение отчета из 'temp.txt'...");
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