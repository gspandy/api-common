package com.zj.api.common.util.quote.impl;

import com.zj.api.common.util.http.HttpRequest;
import com.zj.api.common.util.quote.QuoteUtil;
import com.zj.api.model.stock.QuoteInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by js on 2017/1/16.
 */

public class SinaQuoteUtilImpl implements QuoteUtil {

    private final static Logger logger = LoggerFactory.getLogger(SinaQuoteUtilImpl.class);

    private String sinaQuoteUrl;


    public String getSinaQuoteUrl() {
        return sinaQuoteUrl;
    }

    public void setSinaQuoteUrl(String sinaQuoteUrl) {
        this.sinaQuoteUrl = sinaQuoteUrl;
    }


    public QuoteInfo getStockQuote(String stockCode) {
        try {
            QuoteInfo quoteInfo = null;
            String result = HttpRequest.doGet(sinaQuoteUrl.replace("stockCodes", stockCode));
            if (StringUtils.hasText(result)) {
                quoteInfo = analysisResult(result);
            }
            return quoteInfo;
        } catch (IOException e) {
            logger.error("新浪行情获取失败,e:{}", e);
        }
        return null;
    }

    public Map<String, QuoteInfo> getStocksQuote(String stockCodes) {
        Map<String, QuoteInfo> quoteInfoMap = new HashMap<String, QuoteInfo>();
        try {
            String result = HttpRequest.doGet(sinaQuoteUrl.replace("stockCodes", stockCodes));
            if (StringUtils.hasText(result)) {
                resolveStr(quoteInfoMap, result);
            }
        } catch (IOException e) {
            logger.error("新浪行情批量获取失败,e:{}", e);
        }
        return quoteInfoMap;
    }

    /**
     * 解析字符
     *
     * @param quoteInfoMap
     * @param result
     */
    private void resolveStr(Map<String, QuoteInfo> quoteInfoMap, String result) {
        for (String str : result.split(";")) {
            QuoteInfo quoteInfo = analysisResult(str);
            quoteInfoMap.put(quoteInfo.getStockCode(), quoteInfo);
        }
    }

    private QuoteInfo analysisResult(String result) {
        QuoteInfo quoteInfo = new QuoteInfo();
        String str = result.replace("var hq_str_", "");
        quoteInfo.setStockCode(str.split("=")[0]);
        String infos[] = str.split("=")[1].split(",");
        if (infos.length <= 1) {
            quoteInfo.setStockName("");
            quoteInfo.setDealMoney(BigDecimal.ZERO);
            return quoteInfo;
        } else if (infos.length >= 33) {
            quoteInfo.setStockName(infos[0].substring(1));
            quoteInfo.setOpenPrice(Float.parseFloat(infos[1]));
            quoteInfo.setClosePrice(Float.parseFloat(infos[2]));
            quoteInfo.setCurrentPrice(Float.parseFloat(infos[3]));
            quoteInfo.setTopPrice(Float.parseFloat(infos[4]));
            quoteInfo.setLowerPrice(Float.parseFloat(infos[5]));
            quoteInfo.setBuyOne(Float.parseFloat(infos[6]));
            quoteInfo.setSellOne(Float.parseFloat(infos[7]));
            quoteInfo.setDealNumber(Integer.parseInt(infos[8]));
            quoteInfo.setDealMoney(new BigDecimal(infos[9]));
            quoteInfo.setBuyOneNumber(Integer.parseInt(infos[10]));
            quoteInfo.setBuyTwoNumber(Integer.parseInt(infos[12]));
            quoteInfo.setBuyTwo(Float.parseFloat(infos[13]));
            quoteInfo.setBuyThreeNumber(Integer.parseInt(infos[14]));
            quoteInfo.setBuyThree(Float.parseFloat(infos[15]));
            quoteInfo.setBuyFourNumber(Integer.parseInt(infos[16]));
            quoteInfo.setBuyFour(Float.parseFloat(infos[17]));
            quoteInfo.setBuyFiveNumber(Integer.parseInt(infos[18]));
            quoteInfo.setBuyFive(Float.parseFloat(infos[19]));
            quoteInfo.setSellOneNumber(Integer.parseInt(infos[20]));
            quoteInfo.setSellTwoNumber(Integer.parseInt(infos[22]));
            quoteInfo.setSellTwo(Float.parseFloat(infos[23]));
            quoteInfo.setSellThreeNumber(Integer.parseInt(infos[24]));
            quoteInfo.setSellThree(Float.parseFloat(infos[25]));
            quoteInfo.setSellFourNumber(Integer.parseInt(infos[26]));
            quoteInfo.setSellFour(Float.parseFloat(infos[27]));
            quoteInfo.setSellFiveNumber(Integer.parseInt(infos[28]));
            quoteInfo.setSellFive(Float.parseFloat(infos[29]));
        }
        return quoteInfo;
    }

}
