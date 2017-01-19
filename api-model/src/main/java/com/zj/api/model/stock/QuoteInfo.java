package com.zj.api.model.stock;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by ZJ on 2017/1/16.
 */
public class QuoteInfo implements Serializable {

    private static final long serialVersionUID = 1808168944380382196L;

    private String stockCode;

    private String stockName;

    private float openPrice;

    private float closePrice;

    private float currentPrice;

    private float topPrice;

    private float lowerPrice;

    private float buyOne;

    private int buyOneNumber;

    private float buyTwo;

    private int buyTwoNumber;

    private float buyThree;

    private int buyThreeNumber;

    private float buyFour;

    private int buyFourNumber;

    private float buyFive;

    private int buyFiveNumber;

    private float sellOne;

    private int sellOneNumber;

    private float sellTwo;

    private int sellTwoNumber;

    private float sellThree;

    private int sellThreeNumber;

    private float sellFour;

    private int sellFourNumber;

    private float sellFive;

    private int sellFiveNumber;

    private int DealNumber;

    private BigDecimal DealMoney;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public float getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(float closePrice) {
        this.closePrice = closePrice;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(float topPrice) {
        this.topPrice = topPrice;
    }

    public float getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(float lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    public float getBuyOne() {
        return buyOne;
    }

    public void setBuyOne(float buyOne) {
        this.buyOne = buyOne;
    }

    public int getBuyOneNumber() {
        return buyOneNumber;
    }

    public void setBuyOneNumber(int buyOneNumber) {
        this.buyOneNumber = buyOneNumber;
    }

    public float getBuyTwo() {
        return buyTwo;
    }

    public void setBuyTwo(float buyTwo) {
        this.buyTwo = buyTwo;
    }

    public int getBuyTwoNumber() {
        return buyTwoNumber;
    }

    public void setBuyTwoNumber(int buyTwoNumber) {
        this.buyTwoNumber = buyTwoNumber;
    }

    public float getBuyThree() {
        return buyThree;
    }

    public void setBuyThree(float buyThree) {
        this.buyThree = buyThree;
    }

    public int getBuyThreeNumber() {
        return buyThreeNumber;
    }

    public void setBuyThreeNumber(int buyThreeNumber) {
        this.buyThreeNumber = buyThreeNumber;
    }

    public float getBuyFour() {
        return buyFour;
    }

    public void setBuyFour(float buyFour) {
        this.buyFour = buyFour;
    }

    public int getBuyFourNumber() {
        return buyFourNumber;
    }

    public void setBuyFourNumber(int buyFourNumber) {
        this.buyFourNumber = buyFourNumber;
    }

    public float getBuyFive() {
        return buyFive;
    }

    public void setBuyFive(float buyFive) {
        this.buyFive = buyFive;
    }

    public int getBuyFiveNumber() {
        return buyFiveNumber;
    }

    public void setBuyFiveNumber(int buyFiveNumber) {
        this.buyFiveNumber = buyFiveNumber;
    }

    public float getSellOne() {
        return sellOne;
    }

    public void setSellOne(float sellOne) {
        this.sellOne = sellOne;
    }

    public int getSellOneNumber() {
        return sellOneNumber;
    }

    public void setSellOneNumber(int sellOneNumber) {
        this.sellOneNumber = sellOneNumber;
    }

    public float getSellTwo() {
        return sellTwo;
    }

    public void setSellTwo(float sellTwo) {
        this.sellTwo = sellTwo;
    }

    public int getSellTwoNumber() {
        return sellTwoNumber;
    }

    public void setSellTwoNumber(int sellTwoNumber) {
        this.sellTwoNumber = sellTwoNumber;
    }

    public float getSellThree() {
        return sellThree;
    }

    public void setSellThree(float sellThree) {
        this.sellThree = sellThree;
    }

    public int getSellThreeNumber() {
        return sellThreeNumber;
    }

    public void setSellThreeNumber(int sellThreeNumber) {
        this.sellThreeNumber = sellThreeNumber;
    }

    public float getSellFour() {
        return sellFour;
    }

    public void setSellFour(float sellFour) {
        this.sellFour = sellFour;
    }

    public int getSellFourNumber() {
        return sellFourNumber;
    }

    public void setSellFourNumber(int sellFourNumber) {
        this.sellFourNumber = sellFourNumber;
    }

    public float getSellFive() {
        return sellFive;
    }

    public void setSellFive(float sellFive) {
        this.sellFive = sellFive;
    }

    public int getSellFiveNumber() {
        return sellFiveNumber;
    }

    public void setSellFiveNumber(int sellFiveNumber) {
        this.sellFiveNumber = sellFiveNumber;
    }

    public int getDealNumber() {
        return DealNumber;
    }

    public void setDealNumber(int dealNumber) {
        DealNumber = dealNumber;
    }

    public BigDecimal getDealMoney() {
        return DealMoney;
    }

    public void setDealMoney(BigDecimal dealMoney) {
        DealMoney = dealMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuoteInfo quoteInfo = (QuoteInfo) o;

        if (Float.compare(quoteInfo.openPrice, openPrice) != 0) return false;
        if (Float.compare(quoteInfo.closePrice, closePrice) != 0) return false;
        if (Float.compare(quoteInfo.currentPrice, currentPrice) != 0) return false;
        if (Float.compare(quoteInfo.topPrice, topPrice) != 0) return false;
        if (Float.compare(quoteInfo.lowerPrice, lowerPrice) != 0) return false;
        if (Float.compare(quoteInfo.buyOne, buyOne) != 0) return false;
        if (buyOneNumber != quoteInfo.buyOneNumber) return false;
        if (Float.compare(quoteInfo.buyTwo, buyTwo) != 0) return false;
        if (buyTwoNumber != quoteInfo.buyTwoNumber) return false;
        if (Float.compare(quoteInfo.buyThree, buyThree) != 0) return false;
        if (buyThreeNumber != quoteInfo.buyThreeNumber) return false;
        if (Float.compare(quoteInfo.buyFour, buyFour) != 0) return false;
        if (buyFourNumber != quoteInfo.buyFourNumber) return false;
        if (Float.compare(quoteInfo.buyFive, buyFive) != 0) return false;
        if (buyFiveNumber != quoteInfo.buyFiveNumber) return false;
        if (Float.compare(quoteInfo.sellOne, sellOne) != 0) return false;
        if (sellOneNumber != quoteInfo.sellOneNumber) return false;
        if (Float.compare(quoteInfo.sellTwo, sellTwo) != 0) return false;
        if (sellTwoNumber != quoteInfo.sellTwoNumber) return false;
        if (Float.compare(quoteInfo.sellThree, sellThree) != 0) return false;
        if (sellThreeNumber != quoteInfo.sellThreeNumber) return false;
        if (Float.compare(quoteInfo.sellFour, sellFour) != 0) return false;
        if (sellFourNumber != quoteInfo.sellFourNumber) return false;
        if (Float.compare(quoteInfo.sellFive, sellFive) != 0) return false;
        if (sellFiveNumber != quoteInfo.sellFiveNumber) return false;
        if (DealNumber != quoteInfo.DealNumber) return false;
        if (stockCode != null ? !stockCode.equals(quoteInfo.stockCode) : quoteInfo.stockCode != null) return false;
        if (stockName != null ? !stockName.equals(quoteInfo.stockName) : quoteInfo.stockName != null) return false;
        return DealMoney != null ? DealMoney.equals(quoteInfo.DealMoney) : quoteInfo.DealMoney == null;

    }

    @Override
    public int hashCode() {
        int result = stockCode != null ? stockCode.hashCode() : 0;
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        result = 31 * result + (openPrice != +0.0f ? Float.floatToIntBits(openPrice) : 0);
        result = 31 * result + (closePrice != +0.0f ? Float.floatToIntBits(closePrice) : 0);
        result = 31 * result + (currentPrice != +0.0f ? Float.floatToIntBits(currentPrice) : 0);
        result = 31 * result + (topPrice != +0.0f ? Float.floatToIntBits(topPrice) : 0);
        result = 31 * result + (lowerPrice != +0.0f ? Float.floatToIntBits(lowerPrice) : 0);
        result = 31 * result + (buyOne != +0.0f ? Float.floatToIntBits(buyOne) : 0);
        result = 31 * result + buyOneNumber;
        result = 31 * result + (buyTwo != +0.0f ? Float.floatToIntBits(buyTwo) : 0);
        result = 31 * result + buyTwoNumber;
        result = 31 * result + (buyThree != +0.0f ? Float.floatToIntBits(buyThree) : 0);
        result = 31 * result + buyThreeNumber;
        result = 31 * result + (buyFour != +0.0f ? Float.floatToIntBits(buyFour) : 0);
        result = 31 * result + buyFourNumber;
        result = 31 * result + (buyFive != +0.0f ? Float.floatToIntBits(buyFive) : 0);
        result = 31 * result + buyFiveNumber;
        result = 31 * result + (sellOne != +0.0f ? Float.floatToIntBits(sellOne) : 0);
        result = 31 * result + sellOneNumber;
        result = 31 * result + (sellTwo != +0.0f ? Float.floatToIntBits(sellTwo) : 0);
        result = 31 * result + sellTwoNumber;
        result = 31 * result + (sellThree != +0.0f ? Float.floatToIntBits(sellThree) : 0);
        result = 31 * result + sellThreeNumber;
        result = 31 * result + (sellFour != +0.0f ? Float.floatToIntBits(sellFour) : 0);
        result = 31 * result + sellFourNumber;
        result = 31 * result + (sellFive != +0.0f ? Float.floatToIntBits(sellFive) : 0);
        result = 31 * result + sellFiveNumber;
        result = 31 * result + DealNumber;
        result = 31 * result + (DealMoney != null ? DealMoney.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QuoteInfo{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", openPrice=" + openPrice +
                ", closePrice=" + closePrice +
                ", currentPrice=" + currentPrice +
                ", topPrice=" + topPrice +
                ", lowerPrice=" + lowerPrice +
                ", buyOne=" + buyOne +
                ", buyOneNumber=" + buyOneNumber +
                ", buyTwo=" + buyTwo +
                ", buyTwoNumber=" + buyTwoNumber +
                ", buyThree=" + buyThree +
                ", buyThreeNumber=" + buyThreeNumber +
                ", buyFour=" + buyFour +
                ", buyFourNumber=" + buyFourNumber +
                ", buyFive=" + buyFive +
                ", buyFiveNumber=" + buyFiveNumber +
                ", sellOne=" + sellOne +
                ", sellOneNumber=" + sellOneNumber +
                ", sellTwo=" + sellTwo +
                ", sellTwoNumber=" + sellTwoNumber +
                ", sellThree=" + sellThree +
                ", sellThreeNumber=" + sellThreeNumber +
                ", sellFour=" + sellFour +
                ", sellFourNumber=" + sellFourNumber +
                ", sellFive=" + sellFive +
                ", sellFiveNumber=" + sellFiveNumber +
                ", DealNumber=" + DealNumber +
                ", DealMoney=" + DealMoney +
                '}';
    }
}
