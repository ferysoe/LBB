/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import database.Koneksi;
import javax.swing.table.DefaultTableModel;
import model.daftar;
//import model.mapel;
import model.siswa;
//import model.siswa;
//import model.registrasi;

/**
 *
 * @author ferysoe
 */
public class Siswa_controller {
    public siswa[] siswa = new siswa[100];
    Koneksi koneksi = new Koneksi();
    int index=1;

    public void insertSiswa(String nama_siswa, int kelas, String jenis_kelamin) {
        siswa sis = new siswa();
        sis.insertSiswa(index, nama_siswa, kelas, jenis_kelamin);
        koneksi.ManipulasiData("INSERT INTO SISWA_06997 values ("+index+", '"+nama_siswa+"', " +kelas+ ", '"+jenis_kelamin+"', null)");
        System.out.println(index);
        siswa[index] = sis;
    }
    
    public void insert_regis(daftar reg){
        String x = "update siswa_06997 set no_reg = "+reg.getNo_reg()+" where NIS = "+index;
        System.out.println(x);
        koneksi.ManipulasiData(x);
        siswa[index].setRegis(reg);
        index++;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
 
    public siswa cari_siswa(int cari){
        siswa temp = null;
        int temp1;
        for(int i=1;i<index;i++){
            temp1=siswa[i].getNIS();
            if(temp1==cari){
                temp=siswa[i];
            }
        }
        return temp;
    }
    
    public siswa cari_siswa_daftar(int cari){
        siswa temp = null;
        int temp1;
        for(int i=1;i<index;i++){
            temp1=siswa[i].getNIS();
            if(temp1==cari){
                temp=siswa[i];
            }
        }
        return temp;
    }
    
    public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" NIS");
        model.addColumn(" Nama");
        model.addColumn(" Kelas");
        model.addColumn(" Jenis Kelamin");
       // model.addColumn(" No reg");
        
        for(int i=1 ;i<index;i++){
            Object data[] = new Object[4];
            data[0] = siswa[i].getNIS();
            data[1] = siswa[i].getNama();
            data[2] = siswa[i].getKelas();
            data[3] = siswa[i].getJenis_kelamin();
//            data[5] = siswa[i].getRegis().getNo_reg();
            model.addRow(data);
        }
        return model;
    }
}
