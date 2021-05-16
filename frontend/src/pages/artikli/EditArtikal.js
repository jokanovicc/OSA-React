import React, { useEffect, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useParams } from "react-router";
import {ArtikliService} from "../../services/ArtikliService";
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
            await ArtikliService.editArtikal(id, artikal);
            setShowSuccessAlert(true);
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
                    Artikal uspešno ažuriran!
                </Alert>
            )}
            <h1>Artikal</h1>
            <Form>
                <Form.Group>
                    <Form.Label>Naziv</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("naziv")}
                        name="naziv"
                        value={artikal.naziv}
                        as="input"
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Opis</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("opis")}
                        name="opis"
                        value={artikal.opis}
                        as="input"
                    />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Cena</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("cena")}
                        name="cena"
                        value={artikal.cena}
                        as="input"
                    />
                </Form.Group>
                <Button variant="primary" onClick={() => editArtikal()}>
                    Edit
                </Button>
            </Form>
        </>
    );
};

export default EditArtikal;
