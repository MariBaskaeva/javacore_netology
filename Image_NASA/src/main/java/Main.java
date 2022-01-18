import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();

        HttpGet request = new HttpGet("https://api.nasa.gov/planetary/apod?api_key=" + getToken("src/main/resources/token"));
        CloseableHttpResponse response = httpClient.execute(request);
        String line, lineInf = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        while((line = reader.readLine()) != null){
            lineInf += line;
        }

        ObjectMapper mapper = new ObjectMapper();
        Nasa nasaInf = mapper.readValue(lineInf, Nasa.class);

        URL url = new URL(nasaInf.getUrl());

        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] resp = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(nasaInf.getUrl().substring(nasaInf.getUrl().lastIndexOf('/') + 1));
        fos.write(resp);
        fos.close();
    }

    public static String getToken(String file) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        return line;
    }
}
