
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Petar','petarp','Petrovic','KUPAC','$2y$12$q0a0rdDNZLex.BtQEsTC9u0hJ53cpdSRyhMtYwuiLknodOz.4pTxm');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Jovan','jovanj','Jovanovic','KUPAC','$2y$12$eGvcC/MRA.DQtuOrC5/u0uf3C50NzVxxSr0aHA80KEvlJcjGkrJou');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Mitar','mitarm','Mitrovic','PRODAVAC','$2y$12$EOcwqLiPNpuFTDxsKVWvC.GOZwbQXHw1iJKzLs6mFqEQZmKKlLEIS');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Ado','adminat','Adminic','ADMIN','$2y$12$6gro0sJAgQW8CMBzv3Y3v.r.Y8RKMHMajPi.muoUPLIPPrY5US8gK
');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Jovan','jovanj','Jovanovic','PRODAVAC','$2y$12$EOcwqLiPNpuFTDxsKVWvC.GOZwbQXHw1iJKzLs6mFqEQZmKKlLEIS');




INSERT INTO KUPAC(korisnik_id, adresa) VALUES (1, 'Mileticeva 21 Zrenjanin');
INSERT INTO KUPAC(korisnik_id, adresa) VALUES (2, 'Zarka Zrenjanina 42a Zrenjanin');

INSERT INTO PRODAVAC(korisnik_id, adresa,imejl, naziv, posluje_od) VALUES (3,'Багњаш, Зрењанин','mitrovic@gmail.com','Клопа код Митра','1993-10-10');
INSERT INTO PRODAVAC(korisnik_id, adresa,imejl, naziv, posluje_od) VALUES (5,'Леснина, Зрењанин','jovanovic@gmail.com','Ресторан Галија','2020-10-10');


 insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (700,'Бела вешалица','Укусна и сочна од домаћег меса уз највеће порције у граду','https://www.rostiljubeogradu.rs/wp-content/uploads/2020/06/jela-sa-rostilja-bela-vesalica-restoran-zar-1-scaled.jpg',3);
 insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (500,'Пуњене паприке','Од паприка са наших њива, 500г, најнижа цена','https://podravkaiovariations.azureedge.net/c0220866-63c7-11eb-8190-0242ac12005d/v/f2b1f6a6-64bc-11eb-b6c2-0242ac130010/1024x768-f2b21802-64bc-11eb-a115-0242ac130010.webp',3);
insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (500,'Мусака','Недеља домаћих јела, искористите попуст','https://static.juznasrbija.info/files/musaka1.jpg',3);

insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (500,'Баклаве','Aliquam ullamcorper elit vitae nulla condimentum, quis pretium justo venenatis. Nunc accumsan metus et iaculis eleifend. Vivamus nec lorem felis.','https://mimiskingdom.com/wp-content/uploads/2020/11/baklava-22-of-23.jpg',5);
insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (600,'Пица каприћоза','liquam eu ex varius, sollicitudin sem sed, iaculis lacus. In fermentum hendrerit quam, non pharetra est commodo faucibus.','hhttps://stil.kurir.rs/data/images/2017/06/30/20/120607_pica_ls.jpg',5);



 insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,TRUE,'Odlicna prodavnica',5,'2021-05-01',1);

insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,TRUE,'Odlicna prodavnica',5,'2021-05-11',1);
insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,FALSE,'Odlicna prodavnica',5,'2021-05-12',1);
insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,FALSE,null,null,'2021-05-13',1);
insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,FALSE,null,null,'2021-05-10',1);
insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,FALSE,null,null,'2021-05-14',1);



  insert into stavka(kolicina,artikal_id,porudzbina_id) values (10,1,1);

  insert into akcija(do_kad,od_kad,procenat,tekst,prodavac_korisnik_id) values ('2021-05-10','2021-07-10',20,'Majski popust',3);
  insert into artikli_akcije(akcija_id,artikal_id) values (1,1);