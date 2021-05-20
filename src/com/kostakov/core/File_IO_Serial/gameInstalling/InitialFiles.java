package com.kostakov.core.File_IO_Serial.gameInstalling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InitialFiles {
    
    public static File makeDir(String parent, String child) {
        File newFile = new File(parent, child);
        return newFile;
    }

    public static String dirLog (File file,  boolean  deleteOnExit) {
        String s = ((file.mkdir()) ? "Directory was created: " + file.getAbsolutePath()
                : "Directory creation error: " + file.getAbsolutePath() + "\n");
        if (deleteOnExit) file.deleteOnExit();
        return s;
    }

    public static String fileLog (File file,  boolean  deleteOnExit) {
        String s = null;
        try {
            s = ((file.createNewFile()) ? "File was created: " + file.getAbsolutePath()
                    : "File creation error: " + file.getAbsolutePath() + "\n");
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (deleteOnExit) file.deleteOnExit();
        return s;
    }


    public static void creationInitialFiles(){
        StringBuilder sb = new StringBuilder();


        File gameKost = new File("C://", "GameKost");
        sb.append(dirLog(gameKost, true));

        File srs = new File(Main.GAME_PATH, "srs");
        sb.append(dirLog(srs, true));

        File res = new File(Main.GAME_PATH, "res");
        sb.append(dirLog(res, true));

        File drawables = new File(Main.GAME_PATH + "/res", "drawables");
        sb.append(dirLog(drawables, true));

        File vectors = new File(Main.GAME_PATH + "/res", "vectors");
        sb.append(dirLog(vectors, true));

        File icons = new File(Main.GAME_PATH + "/res", "icons");
        sb.append(dirLog(icons, true));

        File savegames = new File(Main.GAME_PATH, "savegames");
        sb.append(dirLog(savegames,true));

        File someDir = new File(Main.GAME_PATH, "savegames/someDir");
        sb.append(dirLog(someDir, true));

        File temp = new File(Main.GAME_PATH, "temp");
        sb.append(dirLog(temp, true));

        File tempExTxt = new File(Main.GAME_PATH + "/temp", "Temp.txt");
        sb.append(fileLog(tempExTxt, true));

        File main = new File(Main.GAME_PATH + "/srs", "main");
        sb.append(dirLog(main,true));

        File mainExJava = new File(Main.GAME_PATH + "/srs/main", "Main.java");
        sb.append(fileLog(mainExJava,true));

        File utilsExJava = new File(Main.GAME_PATH + "/srs/main", "Utils.java");
        sb.append(fileLog(utilsExJava,true));



        File test = new File(Main.GAME_PATH + "/srs", "test");
        sb.append(dirLog(test,true));

        System.out.println(sb);

        try (FileWriter fw = new FileWriter("C:/GameKost/temp/temp.txt", false)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
