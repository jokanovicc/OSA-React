
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Petar','petarp','Petrovic','KUPAC','$2y$12$q0a0rdDNZLex.BtQEsTC9u0hJ53cpdSRyhMtYwuiLknodOz.4pTxm');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Jovan','jovanj','Jovanovic','KUPAC','$2y$12$eGvcC/MRA.DQtuOrC5/u0uf3C50NzVxxSr0aHA80KEvlJcjGkrJou');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Mitar','mitarm','Mitrovic','PRODAVAC','$2y$12$EOcwqLiPNpuFTDxsKVWvC.GOZwbQXHw1iJKzLs6mFqEQZmKKlLEIS');
INSERT INTO KORISNIK(blokiran,ime,username,prezime,roles,password) VALUES (0,'Ado','adminat','Adminic','ADMIN','$2y$12$DjeqnDNrqxxv9RaSCgN6..bPRFR14xkTMWgjydGyTO2vV1OXrK3OW');



INSERT INTO KUPAC(korisnik_id, adresa) VALUES (1, 'Mileticeva 21 Zrenjanin');
INSERT INTO KUPAC(korisnik_id, adresa) VALUES (2, 'Zarka Zrenjanina 42a Zrenjanin');

INSERT INTO PRODAVAC(korisnik_id, adresa,imejl, naziv, posluje_od) VALUES (3,'Bagljas','mitrovic@gmail.com','MITROVA KLOPA','1993-10-10');


 insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (2000,'Punjena vesalica','Ukusna','https://domacirecepti.net/wp-content/uploads/2012/09/bela-ve%C5%A1alica.jpg',3);
 insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (2400,'Punjene paprike','Socna','https://podravkaiovariations.azureedge.net/c0220866-63c7-11eb-8190-0242ac12005d/v/f2b1f6a6-64bc-11eb-b6c2-0242ac130010/1024x768-f2b21802-64bc-11eb-a115-0242ac130010.webp',3);

 insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,TRUE,'Odlicna prodavnica',5,'2021-05-01',1);
  insert into stavka(kolicina,artikal_id,porudzbina_id) values (10,1,1);

  insert into akcija(do_kad,od_kad,procenat,tekst,prodavac_korisnik_id) values ('2021-05-10','2021-07-10',20,'Majski popust',3);
  insert into artikli_akcije(akcija_id,artikal_id) values (1,1);