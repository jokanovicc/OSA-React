import {Col, Row, Container, Image, Button, Nav} from "react-bootstrap";
import slika from './slika.jpg';
import React from "react";
import {Link} from "react-router-dom";
import {AuthenticationService} from "../services/AuthenticationService";
import {TokenService} from "../services/TokenService"; // Tell webpack this JS file uses this image


const Home = () => {

    const role = AuthenticationService.getRole();

    return(


    <Container className={"kontejner"}>
            <Row>
                <Col md={5} className={"naslov"} style={{ textAlign: "center" }}>
                    <h1>Т А В Е Р Н А</h1>
                    <h4>//dostava hrane//</h4>

                    {TokenService.getToken() && role === "ROLE_PRODAVAC" ? (
                        <Button as={Link} to="/dodavanje-artikla">Dodaj artikal</Button>
                    ) : (
                        <Button as={Link} to="/registracija-prodavac">
                            Vi ste prodavac? Registrujte se
                        </Button>


                    )}


                </Col>
                <Col md={7}>
                    <Image src={slika} className={"slika"} />
                </Col>
            </Row>
        </Container>

);
}
export default Home;