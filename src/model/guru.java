package model;

import view.mapel;

/**
 *
 * @author ferysoe
 */
public class guru extends manusia{
    private int NIP = 0;
    private int indexNip = 0;
    private String username;
    private String password;
    
    public guru(){
        
    }
    
    public void insertGuru(int nip, String nama_guru, String mapel, String noTelp){
    this.NIP = nip;
    this.nama = nama_guru;
    this.mapel = mapel;
    this.noTelp = noTelp;

    }

    public int getNIP() {
        return NIP;
    }

    public String getNama_guru() {
        return nama;
    }
    
    public String getMapel(){
        return mapel;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }

    public void setNama_guru(String nama) {
        this.nama = nama;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public int getIndexNip() {
        return indexNip;
    }

    public void setIndexNip(int indexNip) {
        this.indexNip = indexNip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
}
