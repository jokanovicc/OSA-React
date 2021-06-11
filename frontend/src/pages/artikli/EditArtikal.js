import React, { useEffect, useState } from "react";
import {Alert, Button, Container, Form} from "react-bootstrap";
import { useParams } from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
import Swal from "sweetalert2";
const EditArtikal = () => {
    const [artikal, setArtikal] = useState({
        naziv: "",
        opis: "",
        cena: "",
        id: "",
    });
    const [showSuccessAlert, setShowSuccessAlert] = useState(false);

    // useParams Hook iz React Routera - preko nje je moguće dobiti paramet koji se zahteva na ruti, poput ID-ja
    const { id } = useParams();

    useEffect(() => {
        fetchArtikal(id);
    }, [id]);


    async function fetchArtikal(id) {
        try {
            const response = await ArtikliService.getArtikal(id);
            setArtikal(response.data);
        } catch (error) {
            console.error(`Greška prilikom dobavljanja zadataka ${id}: ${error}`);
        }
    }

    async function editArtikal() {
        try {
            if(artikal.naziv !== '' && artikal.cena !== ''&& artikal.opis!==''&& artikal.putanjaDoSlike!==''){
                await ArtikliService.editArtikal(id, artikal);
                setShowSuccessAlert(true);
            }else{
                Swal.fire({
                    icon: 'error',
                    title: 'Уппсс...',
                    text: 'Не можете послати празно поље!',
                })
            }


        } catch (error) {
            console.error(`Greška prilikom аžuriranja stanja artikla: ${error}`);
        }
    }

    const handleFormInputChange = (name) => (event) => {
        const val = event.target.value;
        setArtikal({ ...artikal, [name]: val });
    };

    return (
        <>
            {showSuccessAlert && (
                <Alert
                    variant="success"
                    onClose={() => setShowSuccessAlert(false)}
                    dismissible
                >
                    Артикал успешно ажуриран!
                </Alert>
            )}
            <Container className={"kontejner"}>
                <h1>Измена артикла</h1>
                <hr/>
                <Form>
                <Form.Group>
                    <Form.Label>Назив</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("naziv")}
                        name="naziv"
                        value={artikal.naziv}
                        as="input"
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Опис</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("opis")}
                        name="opis"
                        value={artikal.opis}
                        as="input"
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Цена</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("cena")}
                        name="cena"
                        value={artikal.cena}
                        as="input"
                    />
                </Form.Group>
                <Button variant="primary" onClick={() => editArtikal()}>
                    Измени
                </Button>
            </Form>
            </Container>
        </>
    );
};

export default EditArtikal;
