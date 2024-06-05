import React, { useState } from 'react';
import '../css/LoginAdmin.css';
import fundo from '../img/fond.jpg';
import logo_s from '../img/logo_s.png';
import { useNavigate } from 'react-router-dom';

function LoginAdmin() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await fetch(`http://192.168.160.219:8981/api/accounts/login`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password }),
      });

      if (!response.ok) {
        setError("Login failed");
        return;
      }

      const data = await response.json();

      console.log("Login response:", data);
      localStorage.setItem("token", data.token);
      localStorage.setItem("user", JSON.stringify(data));  // Save user details in local storage
      localStorage.setItem("userId", data.userId);

      // alert("Login Successful");

      UserInfo(email);
    } catch (error) {
      alert("Login error");
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
      // alert(JSON.stringify(data));

      if (data.role !== "ADMIN") {
        // setError("Access denied: Admins only");
        alert("Access denied: Admins only");
        return;
      }

      console.log('User loged in :', data);
      localStorage.setItem("userId", data.userId);

      // alert("Login Successful");
      navigate("/admin");

      return data;
    } catch (error) {
      console.error('Failed to fetch user loged in:', error);
    }
  };

  return (
    <div
      className="register-container"
      style={{ backgroundImage: `url(${fundo})` }}
    >
      <div className='left'>
        <div className="register-form">
          <h2 className='Title'>LOGIN</h2>
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
          {error && <p className="error-message">{error}</p>}
        </div>
      </div>
      <div className='right'>
        <div className="register-logo">
          <img src={logo_s} alt="Logo" className="logo-style" />
        </div>
      </div>
    </div>
  );
}

export default LoginAdmin;
