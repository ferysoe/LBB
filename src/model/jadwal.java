package model;
import controller.AllObject;
/**
 *
 * @author ferysoe
 */
public class jadwal{
    private mapel mapel;
    private guru guru;
    private hasil_studi[] hasil_studi;
    private int kode_jadwal = 0;
    private int kode_mapel =0;
    private int NIP = 0;
    private String jadwal;
    private int jumlah=0;

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }
    
    public jadwal(){
        
    }
    
    public void insertJadwal(int kode_jadwal, int kode_mapel, int nip, String jadwal){
        this.kode_jadwal = kode_jadwal;
        this.kode_mapel = kode_mapel;
        this.NIP = nip;
        this.jadwal = jadwal;
        
    }
    public mapel getMapel(){
        return mapel;
    }
    
    public void setMapel (mapel mapel){
        this.mapel=mapel;
    }
    
    public guru getGuru(){
        return guru;
    }
    
    public void setGuru (guru guru){
        this.guru=guru;
    }
    
    public hasil_studi[] getHasil_studi(){
        return hasil_studi;
    }
    
    public void setHasil_studi(hasil_studi[] hasil_studi){
        this.hasil_studi=hasil_studi;
    }

    public int getKode_jadwal() {
        return kode_jadwal;
    }
    
    public int getKode_mapel() {
        return kode_mapel;
    }
    
    public int getNIP() {
        return NIP;
    }
    
    public String getJadwal(){
        return jadwal;
    }

    public void setKode_jadwal(int kode_jadwal) {
        this.kode_jadwal = kode_jadwal;
    }
    
    public void setKode_mapel(int kode_mapel) {
        this.kode_mapel = kode_mapel;
    }

    public void setNIP(int nip) {
        this.NIP = nip;
    }
    
    public void setJadwal (String jadwal){
        this.jadwal = jadwal;
    }

}
