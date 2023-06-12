import React, { useState } from "react";
import axios from "axios";

function Register() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [registrationSuccess, setRegistrationSuccess] = useState(false);
    const [registrationError, setRegistrationError] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!username || !password) {
            // Sprawdzenie, czy pola są uzupełnione
            return;
        }

        try {
            await axios.post(
                "http://localhost:8081/register1",
                {
                    username: username,
                    password: password,
                },
                {
                    headers: {
                        "Content-Type": "application/json",
                    },
                }
            );
            setRegistrationSuccess(true); // Ustawienie stanu na true po udanej rejestracji
            console.log("Użytkownik został zarejestrowany.");
            // Wyświetl komunikat o sukcesie
        } catch (error) {
            console.error("Błąd rejestracji użytkownika:", error.response);
            setRegistrationError("Błąd rejestracji użytkownika"); // Ustawienie informacji o błędzie
        }
    };

    return (
        <section className="registerPage wrapper">
            <div className="icons">
                <div className="iconX">X</div>
                <div className="iconY">Y</div>
                <div className="iconZ">Z</div>
                <div className="iconO">O</div>
            </div>
            <div>
                <h2 className="logo">Rejestracja</h2>
                {registrationSuccess && !registrationError && (
                    <p className="success-message">Użytkownik został utworzony.</p>
                )}
                {registrationError && (
                    <p className="error-message">{registrationError}</p>
                )}
                <form>
                    <label>
                        <p>Podaj login:</p>
                        <input
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </label>
                    <label>
                        <p>Podaj Hasło:</p>
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </label>
                </form>
                <button className="btn" type="button" onClick={handleSubmit}>
                    Zarejestruj
                </button>
            </div>
        </section>
    );
}

export default Register;
