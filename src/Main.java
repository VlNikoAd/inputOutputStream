import java.io.*;

public class Main {

    private static final String[] directories = { "/Users/vladislav/Games/src", "/Users/vladislav/Games/res",
            "/Users/vladislav/Games/savegames", "/Users/vladislav/Games/temp", "/Users/vladislav/Games/src/main",
            "/Users/vladislav/Games/src/test", "/Users/vladislav/Games/res/drawables", "/Users/vladislav/Games/res/vectors",
            "/Users/vladislav/Games/res/icons"};

    private static final String[] files = {"/Users/vladislav/Games/src/main/Main.java",
            "/Users/vladislav/Games/src/main/Utils.java", "/Users/vladislav/Games/temp/temp.txt"};

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        createDirectoriesRefactoring(str, directories);
        createFilesRefactoring(str, files);
        
        writeReportOfCreateInFileTxt(str);
        readReportOfCreateFromFileTxt();
    }

    private static void createDirectoriesRefactoring(StringBuilder str, String[] directories) {
        str.append("Создание папок: ");
        for (String name : directories) {
            File dir = new File(name);
            if (dir.mkdir())
                str.append("\n" + name + " complete");
            else
                str.append("\n" + name + " something wrong");
        }
    }

    private static void createFilesRefactoring(StringBuilder str, String[] files) {
        str.append("\nСоздание файлов: ");
        for (String name : files) {
            File file  = new File(name);
            try {
                if (file.createNewFile())
                    str.append("\n" + name + " complete");
                else
                    str.append("\n" + name + " something wrong");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void writeReportOfCreateInFileTxt(StringBuilder str) {
        System.out.println("Отправка отчета в 'temp.txt'...");
        try (FileWriter writer = new FileWriter("/Users/vladislav/Games/temp/temp.txt", false)) {
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