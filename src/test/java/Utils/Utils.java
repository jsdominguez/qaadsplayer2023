package Utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Utils {
    public void sendStatusAdsSlack(String ads){
        try {
            //URL url = new URL("https://hooks.slack.com/services/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");
            //hook prueba
            URL url = new URL("https://hooks.slack.com/services/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");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/json");

            String data = "{'text':'"+ ads +"'}";

            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
            http.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
