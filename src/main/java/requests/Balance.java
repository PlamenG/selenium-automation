package requests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;

import java.net.MalformedURLException;
import java.net.URL;

public class Balance {
    private final WebDriver driver;

    public Balance(WebDriver driver){
        this.driver = driver;
    }

    public String getMemberBalance() throws MalformedURLException {
        URL getMemberBalanceUrl = new URL("https://luckybandit.club.test-delasport.com/en/euro/operation/getMemberBalance");
        HttpRequest request = new HttpRequest(HttpMethod.POST,"https://luckybandit.club.test-delasport.com/en/euro/operation/getMemberBalance");

        StringBuilder cookies = new StringBuilder();
        for(Cookie entry : driver.manage().getCookies()){
            var val = entry.getName() + "=" + entry.getValue() + "; ";
            cookies.append(val) ;
        }

//        String cookies =  driver.manage().getCookies().toString().replace("[", "").replace("]", "");
        request.setHeader("Host", "luckybandit.club.test-delasport.com");
        request.setHeader("Cookie", cookies.toString());
        request.setHeader("Host", "luckybandit.club.test-delasport.com");
        request.setHeader("Accept-Encoding", "");
        request.setHeader("Host", "gzip, deflate, br, zstd");
        request.setHeader("Origin", "https://luckybandit.club.test-delasport.com");
        request.setHeader("DNT", "1");
        request.setHeader("Connection", "keep-alive");
        request.setHeader("Referer", "https://luckybandit.club.test-delasport.com/en/sports");
        request.setHeader("Sec-Fetch-Dest", "empty");
        request.setHeader("Sec-Fetch-Mode", "cors");
        request.setHeader("Sec-Fetch-Site", "same-origin");
        request.setHeader("Sec-GPC", "1");
        request.setHeader("Sec-Ch-Ua", "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"");
        request.setHeader("Sec-ch-Ua-Mobile", "?0");
        request.setHeader("Sec-Fetch-Des", "empty");
        request.setHeader("Content-Length", "0");
        request.setHeader("TE", "trailers");
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36");
        request.setHeader("Accept", "application/json, text/plain, */*");
        request.setHeader("Accept-Language", "en-US,en;q=0.5");
        request.setHeader("X-Requested-With", "XMLHttpRequest");


        HttpClient client = HttpClient.Factory.createDefault().createClient(getMemberBalanceUrl);
        HttpResponse response = client.execute(request);
        return  response.getContent().toString();
    }

}
