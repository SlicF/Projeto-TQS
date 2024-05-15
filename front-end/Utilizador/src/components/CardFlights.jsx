import React from "react";
import { useNavigate } from "react-router-dom";
import "../css/cardFlights.css";
import frame from "../img/logo.png";
import Tap from "../img/TAP.png"

const CardFlights = () => {
  const navigate = useNavigate();

  

  const handleBookFlight = () => {
    navigate("/Flightcheckout");

  };

  return (
    <div className="flight-card">
      <div className="flight-details">
        <div className="flight-details1">
          <img className="img" src={Tap}></img>
          <div style={{ flex: 20, display: "flex", flexDirection: "row" }}>
            <div
              style={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "center",
                marginLeft: "1%",
                marginRight: "2%",
              }}
            >
              <p className="text">12:00</p>
              <p className="text">Origin Airport</p>
            </div>
            <div className="div">
              <div style={{ display: "flex", justifyContent: "space-between", marginTop: "0.5%" }}>
                <p className="text">Flight Number</p>
                <p className="text">Airline Name</p>
                <p className="text">2H:30M</p>
              </div>
            </div>
            <div style={{ display: "flex", flexDirection: "column", justifyContent: "center", marginLeft: "2%" }}>
              <p className="text">15:00</p>
              <p className="text">Destination Airport</p>
            </div>
          </div>
        </div>
      </div>
      <div className="Flightinfo">
        <div>
          <span>100€</span>
        </div>
        <button className="buttonFlightSearch" onClick={handleBookFlight}>
          <div className="text-wrapper">Select</div>
          <img className="svg" alt="Svg" src={frame} />
        </button>
      </div>
    </div>
  );
};

export default CardFlights;