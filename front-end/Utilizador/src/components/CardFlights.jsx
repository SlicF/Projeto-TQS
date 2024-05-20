import React from "react";
import { useNavigate } from "react-router-dom";
import "../css/cardFlights.css";
import airlineLogo from "../img/TAP.png";

const CardFlights = ({ outboundFlight }) => {
  const navigate = useNavigate();

  const handleBookFlight = () => {
    navigate("/Flightcheckout", { state: { flightDetails: outboundFlight } });
  };

  return (
    <div className="flight-card">
      <div className="flight-details">
        <div className="flight-logo">
          <img src={airlineLogo} alt="Airline Logo" />
        </div>
        <div className="flight-info">
          <div className="flight-time">
            <p>{outboundFlight.departureTime} - {outboundFlight.arrivalTime}</p>
            <p>{outboundFlight.departureCity} to {outboundFlight.arrivalCity}</p>
          </div>
          <div className="flight-duration">
            <p>Duration: {outboundFlight.duration}</p>
          </div>
        </div>
      </div>
      <div className="flight-pricing">
        <p>€{outboundFlight.price}</p>
        <button className="book-flight-btn" onClick={handleBookFlight}>
          Book Flight
        </button>
      </div>
    </div>
  );
};

export default CardFlights;
