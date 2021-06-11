import {useEffect, useState} from "react";
import {PorudzbinaService} from "../../services/PorudzbinaService";
import {RegistracijaService} from "../../services/RegistracijaService";
import {Button, Col, Container, Row, Table} from "react-bootstrap";
import Swal from "sweetalert2";


const BlokiranjeKorisnika=()=>{
    const[korisnici,setKorisnici] = useState([]);

    useEffect(()=>{
        fetchKorisnici();

    })



    async function fetchKorisnici(){
        try{
            const response = await RegistracijaService.getSvi();
            setKorisnici(response.data);

        }catch (e) {
            console.error(`Greska prilikom dostavljanja korisnika ${e}`)
        }
    }
    async function blokirajKorisnika(id) {
        try {
            await RegistracijaService.blokirajKorisnika(id);

            // Za novu vrednost liste zadataka uzima se prethodna lista, filtrirana tako da ne sadrži obrisani zatak
            setKorisnici((korisnici) => korisnici.filter((korisnik) => korisnik.id !== id));
            Swal.fire(
                'Добар посао!',
                'Успешно сте сажежли корисника!',
                'success'
            )
        } catch (error) {
            console.error(`Greška prilikom blokiranja korisnika ${id}: ${error}`);
        }
    }

    return(

        <Container className={"kontejner"}>
            <Row>
                <Col md={{ span: 8, offset: 2 }} style={{ textAlign: "center" }}>
                    <h1>Блокирање корисника</h1>
                    <hr/>

                    <Table bordered striped style={{ marginTop: 5 }}>
                        <thead className="thead-dark">
                        <tr>
                            <th>Корисничко име</th>
                            <th>Име</th>
                            <th>Презиме</th>
                            <th colSpan={2}>Блокирај</th>
                        </tr>
                        </thead>
                        <tbody>
                        {korisnici.length===0 ?
                            <tr align="center">
                                <td colSpan="6">{korisnici.length}Нема више шефе.</td>
                            </tr> :
                            korisnici.map((korisnik) => {
                                return (
                                    <tr key={korisnik.id}>
                                        <td>{korisnik.username}</td>
                                        <td>{korisnik.ime}</td>
                                        <td>{korisnik.prezime}</td>
                                        <td>
                                            <Button
                                                variant="info"
                                                onClick={() => blokirajKorisnika(korisnik.id)}

                                            >
                                                САЖЕЖИ
                                            </Button>
                                        </td>
                                    </tr>
                                );
                            })}
                        </tbody>
                    </Table>
                    <hr/>

                </Col>
            </Row>
        </Container>


    );


}
export default BlokiranjeKorisnika;