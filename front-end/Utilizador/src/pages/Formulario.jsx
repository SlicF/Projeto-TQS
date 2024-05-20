import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import Navbar from "../components/Navbar";
import CardFlights from "../components/CardFlights";
import "../css/Formulario.css";

const Formulario = () => {
  const [flightsData, setFlightsData] = useState([]);
  const location = useLocation();  

  useEffect(() => {
    console.log(location.state); 
    if (location.state && location.state.flights) {
      setFlightsData(location.state.flights);
    }
  }, [location.state]);

  return (
    <div>
      <Navbar />
      <div className="flightsContainer">
        <h1 className="flightsTitle">Discover unique places</h1>
        <div className="containerFlight">
          {flightsData.length > 0 ? (
            flightsData.map((flight, index) => (
              <CardFlights
                outboundFlight={flight}
                key={flight.flightId} 

              />
            ))
          ) : (
            <p>No flights available</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Formulario;
