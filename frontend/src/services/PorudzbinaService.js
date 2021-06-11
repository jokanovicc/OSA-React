import TavernaAxiosClient from "./clients/TavernaAxiosClient";


export const PorudzbinaService={
    getNedostavljene,
    stiglaPorudzbina,
    nekomentarisanePorudzbine,
    postKomentar
}


async function getNedostavljene(){
    return await TavernaAxiosClient.get("http://localhost:8080/porudzbine/find-neprispele");
}

async function stiglaPorudzbina(id){
    return await TavernaAxiosClient.post(`http://localhost:8080/porudzbine/oznaci/${id}`);
}

async function nekomentarisanePorudzbine(){
    return await TavernaAxiosClient.get("http://localhost:8080/porudzbine/dostavljene-nekomentarisane");
}

async function postKomentar(){
    return await TavernaAxiosClient.put("http://localhost:8080/porudzbine/dodaj-komentar");
}