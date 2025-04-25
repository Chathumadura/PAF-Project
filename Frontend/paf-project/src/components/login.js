import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../Css/login.css";
import Navbar from "../Page/NavBar";
import Footer from "../Page/Footer";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        setError("");

        try {
            const res = await fetch("http://localhost:8070/api/users/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ email, password }),
            });

            const data = await res.json();

            if (res.ok) {
                localStorage.setItem("token", data.token);
                localStorage.setItem("userType", data.user.userType);

                if (data.user.userType === "Admin") {
                    window.location.href = "/admin/dashboard";
                } else if (data.user.userType === "Chef") {
                    window.location.href = "/chef/dashboard";
                } else {
                    window.location.href = "/home";
                }
            } else {
                setError(data.error || "🍲 Invalid credentials. Try again!");
            }
        } catch (err) {
            setError("⚠️ Server is not reachable. Please try again later.");
        }
    };

    return (
        <>
            <Navbar />

            <div className="login-container">
                <div className="login-box glass-effect">
                    <h2 className="login-title">Welcome Back, Food Lover! 🍽️</h2>
                    <p className="login-subtext">
                        Sign in to explore authentic traditional recipes, share your dishes, and savor the culture.
                    </p>

                    {error && <div className="error-message">{error}</div>}

                    <form className="login-form" onSubmit={handleLogin}>
                        <input
                            className="login-input"
                            type="email"
                            placeholder="Your Email"
                            required
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                        <input
                            className="login-input"
                            type="password"
                            placeholder="Your Password"
                            required
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        <button className="login-button" type="submit">
                            🍛 Log In
                        </button>
                    </form>

                    <div className="login-footer">
                        <a href="#" className="login-link">Forgot Password?</a>
                        <a className="login-link" onClick={() => navigate("/signup")}>
                            New here? Join our food family!
                        </a>
                    </div>
                </div>
            </div>

            <Footer />
        </>
    );
};

export default Login;
