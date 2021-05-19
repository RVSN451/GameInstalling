package com.kostakov.core.File_IO_Serial.gameInstalling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class OperationGameProgress {

    public static void serializationGameProgress(ArrayList<GameProgress> gpList, String path) {
        int i = 0;
        for (GameProgress gp : gpList) {
            try (FileOutputStream fos = new FileOutputStream(path + "/GP" + i + ".dat", false);
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(gp);
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<GameProgress> deserializationGameProgress(ArrayList<GameProgress> gpList, String path) {

        OnlyExt dat = new OnlyExt("dat");

        File[] gpDat = new File(path).listFiles(dat);
        for (File gp : gpDat) {
            try (FileInputStream fis = new FileInputStream(gp);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                gpList.add((GameProgress) ois.readObject());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return gpList;
    }

    public static void gpToZip(File[] files, String path) throws IOException {

        ZipOutputStream zout = new ZipOutputStream
                (new FileOutputStream(path + "/GP.zip"));
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(f.getName() + " является директорией. Архивации не подлежит.");
            } else {
                fileToZip(f, zout);
                System.out.println("Удаление файла " + f.getAbsolutePath() + " результат: " + f.delete());
            }
        }
        zout.flush();
        zout.close();
    }

    private static void fileToZip(File f, ZipOutputStream zout) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        zout.putNextEntry(new ZipEntry(f.getName()));

        byte buffer[] = new byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();
        fis.close();
    }

    public static void fileFromZip(String unzipPath, String zipPath) throws IOException {
        ZipInputStream zin = new ZipInputStream
                (new FileInputStream(zipPath));
        ZipEntry entry;
        String name;
        int i = 0;

        while ((entry = zin.getNextEntry()) != null) {
            name = unzipPath + "/open_" + entry.getName();
            FileOutputStream fout = new FileOutputStream(name);
            for (int c = zin.read(); c != -1; c = zin.read()) {
                fout.write(c);
            }
            fout.flush();
            zin.closeEntry();
            fout.close();
            i++;
        }
        zin.close();

        File GP = new File(zipPath);
        System.out.println("\tРезультат удаления файла GP.zip - " + GP.delete());

        File[] openGP = new File("C:/GameKost/savegames").listFiles();
        for (File f : openGP) {
            f.deleteOnExit();
        }
    }
}

