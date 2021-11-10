import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        File path = new File("C:/Users/maria/OneDrive/Рабочий стол/Netology/Games/savegames");

        File file0 = new File(path + "/file0.txt");
        File file1 = new File(path + "/file1.txt");
        File file2 = new File(path + "/file2.txt");

        GameProgress game1 = new GameProgress(100, 4, 12, 200.50);
        GameProgress game2 = new GameProgress(90, 8, 50, 40.7);
        GameProgress game3 = new GameProgress(58, 1, 99, 2.1);

        saveGame(file0.toString(), game1);
        saveGame(file1.toString(), game2);
        saveGame(file2.toString(), game3);

        List<String> list = new ArrayList<String>();
        list.add(file0.toString());
        list.add(file1.toString());
        list.add(file2.toString());

        zipFiles(path + "/zip.zip", list);

        file0.delete();
        file1.delete();
        file2.delete();
    }

    static void saveGame(String path, GameProgress game){
        try(FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(game);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static void zipFiles(String path, List<String> list){
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path))){
            while(!list.isEmpty()){
                try(FileInputStream fis = new FileInputStream(list.remove(0))){
                    String name = "savings" + (new Random()).nextInt() + ".txt";
                    ZipEntry entry = new ZipEntry(name);
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zos.write(buffer);
                    zos.closeEntry();
                } catch(IOException exception){
                    System.out.println(exception.getMessage());
                }
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
