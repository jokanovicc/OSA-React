import {useEffect, useState} from "react";
import {useHistory, useParams} from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
import {Container,Card,Button,Row, Col,CardDeck} from "react-bootstrap";
import {AuthenticationService} from "../../services/AuthenticationService";
import {Link} from "react-router-dom";
import Swal from "sweetalert2";

const ArtikliSvi=(props)=>{
    const[artikli, setArtikli] = useState([]);

    const {id} = useParams();

    useEffect(()=> {
        fetchArtikli();
    },[id])


    async function fetchArtikli(){
        try{
            console.log(props.match.params.id)
            const response = await ArtikliService.getArtikliByProdavac(props.match.params.id)
            setArtikli(response.data);
            console.log(artikli);
        }catch (error){
            console.error(`Greška prilikom dobavljanja artikala: ${error}`);
        }
    }

    async function korpu() {
        Swal.fire({
            title: 'Корпа!',
            text: 'Артикал стављен у корпу!',
            imageUrl: 'https://www.wallpapertip.com/wmimgs/53-536275_running-shopping-cart-in-supermarket.jpg',
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: 'Custom image',
        })


    }



    const renderCard = (artikal, id) => {
        return (
            <Card className={"kartice"} style={{ width: "18rem", textAlign:"center" }} key={id} >
                <Card.Img className="slikaProizvoda" variant="top" src={artikal.putanjaDoSlike} />
                <Card.Body>
                    <Card.Title><h5><a href={/artikal/+ artikal.id}>{artikal.naziv}</a></h5></Card.Title>
                    <Card.Text><h5>{artikal.cena}РСД</h5></Card.Text>
                    <Button onClick={() => korpu()}>Купи</Button>
                </Card.Body>
            </Card>
        );

    };

    return(
        <Container  className={"kontejner"}>
            <h1>Артикли продавца</h1>
            <hr/>
        <div>
    <div className="grid">{artikli.map(renderCard)}</div>
        </div>
        </Container>
);

};




export default ArtikliSvi;