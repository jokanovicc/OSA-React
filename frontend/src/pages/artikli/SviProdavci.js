import {useEffect, useState} from "react";
import {ArtikliService} from "../../services/ArtikliService";
import {Container,Card,Button,Table,Row, Col} from "react-bootstrap";
import {Link} from "react-router-dom";
import {useParams} from "react-router";

const SviProdavci=()=>{
    const[prodavci,setProdavci] = useState([]);


    const {id} = useParams();

    useEffect(()=>{
        fetchProdavci();
    },[id])


    async function fetchProdavci(){
        try{
            const response = await ArtikliService.getProdavci();
            setProdavci(response.data);

        }catch (error) {
            console.error(`Greska prilikom dobavljanja sadrzaja: ${error}`)

        }
    }

    return(

        <Container className={"kontejner"}>
            <Row>
                <Col md={{ span: 8, offset: 2 }} style={{ textAlign: "center" }}>
                    <h1>Продавци</h1>

                    <Table bordered striped style={{ marginTop: 5 }}>
                        <thead className="thead-dark">
                        <tr>
                            <th>Име</th>
                            <th>Презиме</th>
                            <th>Назив</th>
                            <th>Послује од</th>
                            <th colSpan={2}>Акције</th>
                        </tr>
                        </thead>
                        <tbody>
                        {prodavci.map((prodavac) => {
                            return (
                                <tr key={prodavac.id}>
                                    <td>{prodavac.korisnik.ime}</td>
                                    <td>{prodavac.korisnik.prezime}</td>
                                    <td>{prodavac.naziv}</td>
                                    <td>{prodavac.poslujeOd}</td>
                                    <td>
                                        <Button
                                            variant="info"
                                            as={Link} to={"/artikli/"+prodavac.id}
                                        >
                                            ПОСЕТИ
                                        </Button>
                                    </td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </Table>
                </Col>
            </Row>
        </Container>



    );


}

export default SviProdavci;