package com.cars365.SearchService.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "inventory")
public class Inventory {

    @Id
    private String id;


    private String vin;
    private boolean isUsedVehicle;
    private Model model;
    private Company company;
    private String[] images;
    private Accessories[] accessories;
    private Color intColor;
    private Color extColor;
    private Price price;

    //New Vehicle related fields



    //Used Vehicle related fields
    private String registrationNumber;
    private Date firstBuyOn;
    private Long runKms;

    private Date createdAt;
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public boolean isUsedVehicle() {
        return isUsedVehicle;
    }

    public void setUsedVehicle(boolean usedVehicle) {
        isUsedVehicle = usedVehicle;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Accessories[] getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories[] accessories) {
        this.accessories = accessories;
    }

    public Color getIntColor() {
        return intColor;
    }

    public void setIntColor(Color intColor) {
        this.intColor = intColor;
    }

    public Color getExtColor() {
        return extColor;
    }

    public void setExtColor(Color extColor) {
        this.extColor = extColor;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getFirstBuyOn() {
        return firstBuyOn;
    }

    public void setFirstBuyOn(Date firstBuyOn) {
        this.firstBuyOn = firstBuyOn;
    }

    public Long getRunKms() {
        return runKms;
    }

    public void setRunKms(Long runKms) {
        this.runKms = runKms;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
