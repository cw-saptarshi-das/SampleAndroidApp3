package com.example.sampleandroidapp.model;

import java.util.List;

public class CarDataRequest {
    String make;
    String modelName;
    String car;
    String segmentIds;     //divides models into various segments eg. luxury, superLuxury
    String city;
    String root;
    String filterbyadditional;     //Additional tags such as certification, etc
    boolean isAbsurePage;
    String fuel;
    String bodytype;
    String subSegmentID;
    String sessionId;           //Defines particular user session for specific user.
    String profileId;
    String seller;           //Individual or Dealer
    String owners;         // first owner, second owner, third owner
    String trans;         //Transmission
    String color;
    String kms;
    String year;
    String budget;
    String sc;                  //sort criteria
    String so;                   //sorting order
    String pn;                 //Page no.
    String ps;                 //Page size
    boolean bestmatch;
    int lcr;                       //last car rank
    int ldr;                   //last dealer rank      (not in use)
    int lir;                   //last individual rank (not in use)
    int nearbyCityId;
    String nearbyCityIds;
    String nearbyCityIdsStockCount;
    int userPreferredRootId;
    int stockFetched;
    String ExcludeStocks;
    int dealerId;
    List<String> deferredDealers;
    String price;
    String pc;
    List<String> additionalTags;
    List<String> specs;
    List<String> engineCapacity;
    List<String> seatingCapacity;
    List<String> maxPower;
    boolean isLuxury;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getSegmentIds() {
        return segmentIds;
    }

    public void setSegmentIds(String segmentIds) {
        this.segmentIds = segmentIds;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getFilterbyadditional() {
        return filterbyadditional;
    }

    public void setFilterbyadditional(String filterbyadditional) {
        this.filterbyadditional = filterbyadditional;
    }

    public boolean isAbsurePage() {
        return isAbsurePage;
    }

    public void setAbsurePage(boolean absurePage) {
        isAbsurePage = absurePage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getBodytype() {
        return bodytype;
    }

    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    public String getSubSegmentID() {
        return subSegmentID;
    }

    public void setSubSegmentID(String subSegmentID) {
        this.subSegmentID = subSegmentID;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKms() {
        return kms;
    }

    public void setKms(String kms) {
        this.kms = kms;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public boolean isBestmatch() {
        return bestmatch;
    }

    public void setBestmatch(boolean bestmatch) {
        this.bestmatch = bestmatch;
    }

    public int getLcr() {
        return lcr;
    }

    public void setLcr(int lcr) {
        this.lcr = lcr;
    }

    public int getLdr() {
        return ldr;
    }

    public void setLdr(int ldr) {
        this.ldr = ldr;
    }

    public int getLir() {
        return lir;
    }

    public void setLir(int lir) {
        this.lir = lir;
    }

    public int getNearbyCityId() {
        return nearbyCityId;
    }

    public void setNearbyCityId(int nearbyCityId) {
        this.nearbyCityId = nearbyCityId;
    }

    public String getNearbyCityIds() {
        return nearbyCityIds;
    }

    public void setNearbyCityIds(String nearbyCityIds) {
        this.nearbyCityIds = nearbyCityIds;
    }

    public String getNearbyCityIdsStockCount() {
        return nearbyCityIdsStockCount;
    }

    public void setNearbyCityIdsStockCount(String nearbyCityIdsStockCount) {
        this.nearbyCityIdsStockCount = nearbyCityIdsStockCount;
    }

    public int getUserPreferredRootId() {
        return userPreferredRootId;
    }

    public void setUserPreferredRootId(int userPreferredRootId) {
        this.userPreferredRootId = userPreferredRootId;
    }

    public int getStockFetched() {
        return stockFetched;
    }

    public void setStockFetched(int stockFetched) {
        this.stockFetched = stockFetched;
    }

    public String getExcludeStocks() {
        return ExcludeStocks;
    }

    public void setExcludeStocks(String excludeStocks) {
        ExcludeStocks = excludeStocks;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public List<String> getDeferredDealers() {
        return deferredDealers;
    }

    public void setDeferredDealers(List<String> deferredDealers) {
        this.deferredDealers = deferredDealers;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public List<String> getAdditionalTags() {
        return additionalTags;
    }

    public void setAdditionalTags(List<String> additionalTags) {
        this.additionalTags = additionalTags;
    }

    public List<String> getSpecs() {
        return specs;
    }

    public void setSpecs(List<String> specs) {
        this.specs = specs;
    }

    public List<String> getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(List<String> engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public List<String> getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(List<String> seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public List<String> getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(List<String> maxPower) {
        this.maxPower = maxPower;
    }

    public boolean isLuxury() {
        return isLuxury;
    }

    public void setLuxury(boolean luxury) {
        isLuxury = luxury;
    }
}
