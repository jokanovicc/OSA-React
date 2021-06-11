import {useEffect, useState} from "react";
import {useParams} from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
import {Col, Container, Image, Row} from "react-bootstrap";
import ProdavacArtikli from "./ProdavacArtikli";


const Artikal=()=>{
    const[artikal,setArtikal] = useState({});



    const {id} = useParams();

    useEffect(()=>{
        fetchArtikal(id);
    },[id]);




    async function fetchArtikal(id){
        try {
            const response = await ArtikliService.getArtikal(id);
            setArtikal(response.data);
        } catch (error) {
            console.error(`Greška prilikom dobavljanja zadataka ${id}: ${error}`);
        }
    }

    return(

    <Container className={"kontejner"}>

        <Row>
            <Col>
            <Image style={{height:"350px",width:"450px"}} src={artikal.putanjaDoSlike} alt={"slika"}/>
            </Col>
            <Col>
            <h2>{artikal.naziv}</h2>
            <hr/>
                <p style={{fontSize:"20px" ,marginBottom:"30px"}}>Опис: {artikal.opis}</p>

                <h3>Цена: {artikal.cena} RSD</h3>
            </Col>
        </Row>







    </Container>


    );


}
export default Artikal;