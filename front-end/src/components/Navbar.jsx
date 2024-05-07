// Navbar.jsx
import React from 'react';
import { NavLink } from 'react-router-dom'; 
import '../css/Navbar.css';
import logo from '../img/logo_s.png';

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul>
        <li>
          <NavLink exact to="/inicio" activeClassName="active">Início</NavLink>
        </li>
        <li>
          <NavLink to="/destino" activeClassName="active">Destino</NavLink>
        </li>
        <li>
          <NavLink to="/pacote" activeClassName="active">Pacote</NavLink>
        </li>
        <li>
          <NavLink to="/oferta" activeClassName="active">Oferta</NavLink>
        </li>
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
