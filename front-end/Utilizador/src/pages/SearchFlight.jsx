
import React, { useState } from 'react';
import Fundo from '../img/fundo.jpg';  
import Navbar from '../components/Navbar';
import "../css/SearchFlight.css";
import { useNavigate } from 'react-router-dom';

function SearchFlight() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    from: '',
    to: '',
    departureDate: '',
    arrivalDate: '',
    travelClass: 'economy',
    passengers: 1
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({ ...prevState, [name]: value }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await fetch('http://localhost:8980/api/flights/search', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      if (!response.ok) {
        throw new Error('Failed to fetch');
      }

      const responseData = await response.json();
      navigate('/formulario', { state: responseData });
    } catch (error) {
      console.error('Erro ao buscar voos:', error);
    }
  };

  return (
    <div className="container-index">
      <Navbar />
      <div className="background-image" style={{ backgroundImage: `url(${Fundo})` }}>
        <form className="search-area" onSubmit={handleSubmit}>
          <input name="from" value={formData.from} onChange={handleInputChange} className="search-input" type="text" placeholder="From" />
          <input name="to" value={formData.to} onChange={handleInputChange} className="search-input" type="text" placeholder="To" />
          <input name="departureDate" value={formData.departureDate} onChange={handleInputChange} className="search-input" type="date" placeholder="Departure" />
          <input name="arrivalDate" value={formData.arrivalDate} onChange={handleInputChange} className="search-input" type="date" placeholder="Arrival" />
          <select name="travelClass" value={formData.travelClass} onChange={handleInputChange} className="search-input">
            <option value="economy">Economy Class</option>
            <option value="first">First Class</option>
            <option value="second">Second Class</option>
          </select>
          <input name="passengers" value={formData.passengers} onChange={handleInputChange} className="search-input" type="number" min="1" placeholder="Number of Passengers" />
          <button type="submit">Enter</button>
        </form>
      </div>
    </div>
  );
}

export default SearchFlight;