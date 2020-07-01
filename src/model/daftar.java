package model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ferysoe
 */
public class daftar {
    private int no_reg;
    private String tgl;
    private guru guru;
    private siswa siswa;

    public void insert(int reg, guru gur, siswa sis){
        this.no_reg = reg;
        this.guru = gur;
        this.siswa = sis;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.tgl = df.format(date);
    }
    
    public int getNo_reg() {
        return no_reg;
    }

    public void setNo_reg(int no_reg) {
        this.no_reg = no_reg;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public guru getGuru() {
        return guru;
    }

    public void setGuru(guru guru) {
        this.guru = guru;
    }

    public siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(siswa siswa) {
        this.siswa = siswa;
    }
}
