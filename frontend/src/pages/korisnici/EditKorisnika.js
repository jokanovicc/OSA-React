import React, {useEffect, useState} from "react";
import {useParams} from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
import {RegistracijaService} from "../../services/RegistracijaService";
import {Alert, Button, Form,Container,Row, Col} from "react-bootstrap";
import {Link} from "react-router-dom";


const EditKorisnika=()=>{
    const[korisnik, setKorisnik] = useState({
        ime: "",
        prezime:"",
        username:"",
        password:"",
        adresa:""
    });




    const [showSuccessAlert, setShowSuccessAlert] = useState(false);


    const { id } = useParams();

    useEffect(() => {
        fetchKorisnik();
    }, [id]);

    async function fetchKorisnik() {
        try {
            const response = await RegistracijaService.getMyInfo();
            setKorisnik(response.data);
        } catch (error) {
            console.error(`Greška prilikom dobavljanja korisnika : ${error}`);
        }
    }

    async function editKorisnik() {
        try {
            await RegistracijaService.editKorisnik(korisnik)
            setShowSuccessAlert(true);
        } catch (error) {
            console.error(`Greška prilikom аžuriranja stanja korisnika: ${error}`);
        }
    }

    const handleFormInputChange = (name) => (event) => {
        const val = event.target.value;
        setKorisnik({ ...korisnik, [name]: val });
    };

    return (
        <>
            {showSuccessAlert && (
                <Alert
                    variant="success"
                    onClose={() => setShowSuccessAlert(false)}
                    dismissible
                >
                    Ваш налог успешно ажуриран
                </Alert>
            )}

            <Container  className={"kontejner"}>
                <Row>
                    <Col md={{ span: 8, offset: 2 }} style={{ textAlign: "center" }}>

            <h1>Ваше информације</h1>
            <Form>
                <Form.Group>
                    <Form.Label>Име</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("ime")}
                        name="ime"
                        value={korisnik.ime}
                        as="input"
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Презиме</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("prezime")}
                        name="prezime"
                        value={korisnik.prezime}
                        as="input"
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Корисничко</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("username")}
                        name="username"
                        value={korisnik.username}
                        as="input"
                    />
                </Form.Group>






                <Button variant="primary" onClick={() => editKorisnik()}>
                    Izmenite
                </Button>
                <hr/>
                <Button as={Link} to="/reset-sifra">
                    Resetujte sifru
                </Button>

            </Form>
                    </Col>
                </Row>
            </Container>

        </>
    );



}

export default EditKorisnika;