import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        File directory = new File("C:/Users/maria/OneDrive/Рабочий стол/Netology/Games/savegames");
        openZip(directory + "/zip.zip", directory.toString());

        for(File item: directory.listFiles()){
            if(item.isFile() && !(item.getPath().equals(directory + "\\zip.zip"))){
                System.out.println(openProgress(item.getPath()));
            }
        }
    }
    static void openZip(String pathZip, String pathOut){
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip))){
            ZipEntry entry;
            String name;
            while((entry = zis.getNextEntry()) != null){
                name = entry.getName();
                FileOutputStream fos = new FileOutputStream(pathOut + "/" + name);
                for(int c = zis.read(); c != -1; c = zis.read()){
                    fos.write(c);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static GameProgress openProgress(String path){
        GameProgress gameProgress = null;
        try(FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis)){
                gameProgress = (GameProgress) ois.readObject();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }
}
