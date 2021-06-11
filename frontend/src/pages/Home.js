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
                <Col md={4} className={"naslov"} style={{ textAlign: "center" }}>
                    <h1>Т А В Е Р Н А</h1>
                    <h4>//достава хране//</h4>

                    {TokenService.getToken() ? (
                        console.log("Nije")
                    ) : (
                        <Button className={"font"} as={Link} to="/registracija-prodavac">
                            Региструј се као продавац
                        </Button>

                    )}


                </Col>
                <Col md={8}>
                    <Image src={slika} className={"slika"} />
                </Col>
            </Row>
        </Container>

);
}
export default Home;