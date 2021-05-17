import TavernaAxiosClient from "./clients/TavernaAxiosClient";


export const PorudzbinaService={
    getNedostavljene,
    stiglaPorudzbina
}


async function getNedostavljene(){
    return await TavernaAxiosClient.get("http://localhost:8080/porudzbine/find-neprispele");
}

async function stiglaPorudzbina(id){
    return await TavernaAxiosClient.post(`http://localhost:8080/porudzbine/oznaci/${id}`);
}