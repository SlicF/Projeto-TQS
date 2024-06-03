import React, { useState } from 'react';
import '../css/Login.css';
import fundo from '../img/fundo.jpg';
import logo_s from '../img/logo_s.png';
import Navbar from '../components/Navbar';

import { useNavigate } from 'react-router-dom';

function Login() {

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleRegister = () => {
    navigate("/register");
  };

  const handleLogin = async () => {
    try {
      const token = localStorage.getItem("token");
      const response = await fetch(`http://localhost:8981/api/accounts/login`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ email, password }),
        }
      );

      if (!response.ok) {
        alert("Login failed");
        return;
      }

      const data = await response.json();

      console.log("Login response:", data);
      localStorage.setItem("token", data.token);
      // localStorage.setItem("user", JSON.stringify(data));  // Save user details in local storage
      // localStorage.setItem("userId", data.userID);
      // localStorage.setItem('user', JSON.stringify({ email, password }));


      alert("Login Successful");

      UserInfo(email);
      navigate("/searchflight");
    } catch (error) {
      alert("Login error");
      // alert(error);

      console.error("Login error:", error);
    }
  };

  const UserInfo = async (email) => {

    try {
      const response = await fetch(`http://localhost:8981/api/accounts/userInfoByUsername?username=${email}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        }
      });

      if (!response.ok) {
        throw new Error('Failed to fetch flights: ' + response.statusText);
      }

      const data = await response.json();
      console.log('User loged in :', data);
      localStorage.setItem("userId", data.userId);

      return data;
    } catch (error) {
      console.error('Failed to fetch user loged in:', error);
    }
  };


  return (
    <div>
      <Navbar />
      <div
        className="register-container"
        style={{ backgroundImage: `url(${fundo})` }}
      >
        <div className='left'>
          <div className="register-form">
            <h2 className='Title'>LOGIN</h2>
            {/* <div className="input-group">
              <p className="label">Nome:</p>
              <input
                type="text"
                name="nome"
                value={form.nome}
                onChange={handleInputChange}
                placeholder="Nome"
                required
              />
            </div> */}
            <div className="input-group">
              <p className="label">Email:</p>
              <input
                id="email"
                type="email"
                placeholder="Enter email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div className="input-group">
              <p className="label">Senha:</p>
              <input
                id="password"
                type="password"
                placeholder="Enter password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <div className="form-actions">
              <button type="submit" className="btn btn-success" onClick={handleLogin}>Login</button>
            </div>
            <div style={{ marginTop: "10px" }}>
              <p style={{ textAlign: "center" }}>
                Don’t have an account? <i className="buttonCreateAccount" onClick={handleRegister}>Create one now!</i>
              </p>
            </div>
          </div>
        </div>
        <div className='right'>
          <div className="register-logo">
            <img src={logo_s} alt="Logo" />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
