package com.example.taxi_map;

public class Veri {

    private int ID;
    private int VendorID;
    private String tpep_pickup_datetime;
    private String tpep_dropoff_datetime;
    private int passenger_count;
    private float trip_distance;
    private int RatecodeID;
    private String store_and_fwd_flag;
    private int PULocationID;
    private int DOLocationID;
    private int payment_type;
    private int fare_amount;
    private float extra;
    private float mta_tax;
    private float tip_amount;
    private float tolls_amount;
    private float improvement_surcharge;
    private float total_amount;
    private float congestion_surcharge;

    public Veri() {
    }

    public Veri(int ID, int vendorID, String tpep_pickup_datetime, String tpep_dropoff_datetime,
                int passenger_count, float trip_distance, int ratecodeID, String store_and_fwd_flag,
                int PULocationID, int DOLocationID, int payment_type, int fare_amount, float extra,
                float mta_tax, float tip_amount, float tolls_amount, float improvement_surcharge,
                float total_amount, float congestion_surcharge) {
        this.ID = ID;
        VendorID = vendorID;
        this.tpep_pickup_datetime = tpep_pickup_datetime;
        this.tpep_dropoff_datetime = tpep_dropoff_datetime;
        this.passenger_count = passenger_count;
        this.trip_distance = trip_distance;
        RatecodeID = ratecodeID;
        this.store_and_fwd_flag = store_and_fwd_flag;
        this.PULocationID = PULocationID;
        this.DOLocationID = DOLocationID;
        this.payment_type = payment_type;
        this.fare_amount = fare_amount;
        this.extra = extra;
        this.mta_tax = mta_tax;
        this.tip_amount = tip_amount;
        this.tolls_amount = tolls_amount;
        this.improvement_surcharge = improvement_surcharge;
        this.total_amount = total_amount;
        this.congestion_surcharge = congestion_surcharge;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getVendorID() {
        return VendorID;
    }

    public void setVendorID(int vendorID) {
        VendorID = vendorID;
    }

    public String getTpep_pickup_datetime() {
        return tpep_pickup_datetime;
    }

    public void setTpep_pickup_datetime(String tpep_pickup_datetime) {
        this.tpep_pickup_datetime = tpep_pickup_datetime;
    }

    public String getTpep_dropoff_datetime() {
        return tpep_dropoff_datetime;
    }

    public void setTpep_dropoff_datetime(String tpep_dropoff_datetime) {
        this.tpep_dropoff_datetime = tpep_dropoff_datetime;
    }

    public int getPassenger_count() {
        return passenger_count;
    }

    public void setPassenger_count(int passenger_count) {
        this.passenger_count = passenger_count;
    }

    public float getTrip_distance() {
        return trip_distance;
    }

    public void setTrip_distance(float trip_distance) {
        this.trip_distance = trip_distance;
    }

    public int getRatecodeID() {
        return RatecodeID;
    }

    public void setRatecodeID(int ratecodeID) {
        RatecodeID = ratecodeID;
    }

    public String getStore_and_fwd_flag() {
        return store_and_fwd_flag;
    }

    public void setStore_and_fwd_flag(String store_and_fwd_flag) {
        this.store_and_fwd_flag = store_and_fwd_flag;
    }

    public int getPULocationID() {
        return PULocationID;
    }

    public void setPULocationID(int PULocationID) {
        this.PULocationID = PULocationID;
    }

    public int getDOLocationID() {
        return DOLocationID;
    }

    public void setDOLocationID(int DOLocationID) {
        this.DOLocationID = DOLocationID;
    }

    public int getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(int payment_type) {
        this.payment_type = payment_type;
    }

    public int getFare_amount() {
        return fare_amount;
    }

    public void setFare_amount(int fare_amount) {
        this.fare_amount = fare_amount;
    }

    public float getExtra() {
        return extra;
    }

    public void setExtra(float extra) {
        this.extra = extra;
    }

    public float getMta_tax() {
        return mta_tax;
    }

    public void setMta_tax(float mta_tax) {
        this.mta_tax = mta_tax;
    }

    public float getTip_amount() {
        return tip_amount;
    }

    public void setTip_amount(float tip_amount) {
        this.tip_amount = tip_amount;
    }

    public float getTolls_amount() {
        return tolls_amount;
    }

    public void setTolls_amount(float tolls_amount) {
        this.tolls_amount = tolls_amount;
    }

    public float getImprovement_surcharge() {
        return improvement_surcharge;
    }

    public void setImprovement_surcharge(float improvement_surcharge) {
        this.improvement_surcharge = improvement_surcharge;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getCongestion_surcharge() {
        return congestion_surcharge;
    }

    public void setCongestion_surcharge(float congestion_surcharge) {
        this.congestion_surcharge = congestion_surcharge;
    }
}
