package org.renthouse.pojo;

import java.util.Date;

public class House {
    private Integer id;

    private Integer userId;

    private String community;

    private String province;

    private String city;

    private String district;

    private String street;

    private Integer room;

    private Integer hall;

    private Integer toilet;

    private Integer square;

    private String decoration;

    private String location;

    private Integer floor;

    private Integer topFloor;

    private String houseNumber;

    private String houseType;

    private Integer isElevator;

    private String subwayNumber;

    private String propertyCosts;

    private String configuration;

    private String description;

    private String mainImage;

    private String subImages;

    private Date createTime;

    private Date updateTime;

    public House(Integer id, Integer userId, String community, String province, String city, String district, String street, Integer room, Integer hall, Integer toilet, Integer square, String decoration, String location, Integer floor, Integer topFloor, String houseNumber, String houseType, Integer isElevator, String subwayNumber, String propertyCosts, String configuration, String description, String mainImage, String subImages, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.community = community;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.room = room;
        this.hall = hall;
        this.toilet = toilet;
        this.square = square;
        this.decoration = decoration;
        this.location = location;
        this.floor = floor;
        this.topFloor = topFloor;
        this.houseNumber = houseNumber;
        this.houseType = houseType;
        this.isElevator = isElevator;
        this.subwayNumber = subwayNumber;
        this.propertyCosts = propertyCosts;
        this.configuration = configuration;
        this.description = description;
        this.mainImage = mainImage;
        this.subImages = subImages;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public House() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community == null ? null : community.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
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

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration == null ? null : decoration.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getTopFloor() {
        return topFloor;
    }

    public void setTopFloor(Integer topFloor) {
        this.topFloor = topFloor;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber == null ? null : houseNumber.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public Integer getIsElevator() {
        return isElevator;
    }

    public void setIsElevator(Integer isElevator) {
        this.isElevator = isElevator;
    }

    public String getSubwayNumber() {
        return subwayNumber;
    }

    public void setSubwayNumber(String subwayNumber) {
        this.subwayNumber = subwayNumber == null ? null : subwayNumber.trim();
    }

    public String getPropertyCosts() {
        return propertyCosts;
    }

    public void setPropertyCosts(String propertyCosts) {
        this.propertyCosts = propertyCosts == null ? null : propertyCosts.trim();
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration == null ? null : configuration.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages == null ? null : subImages.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}