import TavernaAxiosClient from "./clients/TavernaAxiosClient";


export const RegistracijaService={
    RegistracijaKupac,
    isKupacValid,
    RegistracijaProdavac,
    getMyInfo,
    editKorisnik,
    resetSifra,
    getSifra,
    blokirajKorisnika,
    getSvi,

};


function isKupacValid(kupac) {
    return (
        kupac.ime !== "" &&
        kupac.prezime !== "" &&
        kupac.adresa !== "" &&
        kupac.username !== "" &&
        kupac.password !== ""
    );
}

async function getSvi(){
    return TavernaAxiosClient.get("http://localhost:8080/korisnici/lista-korisnika");
}


async function blokirajKorisnika(id){
    return TavernaAxiosClient.put(`http://localhost:8080/korisnici/blokiranje/${id}`);

}


async function RegistracijaKupac(kupac) {
    await TavernaAxiosClient.post("http://localhost:8080/users/registracija-kupac", kupac);
    return window.location.assign("/login");

}

async function getMyInfo() {
    return await TavernaAxiosClient.get("http://localhost:8080/korisnici/my-info");

}

async function getSifra() {
    return await TavernaAxiosClient.get("http://localhost:8080/korisnici/nadji-moju-sifru");
}

async function editKorisnik(korisnik){
    return await TavernaAxiosClient.put("http://localhost:8080/korisnici/izmeni-korisnika",korisnik);

}

async function resetSifra(sifra){
    return await TavernaAxiosClient.put("http://localhost:8080/korisnici/izmeni-sifru",sifra);

}

async function RegistracijaProdavac(prodavac) {
    await TavernaAxiosClient.post("http://localhost:8080/users/registracija-prodavac", prodavac);
    return window.location.assign("/login");

}