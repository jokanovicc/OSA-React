import React, {useState} from "react";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {RegistracijaService} from "../../services/RegistracijaService";
import Swal from "sweetalert2";


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

        if(kupac.ime !=='' && kupac.password !== '' && kupac.prezime !== '' && kupac.adresa !=='' && kupac.username!=='') {
            await RegistracijaService.RegistracijaKupac(kupac);
        }else{
            await Swal.fire({
                icon: 'error',
                title: 'Уппсс...',
                text: 'Не можете послати празно поље!',
            })
        }

    }


    return (


        <Container className={"kontejner"}>
            <Row>
                <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
                    <h1>Регистрација Купца</h1>
                    <hr/>
                    <Form>
                        <Form.Group>
                            <Form.Label>Име</Form.Label>
                            <Form.Control
                                type="text"
                                name="ime"
                                value={kupac.ime}
                                onChange={handleFormInputChange("ime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Презиме</Form.Label>
                            <Form.Control
                                type="text"
                                name="prezime"
                                value={kupac.prezime}
                                onChange={handleFormInputChange("prezime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Адреса</Form.Label>
                            <Form.Control
                                required
                                type="text"
                                name="prezime"
                                value={kupac.adresa}
                                onChange={handleFormInputChange("adresa")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Корисничко име</Form.Label>
                            <Form.Control
                                type="text"
                                name="username"
                                value={kupac.username}
                                onChange={handleFormInputChange("username")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Лозинка</Form.Label>
                            <Form.Control
                                type="password"
                                name="password"
                                value={kupac.password}
                                onChange={handleFormInputChange("password")}
                            />
                        </Form.Group>
                        <Button variant="success" onClick={register}>
                            Региструј се
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );


}

export default RegisterKupac;