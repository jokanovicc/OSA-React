insert into kupac(blokiran, ime, korisnicko, prezime, sifra,adresa) values (false, 'Petar', 'petarp','Petrovic','123','Perlez');
insert into kupac(blokiran, ime, korisnicko, prezime, sifra,adresa) values (false, 'Jovan', 'jovanj','Jovanovic','123','Cantavir');

insert into prodavac(blokiran, ime, korisnicko, prezime, sifra,adresa,posluje_od,imejl, naziv) values (false, 'Mitar', ',mitar','Mitrevic','1234','Srpski Itebej','1989-10-10','mitar@gmail','Itebejski vuci');
insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_id) values (2000,'Punjena vesalica','Ukusna','htpdgfdsfdg',1);
insert into artikal(cena,naziv,opis,putanja_do_slike,prodavac_id) values (2400,'Punjene paprike','Socna','htpdgfdsfdg',1);

insert into porudzbina(anoniman_komentar,arhiviran_komentar,dostavljeno,komentar,ocena,satnica,kupac_id) values (FALSE,FALSE,TRUE,'Odlicna prodavnica',5,'2021-05-01',1);