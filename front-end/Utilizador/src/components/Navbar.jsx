// Navbar.jsx
import React from 'react';
import { NavLink } from 'react-router-dom'; 
import '../css/Navbar.css';
import logo from '../img/logo_s.png';

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul>
        <li className="logo">
          <NavLink to="/" onClick={() => {}}>
            <img src={logo} alt="Logo" />
          </NavLink>

        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
