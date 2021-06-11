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
                        Продавци
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }

            {
                AuthenticationService.getRole()=== "ROLE_KUPAC" ? (
                    <Nav.Link className={"font"} as={Link} to="/nedostavljene">
                        Непристигле поруџбине
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }

            {
                AuthenticationService.getRole()=== "ROLE_ADMIN" ? (
                    <Nav.Link className={"font"} as={Link} to="/blokiranja">
                        Управљење корисницима
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }



            {
                AuthenticationService.getRole()=== "ROLE_PRODAVAC" ? (
                    <Nav.Link className={"font"} as={Link} to="/moji-artikli">
                        Моји артикли
                    </Nav.Link>
                ):(
                    console.log("ima")

                )


            }



            {TokenService.getToken() ? (
                <Nav.Link className={"font"} as={Link} to="/edit-info">
                    Моје информације
                </Nav.Link>
            ) : (
                console.log("nema")
            )}



            {TokenService.getToken() ? (
                console.log("Nije")
            ) : (
                <Nav.Link className={"font"} as={Link} to="/registracija-kupac">
                    Региструј се као купац
                </Nav.Link>

            )}

            {TokenService.getToken() ? (
                <Button style={{float:"right"}} onClick={() => AuthenticationService.logout()}>Izlogujte se</Button>

            ) : (
                <Nav.Link className={"font"} as={Link} to="/login">
                    Улогуј се
                </Nav.Link>
            )}
        </Navbar>
    );
};

export default NavBar;
