insert into korisnik(blokiran, ime, korisnicko, prezime, sifra) values (false, 'Petar', 'petarp','Petrovic','123')
insert into korisnik(blokiran, ime, korisnicko, prezime, sifra) values (false, 'Jovan', 'jovanj','Jovanovic','12345')
insert into kupac(korisnik_id, adresa) values (1,'Perleska 21a Perlez')
insert into prodavac(korisnik_id,adresa,imejl,naziv,posluje_od) values (2,'Partizanska 23a Kumane', 'jovanovic@gmail.com','Kumane DOO','1989-10-10')