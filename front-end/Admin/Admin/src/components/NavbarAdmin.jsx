import { React, useEffect, useState } from 'react';
import '../css/Navbar.css';
import logo from '../img/logo_s.png';
import { useNavigate } from "react-router-dom";

const Navbar = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

  const handleHome = () => {
    navigate("/admin");
  };

  const handleCheckIn = () => {
    navigate("/checkin");
  };

  const handleLuggage = () => {
    navigate("/luggage");
  };

  const handleLogin = () => {
    navigate("/");
  };

  const handleLogout = () => {
    localStorage.clear();
    setIsLoggedIn(false);
    navigate("/");
  };

  return (
    <div className="navbar">
      <div className="navContainer">
        <span className="logo">
          <a onClick={handleHome}>
            <img src={logo} alt="Site Logo" />
          </a>
        </span>
        {isLoggedIn ? (
          <div className="navItems">
            <a onClick={handleCheckIn}>Check-In</a>
            <a onClick={handleLuggage}>Luggage</a>
            <a onClick={handleLogout}>Logout</a>
          </div>) : (<div className="navItems">
            <a onClick={handleLogin}>Login</a>
          </div>)}
        {/* <span>Admin</span> 
        aqui depois meter o nome do admin
         */}

      </div>
    </div>
  );
};

export default Navbar;
