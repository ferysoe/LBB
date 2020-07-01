/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import static controller.AllObject.siswa;
import model.*;
import database.Koneksi;
import java.sql.*;
import java.text.*;
/**
 *
 * @author ferysoe
 */
public class getData {
    Koneksi koneksi;
    SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
    Date tgl;
    public getData() throws SQLException{
    koneksi = new Koneksi();
    getDataMapel();
    getDataGuru();
    getDataJadwal();
    getDataSiswa();
    //getDataDaftar();
    }
    
    public void getDataMapel() throws SQLException{
        int index=1;
        ResultSet rs = koneksi.GetData("select * from mapel_06997" );
        while (rs.next()) {
            mapel m = new mapel();
            m.setKode_mapel(rs.getInt("KODE_MAPEL"));
            m.setNama_mapel(rs.getString("NAMA_MAPEL"));
            m.setKelas_mapel(rs.getInt("KELAS_MAPEL"));
            AllObject.mapel.MP[index]=m;
            index++;
            AllObject.mapel.setIndex(index);
            }
    }
    
    public void getDataGuru() throws SQLException {
        int index=1;
        ResultSet rs = koneksi.GetData("select * from guru_06997");
        while (rs.next()){
            guru g = new guru();
            g.setNIP(rs.getInt("NIP"));
            g.setNama_guru(rs.getString("NAMA_GURU"));
            g.setMapel(rs.getString("MAPEL"));
            g.setNoTelp(rs.getString("NO_TELP"));
            AllObject.guru.GUR[index]=g;
            index++;
            AllObject.guru.setIndexId(index);
        }
    }
    
    public void getDataSiswa() throws SQLException{
        int index=1;
        ResultSet rs = koneksi.GetData("select * from view_siswa");
        while (rs.next()){
            siswa s = new siswa();
            s.setNIS(rs.getInt("NIS"));
            s.setNama_siswa(rs.getString("NAMA_SISWA"));
            s.setKelas(rs.getInt("KELAS"));
            s.setJenis_kelamin(rs.getString("JENIS_KELAMIN"));
            System.out.println(s.getNama());
            AllObject.siswa.siswa[index]=s;
            index++;
            AllObject.siswa.setIndex(index);
        }
    }
    
    public void getDataJadwal() throws SQLException {
        int index=1;
        int x=1;
        ResultSet rs = koneksi.GetData("select * from jadwal_06997");
        while (rs.next()){
            jadwal j = new jadwal();
            j.setKode_jadwal(rs.getInt("KODE_JADWAL"));
            j.setMapel(AllObject.mapel.search(rs.getInt("KODE_MAPEL")));
            j.setGuru(AllObject.guru.search(rs.getInt("NIP")));
            j.setJadwal(rs.getString("JADWAL"));
            String g = "select * from siswa_06997 join hasil_studi_06997 on siswa_06997.NIS = hasil_studi_06997.NISN where hasil_studi_06997.kode_jadwal =" + j.getKode_jadwal();
            ResultSet rsD = koneksi.GetData(g);
            System.out.println(g);
            hasil_studi[] HS = new hasil_studi[100];
            siswa[] sis = new siswa[100];
            if(rsD.isLast()==false){
            while(rsD.next()){
                siswa s= new siswa();
                s.setNIS(rsD.getInt("NIS"));
                s.setNama_siswa(rsD.getString("NAMA_SISWA"));
                s.setKelas(rsD.getInt("KELAS"));
                s.setJenis_kelamin(rsD.getString("JENIS_KELAMIN"));
                
                hasil_studi hs = new hasil_studi();
                hs.setKode_jadwal(rsD.getInt("KODE_JADWAL"));
                hs.setSiswa(s);
                hs.setNilai(rsD.getInt("NAS"));
                
                /*siswa siswa = new siswa();
                siswa.setNIS(hs);
                tgl = rsD.getDate("JADWAL");
                hs.setJadwal(date.format(tgl));*/
               
                HS[x]=hs;
                x++;
                             }}
            //j.setNIP(x);
            //j.setNIS(sis);
            j.setJumlah(x);
            j.setHasil_studi(HS);
            x=1;
            AllObject.jadwal.JDW[index]=j;
                    index++;
            AllObject.jadwal.kode_jadwal=index;
        }
    }
    
    /*public void getDataDaftar() throws SQLException{
        int index=1;
        ResultSet rs = koneksi.GetData("SELECT * from view_regis");
        while(rs.next()){
            pegawai p = new pegawai();
            p.setIdPegawai(rs.getInt("ID_PEGAWAI"));
            p.setNama(rs.getString("NAMA_PEGAWAI"));
            p.setGender(rs.getString("GENDER_PEGAWAI"));
            p.setAlamat(rs.getString("ALAMAT_PEGAWAI"));
            p.setNoTelp(rs.getString("NO_TELP_PEGAWAI"));
            p.setJabatan(rs.getString("JABATAN"));
            p.setUsername(rs.getString("USERNAME"));
            p.setPassword(rs.getString("PASSWORD"));
            
            member m = new member();
            m.setIdMember(rs.getInt("ID_PEMBELI"));
            m.setNama(rs.getString("NAMA_PEMBELI"));
            m.setGender(rs.getString("GENDER_PEMBELI"));
            m.setAlamat(rs.getString("ALAMAT_PEMBELI"));
            m.setNoTelp(rs.getString("NO_TELP_PEMBELI"));

            registrasi r = new registrasi();
            r.setNo_reg(rs.getInt("NO_REGISTRASI"));
            r.setTgl(rs.getString("O6999_TANGGAL"));
            r.setPegawai(p);
            r.setMember(m);
            m.setRegis(r);
            r.getMember().setRegis(r);
            AllObject.member.member[index]=m;
            AllObject.regis.reg[index]=r;
            index++;
            AllObject.member.setIndex(index);
        }
    }*/
    
}
