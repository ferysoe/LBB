package controller;
import database.Koneksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.*;
/**
 *
 * @author ferysoe
 */
public class Jadwal_controller {
    public jadwal[] JDW = new jadwal[100];
    Koneksi koneksi = new Koneksi();
    int kode_jadwal = 1;
    
    
    public void insertJadwal(int kode_jadwal, int kode_mapel, int nip, String jadwal) {
        jadwal jdw = new jadwal();
        jdw.insertJadwal(kode_jadwal, kode_mapel, nip, jadwal);
        String x = "insert into jadwal_06997 values ("+kode_jadwal+","+kode_mapel+","+nip+",'"+jadwal+"')";
        koneksi.ManipulasiData (x);
        this.koneksi.ManipulasiData(x);
        JDW[kode_jadwal] = jdw;
        kode_jadwal++;
    }
    
    public jadwal cari(int cari){
        jadwal temp = null;
        for(int x=1;x<kode_jadwal;x++){
            if(JDW[x].getKode_jadwal()==cari){
                temp = JDW[x];
            }
        }
        return temp;
    }
    
    public void delete(int cari){
        mapel temp=null;
        boolean ketemu=false;
        for(int i=1; i<kode_jadwal;i++){
                ketemu=true;
        }
        if(ketemu==true){
            String x="DELETE FROM JADWAL_06997 WHERE KODE_JADWAL = "+cari;
            koneksi.ManipulasiData(x);
            kode_jadwal--;
            ketemu=false;
            //getDataJadwal();
        }
    }
    
    public void update(int kode_jadwal,int kode_mapel, int nip, String jadwal){
        boolean ketemu=false;
        for(int x=1;x<kode_jadwal;x++){
            if(JDW[x].getKode_jadwal()==kode_jadwal){
                JDW[kode_jadwal].setKode_mapel(kode_mapel);
                JDW[kode_jadwal].setNIP(nip);
                JDW[kode_jadwal].setJadwal(jadwal);
                ketemu=true;
    }}
         if (ketemu==true) {
            koneksi.ManipulasiData("update jadwal_06997 set kode_mapel = "+kode_mapel+", nip = "+nip+", jadwal = "+jadwal+" where kode_mapel = "+kode_mapel);
            ketemu=false;
        }
    }
    
    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" Kode Jadwal");
        model.addColumn(" Kode Mapel");
        model.addColumn(" NIP");
        model.addColumn(" JADWAL");
        
        for(int i=1 ;i<kode_jadwal;i++){
            Object data[] = new Object[4];
            data[0] = JDW[i].getKode_jadwal();
            data[1] = JDW[i].getMapel().getKode_mapel();
            data[2] = JDW[i].getGuru().getNIP();
            data[3] = JDW[i].getJadwal();
            model.addRow(data);
        }
        return model;
    }
    public int getKode_jadwal(){
        return kode_jadwal;
    }
    public void setKode_jadwal(int kode_jadwal){
        this.kode_jadwal=kode_jadwal;
    }
    
    public String cetak_detail(int index){
        hasil_studi[] hs=JDW[index].getHasil_studi();
        System.out.println(JDW[index].getJumlah());
        String text = "================== Hasil Studi ===================\n";
        System.out.println(index);
        //siswa[] siswa = hastud[index].getKode_jadwal();
        //System.out.println(hs[1].getNIS());
        for (int i = 1; i < JDW[index].getJumlah(); i++) {
        text += "Nama           : " + hs[i].getSiswa().getNama() + "\n";
        text += "Nilai          : " + hs[i].getNilai() + "\n";
        text += "Kode Jadwal    : " + hs[i].getKode_jadwal() + "\n";
        text += "--------------------------------------------------- \n";
        }
        System.out.println(text);
        //text += "Nama          : " + sis[index].getMember().getNama() + "\n";
        //text += "Pegawai          : " + trs[index].getPegawai().getNama() + "\n";
        //text += "============= Detail ==============\n";
        /*for(int i=1;i<=hs[index].getNIS();i++){
        text += "NIS        : "+ hastud[i].getNIS() +"\n";
        text += "Nilai      : "+ hastud[i].getNilai()+"\n";
        text += "Kode Jadwal: "+ hastud[i].getKode_jadwal()+"\n";
        text += "--------------------------------"+"\n";*/
        //}
        /*text += "Total Harga     : "+trs[index].getTotal()+"\n";
        text += "Bayar           : "+trs[index].getBayar()+"\n";
        text += "Kembali         : "+trs[index].getKembali();*/
        return text;
    }
}
