/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ferysoe
 */
public class hasil_studi {
    private int index;
    private siswa siswa;
    private int kode_jadwal;
    private int nis;
    private int nilai;
    //private String tgl;
    
    public void insert(int kode_jadwal, int nis, int nilai){
        this.kode_jadwal = kode_jadwal;
        this.nis = nis;
        this.nilai = nilai;
    }
    public siswa getSiswa(){
        return siswa;
    }
    
    public void setSiswa (siswa siswa){
        this.siswa = siswa;
    }

    public int getKode_jadwal() {
        return kode_jadwal;
    }

    public void setKode_jadwal(int kode_jadwal) {
        this.kode_jadwal = kode_jadwal;
    }

    public int getNIS() {
        return nis;
    }

    public void setNIS(int nis) {
        this.nis = nis;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
    
    public int getIndex(){
        return index;
    }
    
    public void setIndex(int index){
        this.index=index;
    }

}
