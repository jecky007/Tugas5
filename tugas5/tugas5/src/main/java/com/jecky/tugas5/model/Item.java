package com.jecky.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item")
public class Item {
    @Id
    private String id;
    private String nama;
    private String stock;
    private String harga;
    private String description;
    private String terjual;
    private String berat;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", stock='" + stock + '\'' +
                ", harga='" + harga + '\'' +
                ", description='" + description + '\'' +
                ", terjual='" + terjual + '\'' +
                ", berat='" + berat + '\'' +
                '}';
    }

    public Item(String id, String nama, String stock, String harga, String description, String terjual, String berat) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
        this.harga = harga;
        this.description = description;
        this.terjual = terjual;
        this.berat = berat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerjual() {
        return terjual;
    }

    public void setTerjual(String terjual) {
        this.terjual = terjual;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }
}
