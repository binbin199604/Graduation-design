package org.renthouse.vo;

public class HouseRecommendListVo {
    private Integer houseId;
    private Integer publishId;
    private String title;
    private Integer rent;
    private Integer room;
    private Integer hall;
    private String decoration;
    private String city;
    private String community;

    @Override
    public String toString() {
        return "HouseRecommendListVo{" +
                "houseId=" + houseId +
                ", publishId=" + publishId +
                ", title='" + title + '\'' +
                ", rent=" + rent +
                ", room=" + room +
                ", hall=" + hall +
                ", decoration='" + decoration + '\'' +
                ", city='" + city + '\'' +
                ", community='" + community + '\'' +
                '}';
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }
}
