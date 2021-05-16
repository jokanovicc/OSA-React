import React, {useState} from "react";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {RegistracijaService} from "../../services/RegistracijaService";


const RegisterKupac = ()=>{

    const[kupac, setKupac] = useState({
        ime: "",
        prezime:"",
        username:"",
        password:"",
        adresa:""
    });


    const handleFormInputChange=(name)=>(event)=>{
        const val = event.target.value;

        // ... - Destructuring assignment - omogućuje raspakivanje vrednosti objekata ili nizova
        // setCredentails će zameniti stanje novim objektom koji uzima vrednosti iz prethodnog stanja kredencijala
        // ali sa ažuriranom vrednošću [name] polja
        setKupac({ ...kupac, [name]: val });
    }

    const register = async () => {
        await RegistracijaService.RegistracijaKupac(kupac);

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
                                value={kupac.ime}
                                onChange={handleFormInputChange("ime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Prezime</Form.Label>
                            <Form.Control
                                type="text"
                                name="prezime"
                                value={kupac.prezime}
                                onChange={handleFormInputChange("prezime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Adresa</Form.Label>
                            <Form.Control
                                required
                                type="text"
                                name="prezime"
                                value={kupac.adresa}
                                onChange={handleFormInputChange("adresa")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Username</Form.Label>
                            <Form.Control
                                type="text"
                                name="username"
                                value={kupac.username}
                                onChange={handleFormInputChange("username")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Password</Form.Label>
                            <Form.Control
                                type="password"
                                name="password"
                                value={kupac.password}
                                onChange={handleFormInputChange("password")}
                            />
                        </Form.Group>
                        <Button variant="success" onClick={register}>
                            Log in
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );


}

export default RegisterKupac;