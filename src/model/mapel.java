package model;

/**
 *
 * @author ferysoe
 */
public class mapel {
    
    private int kode_mapel = 0;
    private String nama_mapel;
    private int kelas_mapel =0;
    
    public mapel(){
        
    }
    
    public void insertMapel(int kode_mapel, String nama_mapel, int kelas_mapel){
    this.kode_mapel = kode_mapel;
    this.nama_mapel = nama_mapel;
    this.kelas_mapel = kelas_mapel;
    }

    public int getKode_mapel() {
        return kode_mapel;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public int getKelas_mapel() {
        return kelas_mapel;
    }

    public void setKode_mapel(int kode_mapel) {
        this.kode_mapel = kode_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public void setKelas_mapel(int kelas_mapel) {
        this.kelas_mapel = kelas_mapel;
    }

    
}
