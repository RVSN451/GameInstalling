package com.kostakov.core.File_IO_Serial.gameInstalling;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static final String GAME_PATH = "C://GameKost";
    public static final String PATH_SAVAGAME = "C://GameKost/savegames";
    public static final String PATH_SAVAGAME_ZIP = "C://GameKost/savegames/GP.zip";
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static String consoleReadString() {
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static void user() {

        System.out.println("Убедитесь, что программа выполнила действия корректно. " +
                "\nДля продолжения работы программы введите '1'");

        if (!consoleReadString().equals("1")) {
            System.out.println("Направьте замечания по работе программы разработчику.\n");
        }
    }


    public static void main(String[] args) {

        InitialFiles.creationInitialFiles();
        System.out.println("\tФайловая система для игры создана.");
        user();

        ArrayList<GameProgress> gpList = new ArrayList<>();

        System.out.println("\n\tGameProgress созданы, распечатаны из оперативной памяти выполняемой программы:");
        for (int i = 0; i < 3; i++) {

            gpList.add(new GameProgress(
                    new Random().nextInt(100),
                    1 + new Random().nextInt(15),
                    1 + new Random().nextInt(5),
                    100 * new Random().nextDouble()
            ));
        }
        gpList.stream()
                .forEach(System.out::println);

        OperationGameProgress.serializationGameProgress(gpList, PATH_SAVAGAME);

        System.out.println("\n\tGameProgress сериализованы и  сохранены в папке savegames");
        user();

        System.out.println("\nКоллекция GameProgress пуста? - " + gpList.isEmpty());
        System.out.println("Произведена очистка коллекции GameProgress.");

        gpList.clear();

        System.out.println("Коллекция GameProgress пуста? - " + gpList.isEmpty());
        user();


        try {
            OnlyExt dat = new OnlyExt("dat");
            OperationGameProgress.gpToZip((new File(Main.PATH_SAVAGAME)).listFiles(dat), PATH_SAVAGAME);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\tСериализованные GameProgress  добавлены в архив GP.zip.");
        user();

        System.out.println();


        try {
            OperationGameProgress.fileFromZip(PATH_SAVAGAME, PATH_SAVAGAME_ZIP);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\tФайлы  GameProgress разархивированы, извлечены из GP.zip и помещены в папку savegames.");
        user();

        gpList = OperationGameProgress.deserializationGameProgress(gpList, PATH_SAVAGAME);
        System.out.println("\n\tДесериализованная коллекция GameProgress:");
        gpList.stream()
                .forEach(System.out::println);
        user();


        System.out.println("\n\tРабота программы завершена." +
                "\n\nВСЕ СОЗДАННЫЕ ПРОГРАММОЙ ПАПКИ И ФАЙЛЫ УДАЛЕНЫ ВОИЗБЕЖАНИЕ ЗАСОРЕНИЯ ПАМЯТИ ВАШЕГО КОМПЬЮТЕРА(УСТРОЙСТВА).");

    }
}
