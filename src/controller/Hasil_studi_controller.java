package controller;
import database.Koneksi;
import javax.swing.table.DefaultTableModel;
import model.*;
/**
 *
 * @author ferysoe
 */
public class Hasil_studi_controller {
    public hasil_studi hastud[] = new hasil_studi[100];
    public int index=0;
    Koneksi koneksi = new Koneksi();
    
    public void insert(int jdw, int sis, int nilai){
        hasil_studi hasil = new hasil_studi();
        hasil.insert(jdw, sis, nilai);
        hastud[index].setKode_jadwal(jdw);
        hastud[index].setNIS(sis);
        hastud[index].setNilai(nilai);
        
        index++;
    }

    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" Kode Jadwal");
        model.addColumn(" NIS");
        model.addColumn(" Nilai");
        //model.addColumn(" Tanggal");
        
        for(int i=1 ;i<index;i++){
            Object data[] = new Object[4];
            data[0] = hastud[i].getKode_jadwal();
            data[1] = hastud[i].getNIS();
            data[2] = hastud[i].getNilai();
            //data[3] = hastud[i].getTgl();
            model.addRow(data);
        }
        return model;
    }
    public hasil_studi[] getHastud() {
        index=1;
        return hastud;
    }

    public void setHastud(hasil_studi[] hastud) {
        this.hastud = hastud;
    }
   
}
