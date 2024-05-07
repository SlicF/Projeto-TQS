import React from 'react';
import Fundo from '../img/fundo.jpg';  
import casa from '../img/vv.png';
import chaves from '../img/vvv.png';
import Navbar from '../components/Navbar';
import "../css/MyComponent.css";
import { useNavigate } from 'react-router-dom';

function MyComponent() {
  const navigate = useNavigate();
  const handleSubmit = (event) => {
    event.preventDefault(); 
    navigate('/formulario'); 
  };

  return (
    <div className="container-index">
      <div className="background-image" style={{ backgroundImage: `url(${Fundo})` }}>
        <Navbar />
        <form className="search-area" onSubmit={handleSubmit}>
          <input className="search-input" type="text" placeholder="Onde" />
          <input className="search-input" type="text" placeholder="Destino" />
          <input className="search-input" type="text" placeholder="Partida" />
          <input className="search-input" type="text" placeholder="Chegada" />
          <button type="submit">Enter</button>
        </form>
      </div>
      <div className="places-area">
        <h1>LUGARES INDESQUECÍVEIS</h1>
        <div className="places">
          <div className="place">
            <img src={casa} alt="Casa da Avó" />
            <span>Casa da Avó</span>
          </div>
          <div className="place">
            <img src={chaves} alt="Chaves" />
            <span>Chaves</span>
          </div>
        </div>
      </div>
    </div>
  );
}

export default MyComponent;
