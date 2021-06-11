import React from "react";
import { Col, Container, Row } from "react-bootstrap";


const NotFound=() => (
    <Container>
        <Row>
            <Col md={{ span: 6, offset: 3 }} style={{ textAlign: "center" }}>
                <h1>404 - Страница није нађена!</h1>
            </Col>
        </Row>
    </Container>


)
export default NotFound;