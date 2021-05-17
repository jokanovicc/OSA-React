import React, {useState} from "react";
import {RegistracijaService} from "../../services/RegistracijaService";
import {ArtikliService} from "../../services/ArtikliService";
import {AuthenticationService} from "../../services/AuthenticationService";
import {Button, Col, Container, Form, Row} from "react-bootstrap";

const DodavanjeArtikla = (props) => {

    const [artikal, setArtikal] = useState({
        cena:"",
        naziv:"",
        opis:"",
        putanjaDoSlike:"",
    })


    const handleFormInputChange=(name)=>(event)=>{
        const val = event.target.value;

        // ... - Destructuring assignment - omogućuje raspakivanje vrednosti objekata ili nizova
        // setCredentails će zameniti stanje novim objektom koji uzima vrednosti iz prethodnog stanja kredencijala
        // ali sa ažuriranom vrednošću [name] polja
        setArtikal({ ...artikal, [name]: val });
    }


    const dodavanje = async () => {
        await ArtikliService.addArtikal(artikal);
        resetKorisnik();
    }

    const resetKorisnik=()=>{
        setArtikal({
            cena:"",
            naziv:"",
            opis:"",
            putanjaDoSlike:"",
        });
    }

    return (


        <Container  className={"kontejner"}>
            <Row>
                <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
                    <Form>
                        <Form.Group>
                            <Form.Label>Naziv</Form.Label>
                            <Form.Control
                                type="text"
                                name="naziv"
                                value={artikal.naziv}
                                onChange={handleFormInputChange("naziv")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Opis</Form.Label>
                            <Form.Control
                                required
                                type="text"
                                name="opis"
                                value={artikal.opis}
                                onChange={handleFormInputChange("opis")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Putanja do Slike</Form.Label>
                            <Form.Control
                                type="text"
                                name="putanjaDoSlike"
                                value={artikal.putanjaDoSlike}
                                onChange={handleFormInputChange("putanjaDoSlike")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Cena</Form.Label>
                            <Form.Control
                                type="number"
                                name="cena"
                                value={artikal.cena}
                                onChange={handleFormInputChange("cena")}
                            />
                        </Form.Group>
                        <Button variant="success" onClick={dodavanje}>
                            Dodaj
                        </Button>
                        <Button style={{"margin-left":"50px"}}  variant={"info"} onClick={resetKorisnik}>
                            Ресетуј
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );


}

export default DodavanjeArtikla;