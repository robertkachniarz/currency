package pl.currenda.model;

public class Currency {
    private String code;
    private String date;
    private double bid;
    private double ask;

    public Currency(String code, String date, double bid, double ask) {
        this.code = code;
        this.date = date;
        this.bid = bid;
        this.ask = ask;
    }

    public Currency() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
