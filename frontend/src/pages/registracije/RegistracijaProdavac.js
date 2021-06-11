import React, {useState} from "react";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {RegistracijaService} from "../../services/RegistracijaService";
import DatePicker from "react-datepicker";
import Swal from "sweetalert2";


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
        if(prodavac.ime !=='' && prodavac.password !== '' && prodavac.prezime !== '' && prodavac.adresa !=='' && prodavac.username!==''&&prodavac.naziv!==''&&prodavac.imejl!==''&&prodavac.poslujeOd!=='') {
            await RegistracijaService.RegistracijaProdavac(prodavac);
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
                    <h1>Регистрација Продавца</h1>
                    <hr/>
                    <Form>
                        <Form.Group>
                            <Form.Label>Име</Form.Label>
                            <Form.Control
                                type="text"
                                name="ime"
                                value={prodavac.ime}
                                onChange={handleFormInputChange("ime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Презиме</Form.Label>
                            <Form.Control
                                type="text"
                                name="prezime"
                                value={prodavac.prezime}
                                onChange={handleFormInputChange("prezime")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Адреса</Form.Label>
                            <Form.Control
                                required
                                type="text"
                                name="prezime"
                                value={prodavac.adresa}
                                onChange={handleFormInputChange("adresa")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Корисничко име</Form.Label>
                            <Form.Control
                                type="text"
                                name="username"
                                value={prodavac.username}
                                onChange={handleFormInputChange("username")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Лозинка</Form.Label>
                            <Form.Control
                                type="password"
                                name="password"
                                value={prodavac.password}
                                onChange={handleFormInputChange("password")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Имејл</Form.Label>
                            <Form.Control
                                type="email"
                                name="imejl"
                                value={prodavac.imejl}
                                onChange={handleFormInputChange("imejl")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Назив</Form.Label>
                            <Form.Control
                                type="text"
                                name="naziv"
                                value={prodavac.naziv}
                                onChange={handleFormInputChange("naziv")}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Послује од</Form.Label>
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
                            Регистрација
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    );


}

export default RegistracijaProdavac;