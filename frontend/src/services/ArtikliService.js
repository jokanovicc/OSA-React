import TavernaAxiosClient from "./clients/TavernaAxiosClient";

export const ArtikliService = {
    getArtikli,
    getProdavci,
    getArtikal,
    addArtikal,
    editArtikal,
    deleteArtikal,
    getArtikliByProdavac,
}

async function getProdavci() {
    return await TavernaAxiosClient.get("http://localhost:8080/korisnici/lista-prodavaca");
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
    return await TavernaAxiosClient.post("http://localhost:8080/artikli",artikal);
}

async function editArtikal(id, artikal){
    return await TavernaAxiosClient.put(`http://localhost:8080/artikli/${id}`, artikal);
}

async function deleteArtikal(id){
    return await TavernaAxiosClient.delete(`http://localhost:8080/artikli/${id}`);
}