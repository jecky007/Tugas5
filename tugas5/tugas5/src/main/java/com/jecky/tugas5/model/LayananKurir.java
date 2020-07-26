package com.jecky.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "layanankurir")
public class LayananKurir {

    @Id
    private String id;
    private String nama;
    private String harga;
    private String id_kurir;
    private String estimasi;

    public LayananKurir() {
    }

    @Override
    public String toString() {
        return "LayananKurir{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", harga='" + harga + '\'' +
                ", id_kurir='" + id_kurir + '\'' +
                ", estimasi='" + estimasi + '\'' +
                '}';
    }

    public LayananKurir(String id, String nama, String harga, String id_kurir, String estimasi) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.id_kurir = id_kurir;
        this.estimasi = estimasi;
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

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getId_kurir() {
        return id_kurir;
    }

    public void setId_kurir(String id_kurir) {
        this.id_kurir = id_kurir;
    }

    public String getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }
}
