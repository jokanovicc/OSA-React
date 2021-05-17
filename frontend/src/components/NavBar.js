import React from "react";
import { Button, Nav, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import { TokenService } from "../services/TokenService";
import { AuthenticationService } from "../services/AuthenticationService";

const NavBar = () => {
    const role = AuthenticationService.getRole();
    return (
        <Navbar
            className="navigacija"
            expand
        >
            <Navbar.Brand className={"logo"} as={Link} to="/">
                Т А В Е Р Н А
            </Navbar.Brand>
            {/* className="mr-auto" podesi ovu grupu Nav Link-ova da se "rašire" sto je više moguće,
              i zbog toga je dugme Log in/Log out skroz sa leve strane */}
            {
                AuthenticationService.getRole()=== "ROLE_KUPAC" ? (
                    <Nav.Link className={"font"} as={Link} to="/prodavci">
                        Prodavci
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }

            {
                AuthenticationService.getRole()=== "ROLE_KUPAC" ? (
                    <Nav.Link className={"font"} as={Link} to="/nedostavljene">
                        Nepristigle porudžbine
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }

            {
                AuthenticationService.getRole()=== "ROLE_ADMIN" ? (
                    <Nav.Link className={"font"} as={Link} to="/blokiranja">
                        Upravljanje Korisnicima
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }



            {
                AuthenticationService.getRole()=== "ROLE_PRODAVAC" ? (
                    <Nav.Link className={"font"} as={Link} to="/moji-artikli">
                        Moji Artikli
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }



            {TokenService.getToken() ? (
                <Nav.Link className={"font"} as={Link} to="/edit-info">
                    Moje informacije
                </Nav.Link>
            ) : (
                console.log("nema")
            )}



            {TokenService.getToken() ? (
                console.log("Nije")
            ) : (
                <Nav.Link className={"font"} as={Link} to="/registracija-kupac">
                    Registruj se kao kupac
                </Nav.Link>

            )}

            {TokenService.getToken() ? (
                <Button style={{float:"right"}} onClick={() => AuthenticationService.logout()}>Izlogujte se</Button>

            ) : (
                <Nav.Link className={"font"} as={Link} to="/login">
                    Uloguj se
                </Nav.Link>
            )}
        </Navbar>
    );
};

export default NavBar;
