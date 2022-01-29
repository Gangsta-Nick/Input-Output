import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        directoryCreate(sb);
        tempWriter(sb);
        saveGame();
        zipFilesConvetrter();
    }

    public static void directoryCreate(StringBuilder sb) {
        try {
            File dir = new File("D://Games1");
            String dirSuccess = (dir.mkdir() ? dir.getName() + " создан\n" : dir.getName() + " уже был создан или отсутствует\n");
            sb.append(dirSuccess);

            File src = new File(dir, "src");
            String srcSuccess = (src.mkdir() ? src.getName() + " создан\n" : src.getName() + " уже был создан или отсутствует\n");
            sb.append(srcSuccess);

            File test = new File(src, "test");
            String testSuccess = (test.mkdir() ? test.getName() + " создан\n" : test.getName() + " уже был создан или отсутствует\n");
            sb.append(testSuccess);

            File main = new File(src, "main");
            String mainSuccess = (main.mkdir() ? main.getName() + " создан\n" : main.getName() + " уже был создан или отсутствует\n");
            sb.append(mainSuccess);

            File mainJava = new File(main, "Main.java");
            String mainJavaSuccess = (mainJava.createNewFile() ? mainJava.getName() + " создан\n" : mainJava.getName() + " уже был создан или отсутствует\n");
            sb.append(mainJavaSuccess);

            File untilsJava = new File(main, "Utils.java");
            String untilsJavaSuccess = (untilsJava.createNewFile() ? untilsJava.getName() + " создан\n" : untilsJava.getName() + " уже был создан или отсутствует\n");
            sb.append(untilsJavaSuccess);

            File res = new File(dir, "res");
            String resSuccess = (res.mkdir() ? res.getName() + " создан\n" : res.getName() + " уже был создан или отсутствует\n");
            sb.append(resSuccess);

            File drawables = new File(res, "drawables");
            String drawablesSuccess = (drawables.mkdir() ? drawables.getName() + " создан\n" : drawables.getName() + " уже был создан или отсутствует\n");
            sb.append(drawablesSuccess);

            File vectors = new File(res, "vectors");
            String vectorsSuccess = (vectors.mkdir() ? vectors.getName() + " создан\n" : vectors.getName() + " уже был создан или отсутствует\n");
            sb.append(vectorsSuccess);

            File icons = new File(res, "icons");
            String iconsSuccess = (icons.mkdir() ? icons.getName() + " создан\n" : icons.getName() + " уже был создан или отсутствует\n");
            sb.append(iconsSuccess);

            File save = new File(dir, "savegames");
            String saveSuccess = (save.mkdir() ? save.getName() + " создан\n" : save.getName() + " уже был создан или отсутствует\n");
            sb.append(saveSuccess);

            File tempDir = new File(dir, "temp");
            String tempDirSuccess = (tempDir.mkdir() ? tempDir.getName() + " создан\n" : tempDir.getName() + " уже был создан или отсутствует\n");
            sb.append(tempDirSuccess);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void tempWriter(StringBuilder sb) {
        try (Writer writer = new FileWriter("D://Games1/temp/temp.txt", false)) {
            writer.append(sb);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void saveGame() {
        GameProgress gameProgress = new GameProgress(100, 1, 1, 100.0);
        try (FileOutputStream fos = new FileOutputStream("D://Games1/savegames/save.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

//        GameProgress gameProgressOriginal = null;
//        try (FileInputStream fis = new FileInputStream("D://Games1/savegames/save.dat");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            gameProgressOriginal = (GameProgress) ois.readObject();
//        } catch (IOException | ClassNotFoundException exception) {
//            exception.getMessage();
//        }

        GameProgress gameProgress1 = new GameProgress(94, 3, 5, 153.4);
        try (FileOutputStream fos = new FileOutputStream("D://Games1/savegames/save1.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress1);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

//        GameProgress gameProgressOne = null;
//        try (FileInputStream fis = new FileInputStream("D://Games1/savegames/save1.dat");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            gameProgressOne = (GameProgress) ois.readObject();
//        } catch (IOException | ClassNotFoundException exception) {
//            exception.getMessage();
//        }

        GameProgress gameProgress2 = new GameProgress(85, 8, 8, 188.99);
        try (FileOutputStream fos = new FileOutputStream("D://Games1/savegames/save2.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress2);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
//        GameProgress gameProgressTwo = null;
//        try (FileInputStream fis = new FileInputStream("D://Games1/savegames/save2.dat");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            gameProgressTwo = (GameProgress) ois.readObject();
//        } catch (IOException | ClassNotFoundException exception) {
//            exception.getMessage();
//        }

    public static void zipFilesConvetrter() {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream("D://Games1/game_saves.zip"));
             FileInputStream fis = new FileInputStream("D://Games1/savegames/save.dat");
             FileInputStream fis1 = new FileInputStream("D://Games1/savegames/save1.dat");
             FileInputStream fis2 = new FileInputStream("D://Games1/savegames/save2.dat")) {
            ZipEntry entry = new ZipEntry("save.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
            ZipEntry entry1 = new ZipEntry("save1.dat");
            zout.putNextEntry(entry1);
            byte[] buffer1 = new byte[fis1.available()];
            fis1.read(buffer1);
            zout.write(buffer1);
            zout.closeEntry();
            ZipEntry entry2 = new ZipEntry("save2.dat");
            zout.putNextEntry(entry2);
            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);
            zout.write(buffer2);
            zout.closeEntry();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

//    public static void zipOpen() {
//        try (ZipInputStream zis = new ZipInputStream(new FileInputStream("D://Games1/game_saves.zip"))) {
//            ZipEntry entry;
//            String name;
//            while ((entry = zis.getNextEntry()) != null) {
//                name = entry.getName();
//                FileOutputStream fout = new FileOutputStream(name);
//                for (int c = zis.read(); c != -1; c = zis.read()) {
//                    fout.write(c);
//                }
//                fout.flush();
//                zis.closeEntry();
//                fout.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}