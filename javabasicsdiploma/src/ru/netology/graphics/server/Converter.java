package ru.netology.graphics.server;

import ru.netology.graphics.image.BadImageSizeException;
import ru.netology.graphics.image.TextColorSchema;
import ru.netology.graphics.image.TextGraphicsConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;

public class Converter implements TextGraphicsConverter {
    private Integer maxWidth = null;
    private Integer maxHeight = null;
    private Double maxRatio = null;
    private TextColorSchema schema = new ColorSchema();

    @Override
    public String convert(String url) throws IOException, BadImageSizeException {

        BufferedImage img = ImageIO.read(new URL(url));

        //проверка на соотношение сторон
        if(!(maxRatio.equals(null))){
            Double ratio = (double) img.getHeight() / (double) img.getWidth();
            if(ratio > maxRatio)
                throw new BadImageSizeException(maxRatio, ratio);
        }
        //проверка на ширину и длину

        Integer newHeight = img.getHeight();
        Integer newWidth = img.getWidth();

        if(!(maxHeight.equals(null)) || !(maxWidth.equals(null))){
            if(newHeight > maxHeight){
                Double value = (double) newHeight / (double) maxHeight;
                newHeight = (int) (newHeight / value);
                newWidth = (int) (newWidth / value);
            }
            if(newWidth > maxWidth){
                Double value = (double) newWidth / (double) maxWidth;
                newHeight = (int) (newHeight / value);
                newWidth = (int) (newWidth / value);
            }
        }

        Image scaledImage = img.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH);
        BufferedImage bwImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = bwImg.createGraphics();
        graphics.drawImage(scaledImage, 0, 0, null);

        WritableRaster bwRaster = bwImg.getRaster();

        String result = "";

        for(int h = 0; h < newHeight; h++){
            for(int w = 0; w < newWidth; w++){
                int color = bwRaster.getPixel(w, h, new int[3])[0];
                char c = schema.convert(color);
                result += c + "" + c;
            }
            result += "\n";
        }



        return result;
    }

    @Override
    public void setMaxWidth(int width) {
        this.maxWidth = width;
    }

    @Override
    public void setMaxHeight(int height) {
        this.maxHeight = height;
    }

    @Override
    public void setMaxRatio(double maxRatio) {
        this.maxRatio = maxRatio;
    }

    @Override
    public void setTextColorSchema(TextColorSchema schema) {
        this.schema = schema;
    }
}