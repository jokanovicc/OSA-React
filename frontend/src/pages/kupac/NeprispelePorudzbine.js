import {useEffect, useState} from "react";
import {PorudzbinaService} from "../../services/PorudzbinaService";
import {Button, Col, Container, Row, Table} from "react-bootstrap";
import {Link} from "react-router-dom";
import {ArtikliService} from "../../services/ArtikliService";


const NeprispelePorudzbine=()=>{
    const[porudzbine,setPorudzbine] = useState([]);



    useEffect(()=>{
        fetchPorudzbine();

    })



    async function fetchPorudzbine(){
        try{
            const response = await PorudzbinaService.getNedostavljene();
            setPorudzbine(response.data);

        }catch (e) {
            console.error(`Greska prilikom dostavljanja porudzbina ${e}`)
        }
    }

    async function stiglaPorudzbina(id) {
        try {
            await PorudzbinaService.stiglaPorudzbina(id);

            // Za novu vrednost liste zadataka uzima se prethodna lista, filtrirana tako da ne sadrži obrisani zatak
            setPorudzbine((porudzbine) => porudzbine.filter((porudzbina) => porudzbina.id !== id));
        } catch (error) {
            console.error(`Greška prilikom javljanja da je stiglo ${id}: ${error}`);
        }
    }



    return(

        <Container className={"kontejner"}>
            <Row>
                <Col md={{ span: 8, offset: 2 }} style={{ textAlign: "center" }}>
                    <h1>Несустигле поруџбине</h1>
                    <hr/>

                    <Table bordered striped style={{ marginTop: 5 }}>
                        <thead className="thead-dark">
                        <tr>
                            <th>Поруџбина од дана</th>
                            <th colSpan={2}>Обавести да је сустигло</th>
                        </tr>
                        </thead>
                        <tbody>
                        {porudzbine.length===0 ?
                            <tr align="center">
                                <td colSpan="6">{porudzbine.length}Нема више.</td>
                            </tr> :
                        porudzbine.map((porudzbina) => {
                            return (
                                <tr key={porudzbina.id}>
                                    <td>{porudzbina.satnica}</td>
                                    <td>
                                        <Button
                                            variant="info"
                                            onClick={() => stiglaPorudzbina(porudzbina.id)}
                                        >
                                            Стигло је!
                                        </Button>
                                    </td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </Table>
                    <hr/>
                    <h3>Желиш оставити коментар на већ стиглу?</h3>
                    <h4><a href={"#"}>Ostavi komentar!</a></h4>

                </Col>
            </Row>
        </Container>


    );




}

export default NeprispelePorudzbine;