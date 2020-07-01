package model;

/**
 *
 * @author ferysoe
 */
public class siswa{
    
    private int NIS = 0;
    private String nama_siswa;
    private int kelas;
    private String jenis_kelamin;
    private daftar regis;
    
    public siswa(){
        
    }
    
    public void insertSiswa(int nis, String nama, int kls, String jenkel){
        this.NIS = nis;
        this.nama_siswa = nama;
        this.kelas = kls;
        this.jenis_kelamin = jenkel;
    }
    
    public daftar getRegis() {
        return regis;
    }

    public void setRegis(daftar regis) {
        this.regis = regis;
    }
    
    public int getNIS(){
        return NIS;
    }
    
    public String getNama(){
        return nama_siswa;
    }
    
    public int getKelas(){
        return kelas;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setNIS(int NIS) {
        this.NIS = NIS;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setKelas(int kelas) {
        this.kelas = kelas;
    }  

    public void setNIS(hasil_studi hs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
