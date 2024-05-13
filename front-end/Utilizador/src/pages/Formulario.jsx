import React, { useEffect, useState } from "react";

import Navbar from "../components/Navbar";
import CardFlights from "../components/CardFlights";
import "../css/Formulario.css";

const Formulario = () => {
  const [flightsData, setFlightsData] = useState([]);

  useEffect(() => {
  
  return (
      <div>
        <Navbar />
        <div className="flightsContainer">
          <h1 className="flightsTitle">Discover unique places</h1>
          <div className="containerFlight">
            {flightsData.length > 0 ? (
              flightsData.map((outboundFlight, index) => {
                return (
                  <CardFlights
                    outboundFlight={outboundFlight}
                    inboundFlight={null}
                    isRoundTrip={null}
                    flightOptions={null}
                    key={index}
                  />
                );
              })
            ) : (
              <p>No flights available</p>
            )}
          </div>
        </div>
      </div>
    );
  });
  }

export default Formulario;
