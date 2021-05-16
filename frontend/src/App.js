import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import NavBar from "./components/NavBar";
import {Container} from "react-bootstrap";
import NotFound from "./pages/NotFound";
import Home from "./pages/Home"
import Login from "./pages/Login";
import RegisterKupac from "./pages/registracije/RegisterKupac";
import ArtikliSvi from "./pages/artikli/ArtikliSvi";
import RegistracijaProdavac from "./pages/registracije/RegistracijaProdavac";
import SviProdavci from "./pages/artikli/SviProdavci";
import DodavanjeArtikla from "./pages/artikli/DodavanjeArtikla";
import EditArtikal from "./pages/artikli/EditArtikal";
import {PrivateRoute} from "./components/PrivateRoute";
import EditKorisnika from "./pages/korisnici/EditKorisnika";
import ResetPassword from "./pages/korisnici/ResetPassword";


function App() {
  return (

      <Router>
          <NavBar />
          <Container style={{ marginTop: 25 }}>
              <Switch>
                  <Route exact path="/" component={Home} />
                  <Route exact path="/login" component={Login} />
                  <Route exact path="/registracija-kupac" component={RegisterKupac}/>
                  <Route exact path="/registracija-prodavac" component={RegistracijaProdavac}/>
                  <Route exact path="/artikli/:id" component={ArtikliSvi}/>
                  <Route exact path="/dodavanje-artikla" component={DodavanjeArtikla}/>
                  <Route exact path="/prodavci" component={SviProdavci}/>
                  <Route exact path="/edit-info" component={EditKorisnika}/>
                  <Route exact path="/reset-sifra" component={ResetPassword}/>

                  <PrivateRoute
                      exact
                      path="/edit-artikla/:id"
                      component={EditArtikal}
                      roles={["ROLE_PRODAVAC"]}
                  />



                  {/* Svaka putanja koja se ne može vodi do prikaza NotFound komponente */}
                  <Route component={NotFound} />
              </Switch>
          </Container>
      </Router>

  );
}

export default App;
