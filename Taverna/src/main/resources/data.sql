
INSERT INTO KORISNIK(blokiran,ime,korisnicko,prezime,roles,sifra) VALUES (0,'Petar','petarp','Petrovic','KUPAC','$2y$12$ny/3y0yP6lQyOwCRajkWyud1gS6kLhk/BGsrMisU632Wy1OQhAaQG');
INSERT INTO KORISNIK(blokiran,ime,korisnicko,prezime,roles,sifra) VALUES (0,'Jovan','jovanj','Jovanovic','KUPAC','$2y$12$G0klgeSwrtNjUrk9LpaeX.1mj/m/emQ40fwIlwwUvHcTi7LaS7HiG ');

INSERT INTO KORISNIK(blokiran,ime,korisnicko,prezime,roles,sifra) VALUES (0,'Mitar','mitarm','Mitrovic','PRODAVAC','$2y$12$/jqXv7aS2QrAX22O4R1lE.A4kSED2MhT6g8MAtWbPbkw44jcAfJDm ');

INSERT INTO KUPAC(korisnik_id, adresa) VALUES (1, 'Mileticeva 21 Zrenjanin');
INSERT INTO KUPAC(korisnik_id, adresa) VALUES (2, 'Zarka Zrenjanina 42a Zrenjanin');

INSERT INTO PRODAVAC(korisnik_id, adresa,imejl, naziv, posluje_od) VALUES (3,'Bagljas','mitrovic@gmail.com','MITROVA KLOPA','1993-10-10');


 insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (2000,'Punjena vesalica','Ukusna','htpdgfdsfdg',3);
 insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_korisnik_id) values (2400,'Punjene paprike','Socna','htpdgfdsfdg',3);

 insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_korisnik_id) values (FALSE,FALSE,TRUE,'Odlicna prodavnica',5,'2021-05-01',1);
  insert into stavka(kolicina,artikal_id,porudzbina_id) values (10,1,1);

  insert into akcija(do_kad,od_kad,procenat,tekst,prodavac_korisnik_id) values ('2021-05-10','2021-07-10',20,'Majski popust',1);
  insert into artikli_akcije(akcija_id,artikal_id) values (1,1);