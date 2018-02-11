package org.renthouse.vo;

/**
 * <dl>
 * <dt>HouseSearchVo</dt>
 * <dd>Description:</dd>
 * <dd>Company: 华软-毕业设计</dd>
 * <dd>CreateDate: 2018/1/31</dd>
 * </dl>
 *
 * @author 梁浩斌
 */
public class HouseSearchVo {

    String district;
    Integer lowerRent;
    Integer upperRent;
    Integer room;
    String way;
    String type;
    String location;
    Integer elevator;
    String subway;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getLowerRent() {
        return lowerRent;
    }

    public void setLowerRent(Integer lowerRent) {
        this.lowerRent = lowerRent;
    }

    public Integer getUpperRent() {
        return upperRent;
    }

    public void setUpperRent(Integer upperRent) {
        this.upperRent = upperRent;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getElevator() {
        return elevator;
    }

    public void setElevator(Integer elevator) {
        this.elevator = elevator;
    }

    public String getSubway() {
        return subway;
    }

    public void setSubway(String subway) {
        this.subway = subway;
    }
}
