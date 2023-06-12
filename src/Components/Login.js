import React, { useState } from "react";
import axios from "axios";
import { encode } from "base-64";
import { Navigate } from "react-router-dom";

function Login({ handleLogin }) {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(null);
    const [redirectToHome, setRedirectToHome] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.get(
                "http://localhost:8081/getAllCategory",
                {
                    headers: {
                        "Content-Type": "application/json",
                        Authorization:
                            "Basic " + encode(username + ":" + password),
                    },
                }
            );
            console.log("Zalogowano użytkownika:", response.data);
            localStorage.setItem("username", username);
            localStorage.setItem("password", password);
            handleLogin(username);
            setRedirectToHome(true);
        } catch (error) {
            console.error("Błąd logowania użytkownika:", error);
            setError("Błędne dane logowania");
        }
    };

    if (redirectToHome) {
        return <Navigate to="/" />;
    }

    return (
        <section className="loginPage wrapper">
            <div>
                <div className="icons">
                    <div className="iconX">X</div>
                    <div className="iconY">Y</div>
                    <div className="iconZ">Z</div>
                    <div className="iconO">O</div>
                </div>
                <h2 className="logo">Logowanie</h2>
                {error && <p>{error}</p>}
                <form onSubmit={handleSubmit}>
                    <p>Podaj login:</p>
                    <input
                        type="text"
                        name="username"
                        value={username}
                        required
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <br />
                    <p>Podaj Hasło:</p>
                    <input
                        type="password"
                        name="password"
                        value={password}
                        required
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <br />
                    <button className="btn" type="submit">
                        Login
                    </button>
                </form>
            </div>
        </section>
    );
}

export default Login;
