import React, {useState} from "react";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {RegistracijaService} from "../../services/RegistracijaService";
import DatePicker from "react-datepicker";


const RegistracijaProdavac = ()=>{

    const[prodavac, setProdavac] = useState({
        ime: "",
        prezime:"",
        username:"",
        password:"",
        adresa:"",
        poslujeOd:"",
        imejl:"",
        naziv:""
    });


    const handleFormInputChange=(name)=>(event)=>{
        const val = event.target.value;

        // ... - Destructuring assignment - omogućuje raspakivanje vrednosti objekata ili nizova
        // setCredentails će zameniti stanje novim objektom koji uzima vrednosti iz prethodnog stanja kredencijala
        // ali sa ažuriranom vrednošću [name] polja
        setProdavac({ ...prodavac, [name]: val });
    }

    const register = async () => {
        await RegistracijaService.RegistracijaProdavac(prodavac);

    }


    return (


        <Container>
            <Row>
                <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
                    <Form>
                        <Form.Group>
                            <Form.Label>Ime</Form.Label>
                            <Form.Control
                                type="text"
                                name="ime"
                                value={prodavac.ime}
                                onChange={handleFormInputChange("ime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Prezime</Form.Label>
                            <Form.Control
                                type="text"
                                name="prezime"
                                value={prodavac.prezime}
                                onChange={handleFormInputChange("prezime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Adresa</Form.Label>
                            <Form.Control
                                required
                                type="text"
                                name="prezime"
                                value={prodavac.adresa}
                                onChange={handleFormInputChange("adresa")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control
                                type="text"
                                name="username"
                                value={prodavac.username}
                                onChange={handleFormInputChange("username")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control
                                type="password"
                                name="password"
                                value={prodavac.password}
                                onChange={handleFormInputChange("password")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Imejl</Form.Label>
                            <Form.Control
                                type="email"
                                name="imejl"
                                value={prodavac.imejl}
                                onChange={handleFormInputChange("imejl")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Naziv</Form.Label>
                            <Form.Control
                                type="text"
                                name="naziv"
                                value={prodavac.naziv}
                                onChange={handleFormInputChange("naziv")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Posluje od</Form.Label>
                            <Form.Control
                                type="date"
                                name="poslujeOd"
                                min="1920-01-02"
                                max="2021-01-01"
                                value={prodavac.poslujeOd}
                                onChange={handleFormInputChange("poslujeOd")}
                            />
                        </Form.Group>
                        <Button variant="success" onClick={register}>
                            Register
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );


}

export default RegistracijaProdavac;