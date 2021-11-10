import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("");

        File src = new File("C:/Users/maria/OneDrive/Рабочий стол/Netology/Games/src");
        File res = new File("C:/Users/maria/OneDrive/Рабочий стол/Netology/Games/res");
        File savegames = new File("C:/Users/maria/OneDrive/Рабочий стол/Netology/Games/savegames");
        File temp = new File("C:/Users/maria/OneDrive/Рабочий стол/Netology/Games/temp");

        File main = new File(src + "/main");
        File test = new File(src + "/test");

        File mainFile = new File((main + "/Main.java"));
        File utilsFile = new File((main + "/Utils.java"));

        File drawables = new File(res + "/drawables");
        File vectors = new File(res + "/vectors");
        File icons = new File(res + "/icons");

        File tempFile = new File(temp + "/temp.txt");

        if(src.mkdir() && res.mkdir() && savegames.mkdir() && temp.mkdir())
            stringBuilder.insert(stringBuilder.length(), "Каталоги внутри Games созданы.\n");

        if(main.mkdir() && test.mkdir())
            stringBuilder.insert(stringBuilder.length(), "Каталоги внутри src созданы.\n");

        try{
            if(mainFile.createNewFile() && utilsFile.createNewFile()) {
                stringBuilder.insert(stringBuilder.length(), "Файлы Main.java и Utils.java были созданы в директории main.\n");
            }
        } catch(IOException ex){
            stringBuilder.insert(stringBuilder.length(), ex.getMessage() + "\n");
        }

        if(drawables.mkdir() && vectors.mkdir() && icons.mkdir())
            stringBuilder.insert(stringBuilder.length(), "Каталоги внутри res созданы.\n");

        try{
            if(tempFile.createNewFile()) {
                stringBuilder.insert(stringBuilder.length(), "Файл temp.txt был создан в директории temp.\n");
            }
        } catch(IOException ex){
            stringBuilder.insert(stringBuilder.length(), ex.getMessage() + "\n");
        }

        try(FileWriter fileWriter = new FileWriter(tempFile, false)){
            fileWriter.write(String.valueOf(stringBuilder));
            fileWriter.flush();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
