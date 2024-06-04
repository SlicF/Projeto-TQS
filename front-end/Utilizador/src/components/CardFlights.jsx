/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */
import React, {useState, useEffect} from "react";
import { useNavigate } from "react-router-dom";
import "../css/cardFlights.css";
import airlineLogo from "../img/TAP.png";

const CardFlights = ({ flight }) => {
  const navigate = useNavigate();
  const [selectedFlight, setSelectedFlight] = useState(null);

  const handleSelectFlight = (flight) => {
    setSelectedFlight(flight.id);
  };

  const handleBookFlight = () => {
    localStorage.setItem("selectedFlight", JSON.stringify(flight));
    navigate(`/flightCheckout/${flight.flightId}`);

    // const userId = localStorage.getItem("userId");
  
    // if (userId) {
    //   navigate("/Flightcheckout", null);
    //   localStorage.setItem("flightOutbound", flightOutbound["flightNumber"]);
    
    // } else {
    //   navigate("/login");
    // }
  };


return (
  <div className={`flight-card ${selectedFlight === flight.flightId ? "selected" : ""}`}>
    <div className="flight-details">
      <div className="flight-logo">
        <img src={airlineLogo} alt="Airline Logo" style={{width:"10%", height:"10%"}}/>
      </div>
      <div className="flight-info">
        <div className="flight-time">
          <h1 style={{marginBottom:"5%"}}>{flight.airlineCode} --- {flight.airline.airlineName}</h1>
          <p>{flight.departureHour} - {flight.arrivalHour}</p>
        </div>
        <div className="flight-cities">
          <p>Departure City: {flight.departureCity}</p>
          <p>Arrival City: {flight.arrivalCity}</p>
        </div>
      </div>
    </div>
    <div className="flight-pricing-state">
      <p>{flight.price}€</p>
      <p style={{color:"red"}}>{flight.state}</p>
      <button className="book-flight-btn" onClick={handleBookFlight}>
        Book Flight
      </button>
    </div>
  </div>
);
};

export default CardFlights;
