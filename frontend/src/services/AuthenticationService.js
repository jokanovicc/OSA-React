import TavernaAxiosClient from "./clients/TavernaAxiosClient";
import { TokenService } from "./TokenService";
import Swal from "sweetalert2";

export const AuthenticationService = {
    login,
    logout,
    getRole,
};

async function login(userCredentials) {
    try {
        const response = await TavernaAxiosClient.post(
            "http://localhost:8080/users/login",
            userCredentials

    );
        const decoded_token = TokenService.decodeToken(response.data);
        if (decoded_token) {
            TokenService.setToken(response.data);
            window.location.assign("/");
        } else {
            console.error("Invalid token");
        }
    } catch (error) {
        await Swal.fire({
            icon: 'error',
            title: 'Уупс...',
            text: 'Погрешно име или лозинка!',
        })
        console.error(error);
    }
}

function logout() {
    TokenService.removeToken();
    window.location.assign("/");
}

function getRole() {
    const token = TokenService.getToken();
    const decoded_token = token ? TokenService.decodeToken(token) : null;
    if (decoded_token) {
        return decoded_token.role.authority;
    } else {
        return null;
    }
}
