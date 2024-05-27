import React from 'react';
import '../css/Navbar.css';
import logo from '../img/logo_s.png';
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();

  const handleHome = () => {
    navigate("/");
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
        <span className="logo">
          <a onClick={handleHome}>
            <img src={logo} alt="Site Logo" />
          </a>
        </span>
        <div className="navItems">
          <a onClick={handleCheckIn}>Check-In</a>
          <a onClick={handleLuggage}>Luggage</a>

          
        </div>
        <span>Admin</span> 
        {/* aqui depois meter o nome do admin
         */}
         
      </div>
    </div>
  );
};

export default Navbar;
