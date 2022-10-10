import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class dj {

    public static  void main(String[]args) throws IOException {
        dj obj=new dj();
        obj.tokenrequest();
        obj.userdetaisl();
        player.main();



    }

    static String token;
    static String random;
    static String Bearear;
    static String  videourl;
    public String getvideurl(){

        return  videourl;
    }


    public static String parse(String responsebody){
        System.out.println(responsebody);
        JSONObject obj=new JSONObject(responsebody);
        JSONObject temp= (JSONObject) obj.get("js");
        token=(String) temp.get("token");
        random=(String) temp.get("random");

        return  null;
    }
    public static  void tokenrequest(){
        Bearear="Bearer "+token;
        HttpClient client =HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create("http://tv.tvzon.tv/stalker_portal/server/load.php?type=stb&action=handshake&token=&prehash=0&JsHttpRequest=1-xml"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(dj::parse).join();

    }
    public static void   userdetaisl() throws IOException {

        URL url1 = new URL("http://tv.tvzon.tv/stalker_portal/server/load.php?type=stb&action=get_profile&hd=1&ver=ImageDescription%3A%200.2.18-r14-pub-250%3B%20ImageDate%3A%20Fri%20Jan%2015%2015%3A20%3A44%20EET%202016%3B%20PORTAL%20version%3A%205.1.0%3B%20API%20Version%3A%20JS%20API%20version%3A%20328%3B%20STB%20API%20version%3A%20134%3B%20Player%20Engine%20version%3A%200x566&num_banks=2&sn=AB3535546DFD0&stb_type=MAG250&image_version=218&video_out=hdmi&device_id=&device_id2=&signature=&auth_second_step=1&hw_version=1.7-BD-00&not_valid_token=0&client_type=STB&hw_version_2=ab3535546dfd0cd6ce57c871f70d4106&timestamp=1665415140&api_signature=263&metrics=%7B%22mac%22%3A%2200%3A1A%3A79%3A2E%3A7F%3A85%22%2C%22sn%22%3A%22AB3535546DFD0%22%2C%22model%22%3A%22MAG250%22%2C%22type%22%3A%22STB%22%2C%22uid%22%3A%22%22%2C%22random%22%3A%2221fe2afbfee0f22ea9ddad3af973b840%22%7D&JsHttpRequest=1-xml");
        HttpURLConnection httpConn = (HttpURLConnection) url1.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("User-Agent", "Mozilla/5.0 (QtEmbedded; U; Linux; C) AppleWebKit/533.3 (KHTML, like Gecko) MAG200 stbapp ver: 2 rev: 250 Safari/533.3");
        httpConn.setRequestProperty("X-User-Agent", "Model: MAG250; Link: WiFi");
        httpConn.setRequestProperty("Referer", "http://tv.tvzon.tv/stalker_portal/c/");
        httpConn.setRequestProperty("Cookie", "mac=00:1A:79:BC:CE:6B; stb_lang=en; timezone=GMT");
        httpConn.setRequestProperty("Authorization", Bearear);
        httpConn.setRequestProperty("Accept", "/");
        httpConn.setRequestProperty("Host", "tv.tvzon.tv");
        httpConn.setRequestProperty("Connection", "Keep-Alive");
        httpConn.setRequestProperty("Accept-Encoding", "gzip");

        InputStream responseStream1 = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        if ("gzip".equals(httpConn.getContentEncoding())) {
            responseStream1 = new GZIPInputStream(responseStream1);
        }
        Scanner s1 = new Scanner(responseStream1).useDelimiter("\\A");
        String response1 = s1.hasNext() ? s1.next() : "";
        System.out.println(response1);

        URL url2 = new URL("http://tv.tvzon.tv/stalker_portal/server/load.php?type=itv&action=create_link&cmd=ffrt%20http%3A%2F%2Flocalhost%2Fch%2F7650&JsHttpRequest=1-xml");
        HttpURLConnection httpConn2 = (HttpURLConnection) url2.openConnection();
        httpConn2.setRequestProperty("X-User-Agent", "Model: MAG250; Link: WiFi");
        httpConn2.setRequestProperty("Referer", "http://tv.tvzon.tv/stalker_portal/c/");
        httpConn2.setRequestProperty("Cookie", "mac=00:1A:79:BC:CE:6B; stb_lang=en; timezone=GMT");
        httpConn2.setRequestProperty("Authorization", Bearear);
        httpConn2.setRequestProperty("Accept", "/");
        httpConn2.setRequestProperty("Host", "tv.tvzon.tv");
        httpConn2.setRequestProperty("Connection", "Keep-Alive");
        httpConn2.setRequestProperty("Accept-Encoding", "gzip");
        InputStream responseStream2 = httpConn2.getResponseCode() / 100 == 2
                ? httpConn2.getInputStream()
                : httpConn2.getErrorStream();
        if ("gzip".equals(httpConn2.getContentEncoding())) {
            responseStream2 = new GZIPInputStream(responseStream2);
        }
        Scanner s2 = new Scanner(responseStream2).useDelimiter("\\A");
        String response = s2.hasNext() ? s2.next() : "";
        System.out.println(response);
        JSONObject obj=new JSONObject(response);
        JSONObject temp= (JSONObject) obj.get("js");
         videourl=(String) temp.get("cmd");
        System.out.println(videourl);

    }

}
