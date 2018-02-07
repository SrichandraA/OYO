package chandu.oyo;

/**
 * Created by Chandu on 2/5/2018.
 */

public class Room {
    private int img_id;
    private int strike_price
            ,original_price
            ,offer
            ,no_of_ratings;
    private double rating_digit;
    private String hotel_name
            ,hotel_addr
            ,rating_comment;

    public Room(int img_id, int strike_price, int original_price, int offer, int no_of_ratings, double rating_digit, String hotel_name, String hotel_addr, String rating_comment) {
        this.img_id = img_id;
        this.strike_price = strike_price;
        this.original_price = original_price;
        this.offer = offer;
        this.no_of_ratings = no_of_ratings;
        this.rating_digit = rating_digit;
        this.hotel_name = hotel_name;
        this.hotel_addr = hotel_addr;
        this.rating_comment = rating_comment;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public int getStrike_price() {
        return strike_price;
    }

    public void setStrike_price(int strike_price) {
        this.strike_price = strike_price;
    }

    public int getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public int getNo_of_ratings() {
        return no_of_ratings;
    }

    public void setNo_of_ratings(int no_of_ratings) {
        this.no_of_ratings = no_of_ratings;
    }

    public double getRating_digit() {
        return rating_digit;
    }

    public void setRating_digit(double rating_digit) {
        this.rating_digit = rating_digit;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_addr() {
        return hotel_addr;
    }

    public void setHotel_addr(String hotel_addr) {
        this.hotel_addr = hotel_addr;
    }

    public String getRating_comment() {
        return rating_comment;
    }

    public void setRating_comment(String rating_comment) {
        this.rating_comment = rating_comment;
    }
}
