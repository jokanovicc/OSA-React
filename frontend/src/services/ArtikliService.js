import TavernaAxiosClient from "./clients/TavernaAxiosClient";

export const ArtikliService = {
    getArtikli,
    getProdavci,
    getArtikal,
    addArtikal,
    editArtikal,
    deleteArtikal,
    getArtikliByProdavac,
    getArtikliProdavca
}

async function getProdavci() {
    return await TavernaAxiosClient.get("http://localhost:8080/korisnici/lista-prodavaca");
}

async function getArtikliProdavca() {
    return await TavernaAxiosClient.get("http://localhost:8080/artikli/artikli-prodavac");
}


async function getArtikli() {
    await TavernaAxiosClient.get("http://localhost:8080/artikli");
}

async function getArtikliByProdavac(id) {
    return await TavernaAxiosClient.get(`http://localhost:8080/korisnici/lista-prodavaca/${id}/lista-artikala`);
}

async function getArtikal(id){
    return await TavernaAxiosClient.get(`http://localhost:8080/artikli/${id}`)
}

async function addArtikal(artikal){
    await TavernaAxiosClient.post("http://localhost:8080/artikli",artikal);
    return window.location.assign("/moji-artikli");
}

async function editArtikal(id, artikal){
    return await TavernaAxiosClient.put(`http://localhost:8080/artikli/${id}`, artikal);
}

async function deleteArtikal(id){
    return await TavernaAxiosClient.delete(`http://localhost:8080/artikli/${id}`);
}