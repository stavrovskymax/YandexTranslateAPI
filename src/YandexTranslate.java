import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class YandexTranslate {
    public static String translate(String input) throws IOException {
        String API_KEY = new String(Files.readAllBytes(Paths.get("src\\.config")));
        String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + API_KEY + "&text=" + URLEncoder.encode(input, "UTF-8") + "&lang=ru";
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");
        String translated = json.substring(start + 2, end - 1);
        return translated;
    }
}
