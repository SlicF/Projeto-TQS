/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from 'react';
import Flight from '../components/Flight.jsx';
import FlightAlterState from '../components/FlightAlterState.jsx';
import '../css/AirportControl.css';

const AirportControl = () => {
  const [flights, setFlights] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8981/api/flights/flights')
      .then(response => response.json())
      .then(data => {
        // Ordena os voos por hora de partida
        const sortedFlights = data.sort((a, b) => a.departureHour.localeCompare(b.departureHour));

        // Obtém a hora atual
        const currentHour = new Date().toISOString().slice(11, 16);

        // Filtra os voos que ocorrem após a hora atual
        const filteredFlights = sortedFlights.filter(flight => flight.departureHour > currentHour);

        const limitedFlights = filteredFlights.slice(0, 18);

        setFlights(limitedFlights);
      })
      .catch(error => console.error('Error fetching flights:', error));
  }, []);

  const getRandomIntBetween1And10 = () => {
    return Math.floor(Math.random() * 10) + 1;
  };

  return (
    <div className="airport-container">
      <header className="header">
        <h1 className="Title-Viagar">NEXT FLIGHTS</h1>
      </header>
      <div className="flights-container">
        <div className="flight-header">
          <span>Airline</span>
          <span>Flight ID</span>
          <span>Destiny</span>
          <span>Departure Hour</span>
          <span>Gate</span>
        </div>
        {flights.map((flight, index) => (
          flight.state === "OK" ? (
            <Flight 
              key={index}
              airline={flight.airlineCode}  
              flightNumber={flight.flightId}  
              destination={flight.arrivalCity}
              departureTime={flight.departureHour}
              gate={getRandomIntBetween1And10()}  
            />
          ) : (
            <FlightAlterState
              key={index}
              airline={flight.airlineCode}  
              flightNumber={flight.flightId}
              destination={flight.arrivalCity}
              departureTime={flight.departureHour}
              state={flight.state}
            />
          )
        ))}
      </div>
    </div>
  );
};

export default AirportControl;