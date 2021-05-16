import React, {useEffect, useState} from "react";
import {useParams} from "react-router";
import {RegistracijaService} from "../../services/RegistracijaService";
import {Alert, Button, Form} from "react-bootstrap";

const ResetPassword=()=>{
    const [korisnik, setKorisnik] = useState({
        ime: "",
        prezime:"",
        username:"",
        password:"",
        adresa:""
    })


    const[sifre,setSifre] = useState({
        staraSifra:"",
        novaSifra:""
    })


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

    const handleFormInputChange = (name) => (event) => {
        const val = event.target.value;
        setSifre({ ...sifre, [name]: val });
    };

    async function resetSifra() {
        try {
            var bcrypt = require('bcryptjs');
            var sifraCompare =bcrypt.compareSync(sifre.staraSifra,korisnik.password);
            if(sifraCompare===false){
                alert("Nije ti bato ista sifra to")
            }else {
                korisnik.password=sifre.novaSifra;
                await RegistracijaService.editKorisnik(korisnik)
                setShowSuccessAlert(true);
            }
        } catch (error) {
            console.error(`Greška prilikom zamene sifre stanja korisnika: ${error}`);
        }
    }


    return (
        <>
            {showSuccessAlert && (
                <Alert
                    variant="success"
                    onClose={() => setShowSuccessAlert(false)}
                    dismissible
                >
                    Sifra uspešno ažurirana!
                </Alert>
            )}
            <h1>Vase informacije</h1>
            <Form>

                <Form.Group>
                    <Form.Label>Stara sifra</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("staraSifra")}
                        name="staraSifra"
                        value={sifre.staraSifra}
                        as="input"
                        type="password"
                    />
                </Form.Group>



                <Form.Group>
                    <Form.Label>Nova Sifra</Form.Label>
                    <Form.Control
                        onChange={handleFormInputChange("novaSifra")}
                        name="novaSifra"
                        value={sifre.novaSifra}
                        as="input"
                        type="password"
                    />
                </Form.Group>


                <Button variant="primary" onClick={() => resetSifra()}>
                    Edit
                </Button>
            </Form>
        </>
    );

}

export default ResetPassword;