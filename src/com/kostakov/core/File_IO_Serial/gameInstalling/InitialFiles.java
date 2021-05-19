package com.kostakov.core.File_IO_Serial.gameInstalling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InitialFiles {
    
    public static void creationInitialFiles(){
        StringBuilder sb = new StringBuilder();

        File gameKost = new File("C://", "GameKost");
        sb.append((gameKost.mkdir()) ? "Directory was created: " + gameKost.getAbsolutePath()
                : "Directory creation error: " + gameKost.getAbsolutePath()).append("\n");
        gameKost.deleteOnExit();

        File srs = new File(Main.GAME_PATH, "srs");
        sb.append((srs.mkdir()) ? "Directory was created: " + srs.getAbsolutePath()
                : "Directory creation error: " + srs.getAbsolutePath()).append("\n");
        srs.deleteOnExit();

        File res = new File(Main.GAME_PATH, "res");
        sb.append((res.mkdir()) ? "Directory was created: " + res.getAbsolutePath()
                : "Directory creation error: " + res.getAbsolutePath()).append("\n");
        res.deleteOnExit();

        File drawables = new File(Main.GAME_PATH + "/res", "drawables");
        sb.append((drawables.mkdir()) ? "Directory was created: " + drawables.getAbsolutePath()
                : "Directory creation error: " + drawables.getAbsolutePath()).append("\n");
        drawables.deleteOnExit();

        File vectors = new File(Main.GAME_PATH + "/res", "vectors");
        sb.append((vectors.mkdir()) ? "Directory was created: " + vectors.getAbsolutePath()
                : "Directory creation error: " + vectors.getAbsolutePath()).append("\n");
        vectors.deleteOnExit();

        File icons = new File(Main.GAME_PATH + "/res", "icons");
        sb.append((icons.mkdir()) ? "Directory was created: " + icons.getAbsolutePath()
                : "Directory creation error: " + icons.getAbsolutePath()).append("\n");
        icons.deleteOnExit();

        File savegames = new File(Main.GAME_PATH, "savegames");
        sb.append((savegames.mkdir()) ? "Directory was created: " + savegames.getAbsolutePath()
                : "Directory creation error: " + savegames.getAbsolutePath()).append("\n");
        savegames.deleteOnExit();

        File someDir = new File(Main.GAME_PATH, "savegames/someDir");
        sb.append((someDir.mkdir()) ? "Directory was created: " + someDir.getAbsolutePath()
                : "Directory creation error: " + someDir.getAbsolutePath()).append("\n");
        someDir.deleteOnExit();



        File temp = new File(Main.GAME_PATH, "temp");
        sb.append((temp.mkdir()) ? "Directory was created: " + temp.getAbsolutePath()
                : "Directory creation error: " + temp.getAbsolutePath()).append("\n");
        temp.deleteOnExit();

        File tempExTxt = new File(Main.GAME_PATH + "/temp", "Temp.txt");
        try {
            sb.append((tempExTxt.createNewFile()) ? "File was created: " + tempExTxt.getAbsolutePath()
                    : "File creation error: " + tempExTxt.getAbsolutePath()).append("\n");
            tempExTxt.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File main = new File(Main.GAME_PATH + "/srs", "main");
        sb.append((main.mkdir()) ? "Directory was created: " + main.getAbsolutePath()
                : "Directory creation error: " + main.getAbsolutePath()).append("\n");
        main.deleteOnExit();

        File mainExJava = new File(Main.GAME_PATH + "/srs/main", "Main.java");
        try {
            sb.append((mainExJava.createNewFile()) ? "File was created: " + mainExJava.getAbsolutePath()
                    : "File creation error: " + mainExJava.getAbsolutePath()).append("\n");
            mainExJava.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File utilsExJava = new File(Main.GAME_PATH + "/srs/main", "Utils.java");
        try {
            sb.append((utilsExJava.createNewFile()) ? "File was created: " + utilsExJava.getAbsolutePath()
                    : "File creation error: " + utilsExJava.getAbsolutePath()).append("\n");
            utilsExJava.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File test = new File(Main.GAME_PATH + "/srs", "test");
        sb.append((test.mkdir()) ? "Directory was created: " + test.getAbsolutePath()
                : "Directory creation error: " + test.getAbsolutePath()).append("\n");
        test.deleteOnExit();

        System.out.println(sb);

        try (FileWriter fw = new FileWriter("C:/GameKost/temp/temp.txt", false)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
