// Navbar.jsx
import React from 'react';
import { NavLink } from 'react-router-dom'; 
import '../css/Navbar.css';
import logo from '../img/logo_s.png';
import Profile from '../pages/Profile.jsx';
import Login from '../pages/Login.jsx';
import Register from '../pages/Register.jsx';

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul>
        <li className="logo">
          <NavLink to="/" onClick={() => {}}>
            <img src={logo} alt="Logo" />
          </NavLink>
        </li>
        <li>
          <NavLink to="/profile" onClick={() => {}}>
            Profile
          </NavLink>
        </li>
        <li>
          <NavLink to="/" onClick={() => {}}>
            Sign In
          </NavLink>
        </li>
        <li>
          <NavLink to="/register" onClick={() => {}}>
            Sign Up 
          </NavLink>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
