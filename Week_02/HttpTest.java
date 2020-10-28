import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpRequest;

import java.util.stream.IntStream;

/**
 * @author deepin
 */
public class HttpTest {
    public static void main(String[] args) {
        int  loopNum = 100;
        final String url = "http://localhost:8088/api/hello";
        IntStream.range(0,loopNum).forEach(i->{
            String responseStr = HttpRequest.get(url).executeAsync().body();
            Console.log("request id: {}, result: {}",i+1,responseStr);
        });
    }
}
