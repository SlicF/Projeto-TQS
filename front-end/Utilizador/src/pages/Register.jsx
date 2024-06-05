import React, { useState } from 'react';
import '../css/Register.css'; 
import fundo from '../img/fundo.jpg'; 
import logo_s from '../img/logo_s.png'; 
import Navbar from '../components/Navbar';

import { useNavigate } from 'react-router-dom'; 
function Register() {

  // const navigate = useNavigate();
  // const [form, setForm] = useState({
  //   nome: '',
  //   email: '',
  //   senha: ''
  // });

  // const handleInputChange = (event) => {
  //   const { name, value } = event.target;
  //   setForm({
  //     ...form,
  //     [name]: value
  //   });
  // };



  // const handleSubmit = (event) => {
  //   event.preventDefault();
  //   console.log(form);
  //   navigate('/login'); 
  // };

  // const handleCancel = () => {
  //   navigate('/');
  // };
  
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [city, setCity] = useState("");
  const [country, setCountry] = useState("");
  const navigate = useNavigate();
  const [error, setError] = useState("");



  const handleRegister = async () => {
    try {
      if (
        firstName.length < 2 ||
        lastName.length < 2 ||
        email.length < 2 ||
        password.length < 2 ||
        city.length < 2 ||
        country.length < 2
      ) {
        alert("Please fill in all the fields");
        throw new Error("Please fill in all the fields");
      }

      // if (userPassword !== userPasswordRepeated) {
      //   alert("Passwords do not match");
      //   throw new Error("Passwords do not match");
      // }

      const userData = {
        firstName,
        lastName,
        password,
        email,
        city,
        country
      };

      console.log(JSON.stringify(userData));

      const response = await fetch(
        `http://192.168.160.219:8981/api/accounts/register`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(userData),
        }
      );

      if (!response.ok) {
        throw new Error("Registration failed");
      }

      console.log("Registration successful");

      alert("Registration successful");
      navigate("/");
    } catch (error) {
      alert("Registration error");
      // alert(error);
      setError(error.message);
    }
  };

  const handleLogin = () => {
    navigate("/");
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
            <h2 className='Title'>REGISTER</h2>
            <p className="label">First Name:</p>
            <div className="input-group">
            <input
                id="firstName"
                type="firstName"
                placeholder="Enter first name"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                required
              />
            </div>
            <p className="label">Last Name:</p>
            <div className="input-group">
            <input
                id="lastName"
                type="lastName"
                placeholder="Enter last name"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                required
              />
            </div>
            <p className="label">City:</p>
            <div className="input-group">
            <input
                id="city"
                type="city"
                placeholder="Enter city"
                value={city}
                onChange={(e) => setCity(e.target.value)}
                required
              />
            </div>
            <p className="label">Country:</p>
            <div className="input-group">
            <input
                id="country"
                type="conutry"
                placeholder="Enter country"
                value={country}
                onChange={(e) => setCountry(e.target.value)}
                required
              />
            </div>
            <p className="label">Email:</p>
            <div className="input-group">
            <input
                id="email"
                type="email"
                placeholder="Enter email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <p className="label">Password:</p>
            <div className="input-group">
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
              <button className="btn btn-success" onClick={handleRegister}>Sign Up</button>
            </div>
            <div style={{ marginTop: "10px" }}>
              <p style={{ textAlign: "center" }}>
                Already have an account? <i className="buttonCreateAccount" onClick={handleLogin}>Login now!</i>
              </p>
            </div>
        </div>
      </div>
      <div className='right'>
        <div className="register-logo">
            <img src={logo_s} alt="Logo" style={{ width: 'auto', height: '80%' }} />
        </div>
      </div>
    </div>
    </div>
  );
}

export default Register;
