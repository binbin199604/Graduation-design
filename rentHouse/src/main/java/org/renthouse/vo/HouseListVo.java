package org.renthouse.vo;

public class HouseListVo {
    private Integer houseId;
    private Integer userId;
    private Integer publishId;
    private String title;
    private int room;
    private int hall;
    private int floor;
    private int topFloor;
    private int square;
    private String userName;
    private String community;
    private String district;
    private String street;
    private String rentWay;
    private String location;
    private String subwayNumber;
    private double rent;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(int topFloor) {
        this.topFloor = topFloor;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRentWay() {
        return rentWay;
    }

    public void setRentWay(String rentWay) {
        this.rentWay = rentWay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubwayNumber() {
        return subwayNumber;
    }

    public void setSubwayNumber(String subwayNumber) {
        this.subwayNumber = subwayNumber;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "HouseListVo{" +
                "houseId=" + houseId +
                ", userId=" + userId +
                ", publishId=" + publishId +
                ", title='" + title + '\'' +
                ", room=" + room +
                ", hall=" + hall +
                ", floor=" + floor +
                ", topFloor=" + topFloor +
                ", square=" + square +
                ", userName='" + userName + '\'' +
                ", community='" + community + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", rentWay='" + rentWay + '\'' +
                ", location='" + location + '\'' +
                ", subwayNumber='" + subwayNumber + '\'' +
                ", rent=" + rent +
                '}';
    }
}
