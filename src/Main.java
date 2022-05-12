import java.io.*;

public class Main {

    public static void main(String[] args) {
        String targetDir = "C:/Games";
        File dirGames = new File(targetDir);
        dirGames.mkdir();

        StringBuilder sb = new StringBuilder();

        String inGameDir[] = {"src", "res", "savegames", "temp"};
        String inSrcDir[] = {"main", "test"};
        String inResDir[] = {"drawables", "vectors", "icons"};
        String inMainFiles[] = {"Main.java", "Utils.java"};

        sb.append(makeDirectory(targetDir, inGameDir));
        sb.append(makeDirectory(targetDir + "/src", inSrcDir));
        sb.append(makeDirectory(targetDir + "/res", inResDir));
        sb.append(makeFile(targetDir + "/res/", inMainFiles));

        String report = sb.toString();
        System.out.println(report);

        File temp = new File(targetDir + "/temp/temp.txt");
        try {
            temp.createNewFile();
        } catch (IOException e) {
            System.out.println("Файл не создан");
        }

        try (FileWriter text = new FileWriter(targetDir + "/temp/temp.txt")) {
            text.write(report);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String makeDirectory(String targetDir, String[] dirArray) {
        StringBuilder sb = new StringBuilder();
        for (String dir : dirArray) {
            File newDir = new File(targetDir + "/" + dir);
            if (newDir.mkdir()) {
                sb.append("Каталог " + targetDir + "/" + dir + " создан" + "\n");
            } else {
                sb.append("Каталог " + targetDir + "/" + dir + " не создан" + "\n");
            }
        }
        return sb.toString();
    }

    public static String makeFile(String targetDir, String[] fileArray) {
        StringBuilder sb = new StringBuilder();
        for (String file : fileArray) {
            File newFile = new File(targetDir + file);
            try {
                if (newFile.createNewFile()) {
                    sb.append("Файл " + file + " создан" + "\n");
                } else {
                    sb.append("Файл " + file + " не создан" + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return sb.toString();
    }
}