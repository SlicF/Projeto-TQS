import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import Navbar from "../components/Navbar";
import CardFlights from "../components/CardFlights";
import "../css/Formulario.css";

const Formulario = () => {
  const [flightsData, setFlightsData] = useState(null);
  const [flights, setFlights] = useState([]);
  const location = useLocation();


  // get the flights data from the previous page
  useEffect(() => {
    console.log(location.state);
    if (location.state && location.state.flights) {
      setFlightsData(location.state.flights);
    }
  }, [location.state]);

  /* // fetch data from api with the params from the form 
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8980/api/searchFlight").then((res) => console.log(res));
        if (!response.ok) {
          throw new Error("Error fetching flights");
        }
        const data = await response.json();
        console.log(data);
        setFlightsData(data);
      } catch (error) {
        console.error("Error fetching flights", error);
      }
    };
    fetchData();
  }
    , []); */

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
