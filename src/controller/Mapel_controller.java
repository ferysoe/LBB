package controller;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.mapel;
/**
 *
 * @author ferysoe
 */
public class Mapel_controller {
     public mapel[] MP = new mapel[100];
     Koneksi koneksi = new Koneksi();
     int index = 1;
     int angka = 1;
     int kode_mapel;
     String nama_mapel;
     int kelas_mapel;
     
     public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void insert(String nama_mapel, int kelas_mapel){
        mapel mp = new mapel();
        System.out.println(kelas_mapel);
        mp.insertMapel(index, nama_mapel, kelas_mapel);
        String x="INSERT INTO MAPEL_06997 VALUES ("+index+",'"+nama_mapel+"', "+kelas_mapel+")";
        System.out.println(x);
        this.koneksi.ManipulasiData(x);
        MP[index] = mp;
        index++;
        
    }

    public mapel search(int cari){
        mapel temp = null;
        for(int x=1;x<index;x++){
            if(MP[x].getKode_mapel()==cari){
                temp = MP[x];
        }}  
        return temp;
    }
    
    public void delete(int cari){
        mapel temp=null;
        boolean ketemu=false;
        for(int i=1; i<index;i++){
                ketemu=true;
        }
        if(ketemu==true){
            String x="DELETE FROM MAPEL_06997 WHERE KODE_MAPEL = "+cari;
            koneksi.ManipulasiData(x);
            index--;
            ketemu=false;
            try {
                getDataMapel();
            } catch (SQLException ex) {
                Logger.getLogger(Mapel_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(int cari,int kode_mapel, String nama_mapel, int kelas_mapel){
        boolean ketemu=false;
        for(int x=1;x<index;x++){
            if(MP[x].getKode_mapel()==cari){
                MP[cari].setNama_mapel(nama_mapel);
                MP[cari].setKelas_mapel(kelas_mapel);
                ketemu=true;
    }}
         if (ketemu==true) {
            koneksi.ManipulasiData("update mapel_06997 set nama_mapel = '"+nama_mapel+"', kelas_mapel = "+kelas_mapel+" where kode_mapel = "+cari);
            ketemu=false;
        }
    }
    
    public  DefaultTableModel cetaktabel() throws SQLException{
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" Kode Mapel");
        model.addColumn(" Nama Mapel");
        model.addColumn(" Kelas Mapel");

        ResultSet rs = koneksi.GetData("select * from mapel_06997");
        while (rs.next()) {
            Object data[] = new Object[5];
            data[0] = rs.getInt("KODE_MAPEL");
            data[1] = rs.getString("NAMA_MAPEL");
            data[2] = rs.getInt("KELAS_MAPEL");
            model.addRow(data);
        }
        return model;
    }
    public void getDataMapel() throws SQLException{
        index=1;
        ResultSet rs = koneksi.GetData("select * from mapel_06997" );
        while (rs.next()) {
            mapel m = new mapel();
            m.setKode_mapel(rs.getInt("KODE_MAPEL"));
            m.setNama_mapel(rs.getString("NAMA_MAPEL"));
            m.setKelas_mapel(rs.getInt("KELAS_MAPEL"));
            MP[index]=m;
            index++;
            }
    }
    
}
