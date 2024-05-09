import React from "react";
import Navbar from "../components/Navbar";
import CardFlights from "../components/CardFlights";
import "../css/flight.css";

const Flights = () => {
  // Mock flights data
  const flightsData = [
    {
      id: 1,
      airline_Code: { airlineICAO: "ABC", airlineName: "Airline 1" },
      departureHour: "12:00",
      airportCodeOrigin: "Origin",
      flightNumber: "ABC123",
      duration: "2:00",
      arrivalHour: "15:30",
      airportCodeDestination: "Destination",
      price: 203
    },
    {
      id: 2,
      airline_Code: { airlineICAO: "DEF", airlineName: "Airline 2" },
      departureHour: "10:00",
      airportCodeOrigin: "Origin",
      flightNumber: "DEF456",
      duration: "3:00",
      arrivalHour: "17:00",
      airportCodeDestination: "Destination",
      price: 112
    },
    {
      id: 3,
      airline_Code: { airlineICAO: "DEF", airlineName: "Airline 2" },
      departureHour: "14:00",
      airportCodeOrigin: "Origin",
      flightNumber: "DEF456",
      duration: "3:00",
      arrivalHour: "17:00",
      airportCodeDestination: "Destination",
      price: 88
    },
    {
      id: 4,
      airline_Code: { airlineICAO: "DEF", airlineName: "Airline 2" },
      departureHour: "14:00",
      airportCodeOrigin: "Origin",
      flightNumber: "DEF456",
      duration: "3:00",
      arrivalHour: "17:00",
      airportCodeDestination: "Destination",
      price: 678
    },
    {
      id: 5,
      airline_Code: { airlineICAO: "DEF", airlineName: "Airline 2" },
      departureHour: "14:00",
      airportCodeOrigin: "Origin",
      flightNumber: "DEF456",
      duration: "3:00",
      arrivalHour: "17:00",
      airportCodeDestination: "Destination",
      price: 678
    },
    {
      id: 6,
      airline_Code: { airlineICAO: "DEF", airlineName: "Airline 2" },
      departureHour: "14:00",
      airportCodeOrigin: "Origin",
      flightNumber: "DEF456",
      duration: "3:00",
      arrivalHour: "17:00",
      airportCodeDestination: "Destination",
      price: 678
    }



  ];

  return (
      <div className="flightsContainer">
      <Navbar />
        <h1 className="flightsTitle">Discover unique places</h1>
        <div className="containerFlight">
          {flightsData.length > 0 ? (
            flightsData.map((flight, index) => (
              <CardFlights
                key={index}
                outboundFlight={flight}
                inboundFlight={null}
                isRoundTrip={null}
                flightOptions={null}
              />
            ))
          ) : (
            <p>No flights available</p>
          )}
        </div>
      </div>

  );
};

export default Flights;
