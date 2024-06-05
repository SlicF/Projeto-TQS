import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../components/Navbar";
import CardFlights from "../components/CardFlights";
import "../css/flight.css";

const Flights = () => {

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();
  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

  const userId = localStorage.getItem("userId");
  const [flightsData, setFlightsData] = useState([]);

  useEffect(() => {
    const searchDetails = JSON.parse(localStorage.getItem('flightSearch'));
    if (searchDetails) {
      const { from, to, departureDate, passengers } = searchDetails;
      const details = {
        "departureCity": from,
        "arrivalCity": to,
        "date": departureDate
      };
      console.log("details: ", details);
      fetchFlights(details);
    }
  }, []);

  const fetchFlights = async (details) => {
    console.log("olaaaaa: ", JSON.stringify(details));

    try {
      const response = await fetch('http://192.168.160.219:8981/api/flights/searchFlight', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(details),
      });

      if (!response.ok) {
        throw new Error(`Failed to fetch flights: ${response.status}`);
      }

      const data = await response.json();
      console.log("data: ", data);
      setFlightsData(data);
    } catch (error) {
      console.error("Failed to fetch flights:", error);
    }
  };

  useEffect(() => {
    console.log("Updated flightsData: ", flightsData);
  }, [flightsData]);

  // if (userId) {
  //   navigate("/flightCheckout", null);
  //   localStorage.setItem("flight", flight["flightNumber"]);

  // } else {
  //   navigate("/login");
  // }

  return (
    <div className="flightsContainer">
      <Navbar />
      <h1 className="flightsTitle">Discover unique places</h1>
      {isLoggedIn ? (
        <div className="containerFlight">

          {flightsData.length > 0 ? (
            flightsData.map((flight, index) => (
              <CardFlights
                key={index}
                flight={flight}
              />
            ))
          ) : (
            <p>No flights available</p>
          )}
        </div>) : (<div><h1>ACCESS DENIED</h1></div>)}
    </div>

  );
};

export default Flights;
