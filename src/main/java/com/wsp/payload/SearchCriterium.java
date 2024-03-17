package com.wsp.payload;

public class SearchCriterium {
    private String origin;
    private String dest;
    private Boolean isOriginMetro;
    private Boolean isDestMetro;
    private String direction;
    private String date;
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getDest() {
        return dest;
    }
    public void setDest(String dest) {
        this.dest = dest;
    }


    public Boolean getIsOriginMetro() {
        return isOriginMetro;
    }
    public void setIsOriginMetro(Boolean isOriginMetro) {
        this.isOriginMetro = isOriginMetro;
    }
    public Boolean getIsDestMetro() {
        return isDestMetro;
    }
    public void setIsDestMetro(Boolean isDestMetro) {
        this.isDestMetro = isDestMetro;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
