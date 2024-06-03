import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import Navbar from "../components/Navbar";
import CardFlights from "../components/CardFlights";
import "../css/Formulario.css";

const Formulario = () => {
  const [flightsData, setFlightsData] = useState(null);
  const [flights, setFlights] = useState([]);
  const location = useLocation();

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

  // get the flights data from the previous page
  useEffect(() => {
    console.log(location.state);
    if (location.state && location.state.flights) {
      setFlightsData(location.state.flights);
    }
  }, [location.state]);


  return (
    <div>
      <Navbar />
      {isLoggedIn ? (
        <div className="flightsContainer">
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
        </div>) : (
        <div><h1>ACCESS DENIED</h1></div>
      )}
    </div>
  );
};

export default Formulario;
