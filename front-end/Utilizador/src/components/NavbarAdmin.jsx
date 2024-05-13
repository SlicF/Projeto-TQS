// Navbar.jsx
import React from 'react';
import '../css/Navbar.css';
import logo from '../img/logo_s.png';
import { useNavigate } from "react-router-dom";



const Navbar = () => {
  const navigate = useNavigate();


  const handleHome = () => {
    navigate("/adminHome");
  };

  const handleCheckIn = () => {
    navigate("/checkin");
  };

  const handleLuggage = () => {
    navigate("/luggage");
  };


  return (
    <div className="navbar">
      <div className="navContainer">
        <div className="navItems">
            <div>
              <a onClick={() => handleCheckIn("checkin")}>Check-In</a>
              <a onClick={() => handleLuggage("luggage")}>Luggage</a>
            </div>
        </div>
        <span className="logo">
          <a onClick={() => handleHome()}>
            <img src={logo} alt="Site Logo" />
          </a>
        </span>
      </div>
    </div>
  );
};


export default Navbar;
