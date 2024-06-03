import React, { useState, useEffect } from 'react';
import Fundo from '../img/fundo.jpg';
import Navbar from '../components/Navbar';
import "../css/SearchFlight.css";
import { useNavigate } from 'react-router-dom';
import FlightsSearch from "../components/FlightSearch";

function SearchFlight() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    from: '',
    to: '',
    departureDate: '',
    travelClass: 'economy',
    passengers: 1
  });

  const flightsData = location.state?.flightsData;

  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({ ...prevState, [name]: value }));
  };

  const fetchFlightData = async (flightNumber) => {
    flightNumber.preventDefault();

    // const { from: departureCity, to: arrivalCity, departureDate: date } = formData;

    try {
      const response = await fetch('http://localhost:8981/api/flights/flightCheckout/${flightId}', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          departureCity,
          arrivalCity,
          date
        }),
      });

      if (!response.ok) {
        throw new Error('Failed to fetch flights: ' + response.statusText);
      }

      const data = await response.json();
      console.log('Flights found:', data);

      // navigate('/formulario', { state: { flights: data } });

      return data;
    } catch (error) {
      console.error('Failed to fetch flights:', error);
    }
  };

  return (
    <div className="container-index">
      <Navbar />


      {isLoggedIn ? (
      <div className="containerSearchFlight" style={{ alignItems: "start" }}>
        <FlightsSearch />
      </div>
      ) : (
        <div>
          <h1>ACCESS DENIED</h1>
        </div>
      )}  
    </div>

    /* <div className="background-image" style={{ backgroundImage: `url(${Fundo})` }}>
      <form className="search-area" onSubmit={fetchFlightData}>
        <input name="from" value={formData.from} onChange={handleInputChange} className="search-input" type="text" placeholder="From" />
        <input name="to" value={formData.to} onChange={handleInputChange} className="search-input" type="text" placeholder="To" />
        <input name="departureDate" value={formData.departureDate} onChange={handleInputChange} className="search-input" type="date" placeholder="Departure" />
        <select name="travelClass" value={formData.travelClass} onChange={handleInputChange} className="search-input">
          <option value="economy">Economy Class</option>
          <option value="first">First Class</option>
          <option value="second">Second Class</option>
        </select>
        <input name="passengers" value={formData.passengers} onChange={handleInputChange} className="search-input" type="number" min="1" placeholder="Number of Passengers" />
        <button type="submit">Enter</button>
      </form>
    </div> */
  );
}

export default SearchFlight;
