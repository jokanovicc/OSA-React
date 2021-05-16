import {Button, Container} from "react-bootstrap";
import React, {useState} from "react";

const RegistracijaCheck=()=>{
    const [credentials, setCredentials] = useState({
        username: "",
        password: "",
    });

    return(
    <Container className={"kontejner"}>
        <Button variant="success" onClick={"/registracija"}>
            Registracija
        </Button>
        <Button variant="success" onClick={"/registracija"}>
            Registracija 2
        </Button>
    </Container>
    );
};
export default RegistracijaCheck;