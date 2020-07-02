username : Ferysoe_06997
password : fery

SQL> create tablespace sisteminformasiLBB
  2  datafile 'D:\Data Kuliah\Basis Data\Praktikum\sistem_informasi_LBB.dbf'
  3  size 30M;

SQL> create user Ferysoe_06997
  2  identified by fery
  3  default tablespace sisteminformasiLBB
  4  quota 30M on sisteminformasiLBB;

SQL> grant all privileges to Ferysoe_06997;
SQL> conn Ferysoe_06997/fery
SQL> create table guru_06997
  2  (
  3  NIP INTEGER not null,
  4  Nama_guru VARCHAR2(25),
  5  Mapel VARCHAR2(25),
  6  No_telp NUMBER(15),
  7  constraint PK_guru primary key (NIP)
  8  );
SQL> create table siswa_06997
  2  (
  3  NIS INTEGER not null,
  4  Nama_siswa VARCHAR2(25),
  5  Kelas NUMBER(2),
  6  Jenis_kelamin VARCHAR2(15),
  7  constraint PK_siswa primary key (NIS)
  8  );
SQL> create table mapel_06997
  2  (
  3  kode_mapel INTEGER not null,
  4  Nama_mapel VARCHAR(25),
  5  Kelas_mapel NUMBER(2),
  6  constraint PK_mapel primary key (kode_mapel)
  7  );
SQL> create table jadwal_06997
  2  (
  3  kode_jadwal INTEGER not null,
  4  kode_mapel INTEGER,
  5  NIP INTEGER,
  6  jadwal DATE,
  7  constraint PK_jadwal primary key (kode_jadwal)
  8  );
SQL> alter table jadwal_06997
  2  add constraint FK_kode_mapel FOREIGN KEY (kode_mapel)
  3  references mapel_06997 (kode_mapel)
  4  add constraint FK_NIP FOREIGN KEY (NIP)
  5  references guru_06997 (NIP)
  6  ;
SQL> create table hasil_studi_06997
  2  (
  3  NIS INTEGER not null,
  4  Nama_siswa VARCHAR2(25),
  5  Nilai NUMBER(3),
  6  kode_jadwal INTEGER
  7  );
SQL> alter table hasil_studi_06997
  2  add constraint FK_NIS FOREIGN KEY (NIS)
  3  references siswa_06997 (NIS)
  4  add constraint FK_kode_jadwal FOREIGN KEY (kode_jadwal)
  5  references jadwal_06997 (kode_jadwal);
SQL> create sequence NIP
  2  minvalue 1111
  3  maxvalue 9999
  4  start with 1111
  5  increment by 1
  6  cache 20;
SQL> select a.nama_siswa_06997, b.NAS
 2 FROM siswa_06997 a JOIN
 3 hasil_studi_06997 b
 4 ON a.NIS = b.NIS
 5 where rownum <=5;
 SQL> create view list_mapel as
 2 select * from mapel_06997;