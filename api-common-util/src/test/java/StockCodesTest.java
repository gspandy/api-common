import com.zj.api.common.util.http.HttpRequest;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by js on 2017/1/22.
 */
public class StockCodesTest {


    public static void main(String[] agrs) {
        try {
            File file = new File("E:/stockCodes.txt");
            String result = HttpRequest.doGet("http://quote.eastmoney.com/stocklist.html");
            //正则表达式
            Pattern p = Pattern.compile("http://quote.eastmoney.com/\\w{2}\\d{6}");
            Matcher m = p.matcher(result);//进行匹配
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                String stockCode = m.group();
                String code = stockCode.substring(stockCode.indexOf(".com/") + 5);
                sb.append(code + ",");
            }
            Writer writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
