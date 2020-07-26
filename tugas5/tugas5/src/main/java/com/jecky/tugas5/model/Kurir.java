package com.jecky.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kurir")
public class Kurir {
    @Id
    private String id;
    private String nama;
    private String resi;

    public Kurir() {
    }

    @Override
    public String toString() {
        return "Kurir{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", resi='" + resi + '\'' +
                '}';
    }

    public Kurir(String id, String nama, String resi) {
        this.id = id;
        this.nama = nama;
        this.resi = resi;
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

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }
}
