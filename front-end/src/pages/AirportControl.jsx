// AirportControl.jsx
import React from 'react';
import Flight from '../components/Flight.jsx';
import '../css/AirportControl.css'; 

import { useNavigate } from 'react-router-dom';

const AirportControl = () => {
  const flights = [
    { flightNumber: 'TP1219', destination: 'Braga', departureTime: '12:34', gate: '0' },
    { flightNumber: 'TP1220', destination: 'Porto', departureTime: '13:34', gate: '1' },
    { flightNumber: 'TP1221', destination: 'Lisboa', departureTime: '14:34', gate: '2' },
    { flightNumber: 'TP1222', destination: 'Faro', departureTime: '15:34', gate: '3' },
    { flightNumber: 'TP1223', destination: 'Paris', departureTime: '16:34', gate: '4' },
    { flightNumber: 'TP1224', destination: 'Londres', departureTime: '17:34', gate: '5' },
    
  ];

  return (
    <div className="airport-container">
      <header className="header">
        <h1 className="Title-Viagar">VIAGAR</h1>
      </header>
      <div className="flights-container">
        <div className="flight-header">
          <span>Companhia</span>
          <span>Voo</span>
          <span>Destino</span>
          <span>Saída</span>
          <span>Portão</span>
        </div>
        {flights.map((flight, index) => (
          <Flight 
            key={index}
            flightNumber={flight.flightNumber}
            destination={flight.destination}
            departureTime={flight.departureTime}
            gate={flight.gate}
          />
        ))}
      </div>
    </div>
  );
};

export default AirportControl;
