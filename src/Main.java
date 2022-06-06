import java.io.*;

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

    private static void createDirectoriesSrcResSavegamesTempInGames (StringBuilder str) {
        str.append("Этап1: ");
        File dir = new File("/Users/vladislav/Games/src");
        if (dir.mkdir())
            str.append("\n'src' complete");
        else
            str.append("\n'src' something wrong");

        File dir1 = new File("/Users/vladislav/Games/res");
        if (dir1.mkdir())
            str.append("\n'res' complete");
        else
            str.append("\n'res' something wrong");

        File dir2 = new File("/Users/vladislav/Games/savegames");
        if (dir2.mkdir())
            str.append("\n'savegames' complete");
        else
            str.append("\n'savegames' something wrong");

        File dir3 = new File("/Users/vladislav/Games/temp");
        if (dir3.mkdir())
            str.append("\n'temp' complete");
        else
            str.append("\n'temp' something wrong");
    }

    private static void createDirectoriesMainAndTestInSrc (StringBuilder str) {
        str.append("\nЭтап2: ");
        File dir = new File("/Users/vladislav/Games/src/main");
        if (dir.mkdir())
            str.append("\n'main' complete");
        else
            str.append("\n'main' something wrong");

        File dir1 = new File("/Users/vladislav/Games/src/test");
        if (dir1.mkdir())
            str.append("\n'test' complete");
        else
            str.append("\n'test' something wrong");
    }

    private static void createFilesMainAndUtilsInMain(StringBuilder str) {
        str.append("\nЭтап3: ");
        File myFile = new File("/Users/vladislav/Games/src/main//Main.java");
        try {
            if (myFile.createNewFile())
                str.append("\n'Main.java' compete");
            else
                str.append("\n'Main.java' something wrong");
        } catch (IOException ex) {
            str.append(ex.getMessage());
        }

        File myFile1 = new File("/Users/vladislav/Games/src/main//Utils.java");
        try {
            if (myFile1.createNewFile())
                str.append("\n'Utils.java' complete");
            else
                str.append("\n'Utils.java' something wrong");
        } catch (IOException ex) {
            str.append(ex.getMessage());
        }
    }

    private static void createDirectoriesDrawablesVectorsIconsInRes(StringBuilder str) {
        str.append("\nЭтап4: ");
        File dir = new File("/Users/vladislav/Games/res/drawables");
        if (dir.mkdir())
            str.append("\n'drawables' complete");
        else
            str.append("\n'drawables' something wrong");

        File dir1 = new File("/Users/vladislav/Games/res/vectors");
        if (dir1.mkdir())
            str.append("\n'vectors' complete");
        else
            str.append("\n'vectors' something wrong.");

        File dir2 = new File("/Users/vladislav/Games/res/icons");
        if (dir2.mkdir())
            str.append("\n'icons' complete");
        else
            str.append("\n'icons' something wrong.");
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
        try (FileWriter writer = new FileWriter("/Users/vladislav/Games/temp//temp.txt", false)){
            writer.write(String.valueOf(str));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readReportOfCreateFromFileTxt() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("/Users/vladislav/Games/temp//temp.txt")
                )
        )) {
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
