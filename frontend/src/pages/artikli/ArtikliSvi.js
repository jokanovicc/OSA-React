import {useEffect, useState} from "react";
import {useHistory} from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
import {Container,Card,Button,Row, Col,CardDeck} from "react-bootstrap";
import {AuthenticationService} from "../../services/AuthenticationService";
import {Link} from "react-router-dom";

const ArtikliSvi=(props)=>{
    const[artikli, setArtikli] = useState([]);


    useEffect(()=> {
        fetchArtikli();
    })


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
                <Card.Img variant="top" src={artikal.putanjaDoSlike} />
                <Card.Body>
                    <Card.Title>{artikal.naziv}</Card.Title>
                    <Card.Text>{artikal.cena} RSD</Card.Text>
                    <Button>Kupi</Button>
                    {AuthenticationService.getRole() === "ROLE_PRODAVAC" && (
                        <>
                            <Button
                                variant="warning"
                                block
                                as={Link} to={"/edit-artikla/"+artikal.id}
                            >
                                Edit
                            </Button>
                            <Button
                                variant="danger"
                                block
                                onClick={() => deleteArtikal(artikal.id)}
                            >
                                Delete
                            </Button>
                        </>
                    )}
                </Card.Body>
            </Card>
        );
    };

    return(
        <div>
        {AuthenticationService.getRole() === "ROLE_PRODAVAC" && (
                <>
                    <Button as={Link} to="/dodavanje-artikla"
                        variant="warning"
                        block
                    >
                        Dodaj novi artikal
                    </Button>
                </>
            )}


    <div className="grid">{artikli.map(renderCard)}</div>
        </div>
);
};




export default ArtikliSvi;