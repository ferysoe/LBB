package controller;
import database.Koneksi;
import javax.swing.table.DefaultTableModel;
import model.guru;
/**
 *
 * @author ferysoe
 */
public class Guru_controller {
    public guru[] GUR = new guru[100];
    Koneksi koneksi = new Koneksi();
    int indexId = 1;
    int IDLogin =1;

    public int getIndexId() {
        return indexId;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }
    
    public void insertGuru(String nama_guru, String mapel, String no_telp) {
        guru gur = new guru();
        gur.insertGuru(indexId, nama_guru, mapel, no_telp);
        GUR[indexId] = gur;
        koneksi.ManipulasiData("INSERT INTO GURU_06997 VALUES ("+indexId+", '"+nama_guru+"', '" +mapel+ "', '"+no_telp+"')");
        indexId++;
    }

    public String login(String nama, String nip){
    String hasil = null;
        for(int i=1;i<indexId;i++){
            if(GUR[i].getUsername().equalsIgnoreCase(nama) && GUR[i].getPassword().equalsIgnoreCase(nip)){
            hasil = GUR[i].getMapel();
            IDLogin = GUR[i].getNIP();
            }
        }
    return hasil;
    }
    
    public guru search(int cari){
        guru temp = null;
        int temp1=0;
        for(int x=1;x<indexId;x++){
            temp1 = GUR[x].getNIP();
            if(temp1==cari){
            temp = GUR[x];
        }}  
        return temp;
    }
    
    public void delete(int cari){
        guru temp=null;
        boolean ketemu=false;
        for(int i=1; i<indexId;i++){
            if(GUR[i].getNIP()==cari){
                if(i<indexId){
                    GUR[i] = temp;
                    GUR[i+1] = GUR[i];
                    temp = GUR[i+1];
                }
                ketemu=true;
            }
        }
        if(ketemu==true){
            koneksi.ManipulasiData("DELETE FROM GURU_06997 WHERE NIP = "+cari);
            indexId--;
            ketemu = false;
        }
    }
    
    public void update(int cari,String nama, String mapel, String telp){
        for(int x=1;x<indexId;x++){
            if(GUR[x].getNIP()==cari){
                GUR[x].setNama_guru(nama);
                GUR[x].setMapel(mapel);
                GUR[x].setNoTelp(telp);
                koneksi.ManipulasiData("update guru_06997 set nama = '"+nama+"', mapel = '"+mapel+"', no_telp = '"+telp+"' where NIP = "+cari);
                }}
    }
    
     public DefaultTableModel viewTabel(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(" NIP");
        model.addColumn(" Nama");
        model.addColumn(" Mapel");
        model.addColumn(" No Telp");
        //model.addColumn(" Username");
        //model.addColumn(" Password");
        
        for(int i=1 ;i<indexId;i++){
            Object data[] = new Object[4];
            data[0] = GUR[i].getNIP();
            data[1] = GUR[i].getNama_guru();
            data[2] = GUR[i].getMapel();
            data[3] = GUR[i].getNoTelp();
            model.addRow(data);
        }
        return model;
    }

    public int getIDLogin() {
        return IDLogin;
    }
    
}
