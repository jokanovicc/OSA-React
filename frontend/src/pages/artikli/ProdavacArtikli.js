import {useEffect, useState} from "react";
import {useHistory, useParams} from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
import {Container,Card,Button,Row, Col,CardDeck} from "react-bootstrap";
import {AuthenticationService} from "../../services/AuthenticationService";
import {Link} from "react-router-dom";

const ProdavacArtikli=(props)=>{
    const[artikli, setArtikli] = useState([]);


    const {id} = useParams();

    useEffect(()=> {
        fetchArtikli();
    },[id])


    async function fetchArtikli(){
        try{
            console.log(props.match.params.id)
            const response = await ArtikliService.getArtikliProdavca();
            setArtikli(response.data);
            console.log(artikli);
        }catch (error){
            console.error(`Greška prilikom dobavljanja artikala: ${error}`);
        }
    }

    async function deleteArtikal(id) {
        try {
            await ArtikliService.deleteArtikal(id);

            // Za novu vrednost liste zadataka uzima se prethodna lista, filtrirana tako da ne sadrži obrisani zatak
            setArtikli((artikli) => artikli.filter((artikal) => artikal.id !== id));
        } catch (error) {
            console.error(`Greška prilikom brisanja artikla ${id}: ${error}`);
        }
    }



    const renderCard = (artikal, id) => {
        return (
            <Card className={"kartice"} style={{ width: "18rem" }} key={id} >
                <Card.Img className="slikaProizvoda" variant="top" src={artikal.putanjaDoSlike} />
                <Card.Body>
                    <Card.Title><a href={/artikal/+ artikal.id}>{artikal.naziv}</a></Card.Title>
                    <Card.Text>{artikal.cena} РСД</Card.Text>
                    {AuthenticationService.getRole() === "ROLE_PRODAVAC" && (
                        <>
                            <Button
                                variant="info"                                block
                                as={Link} to={"/edit-artikla/"+artikal.id}
                            >
                                Измени
                            </Button>
                            <Button
                                variant="info"                                block
                                onClick={() => deleteArtikal(artikal.id)}
                            >
                                Обриши
                            </Button>
                        </>
                    )}
                </Card.Body>
            </Card>

        );
    };

    return(
        <Container  className={"kontejner"}>
        <div>
            {AuthenticationService.getRole() === "ROLE_PRODAVAC" && (
                <>
                    <Button as={Link} to="/dodavanje-artikla"
                            variant="info"
                            block
                    >
                        Dodaj novi artikal
                    </Button>
                </>
            )}


            <div className="grid">{artikli.map(renderCard)}</div>
        </div>
        </Container>

    );
};




export default ProdavacArtikli;