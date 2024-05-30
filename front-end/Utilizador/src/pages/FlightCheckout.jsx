import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import Navbar from '../components/Navbar';
import SeatSelection from '../components/SeatSelection';
import "../css/flightcheckout.css";

const FlightCheckout = ({flight}) => {
  const navigate = useNavigate();
  const location = useLocation();
  const [selectedFlight, setSelectedFlight] = useState(null);
  const [selectedSeat, setSelectedSeat] = useState(null);

  const seats = Array.from({ length: 50 }, (_, index) => ({
    number: index + 1,
    status: index < 10 ? "EMERGENCY_EXIT" : index < 25 ? "PREFERRED" : "AVAILABLE"
  }));

  const handleSeatSelect = (seatNumber) => {
    setSelectedSeat(seatNumber);
    console.log(`Seat ${seatNumber} selected!`);
  };

  const handlePayment = () => {
    navigate('/payment');
  };
  
  // useEffect(() => {
  //   const fetchFlightById = async (flightId) => {
  //     try {
  //       const response = await fetch(`http://localhost:8981/api/flights/flightCheckout/${flightId}`, {
  //         method: 'GET',
  //         headers: {
  //           'Content-Type': 'application/json',
  //         },
  //       });

  //       if (!response.ok) {
  //         throw new Error(`Failed to fetch flight: ${response.status}`);
  //       }

  //       const data = await response.json();
  //       console.log("oleee: ", data);
  //       setSelectedFlight(data);
  //     } catch (error) {
  //       console.error("Failed to fetch flight:", error);
  //     }
  //   };

  //   if (flight.flightId) {
  //     fetchFlightById(flight.flightId);
  //   }
  // }, [flight.flightId]);

  // if (!selectedFlight) {
  //   return <div>Loading...</div>;
  // }

  useEffect(() => {
    const flight = JSON.parse(localStorage.getItem('selectedFlight'));
    if (flight) {
      const { flightId, airlineCode, departureCity, arrivalCity, date, departureHour, arrivalHour, price, state, seatsNumber, airline} = flight;
      const details = {
        "flightId": flightId,
        "airlineCode": airlineCode,
        "departureCity": departureCity,
        "arrivalCity": arrivalCity,
        "date": date,
        "departureHour": departureHour,
        "arrivalHour": arrivalHour,
        "price": price,
        "state": state,
        "seatsNumber": seatsNumber,
        "airline": airline
      };
      console.log("details: ", details);
      fetchFlightById(details);
    }
  }, []);

  const fetchFlightById = async (details) => {
    console.log("olaaaaa: ", JSON.stringify(details));

    try {
      const response = await fetch('http://localhost:8981/api/flights/flightCheckout/${details.flightId}', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
        // body: JSON.stringify(
        //   flightId,
        //   airlineCode,
        //   departureCity,
        //   arrivalCity,
        //   date,
        //   departureHour,
        //   arrivalHour,
        //   price,
        //   state,
        //   seatsNumber,
        //   airline
        // ),
      });

      if (!response.ok) {
        throw new Error(`Failed to fetch flights: ${response.status}`);
      }

      const data = await response.json();
      console.log("data: ", data);
      setSelectedFlight(data);

      console.log("flights: ", JSON.stringify(selectedFlight));
    } catch (error) {
      console.error("Failed to fetch flights:", error);
    }
  };

  return (
    <div className="flight-checkout">
      <Navbar />
      <div className="flight-checkout-container">
        <div className="flight-details-section">
          <div className='left-side'>
            <h1 className="centered-title">Flight Details</h1>
            <p><strong>Preço:</strong> {details.price}€ </p>
            <p><strong>Companhia Aérea:</strong> {details.airlineCode} - {details.airline.airlineName} </p>
            <p><strong>Data:</strong> 06h55 </p>
            <p><strong>Horário de Voo:</strong> 08h45 </p>
            <p><strong>Duração do Voo:</strong> 1h50 </p>
            <p><strong>Assento Selecionado:</strong> {selectedSeat ? `Seat ${selectedSeat}` : 'None'}</p>
            <div className="button-group">
              <button onClick={handlePayment}>Pay Now</button>
              <button className="cancel-button" onClick={() => navigate('/')}>Cancel</button>
            </div>
          </div>
          <div className='right-side'>
            <h2 className="centered-title">Select Your Seat</h2>
            <SeatSelection seats={seats} onSeatSelect={handleSeatSelect} selectedSeat={selectedSeat} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default FlightCheckout;



// import React, { useEffect, useState } from "react";
// import Navbar from "../components/Navbar";
// import CardFlights from "../components/CardFlights";
// import "../css/flight.css";

// const Flights = () => {

//   const userId = localStorage.getItem("userId");
//   const [flightsData, setFlightsData] = useState([]);

//   useEffect(() => {
//     const searchDetails = JSON.parse(localStorage.getItem('flightSearch'));
//     if (searchDetails) {
//       const { from, to, departureDate, passengers } = searchDetails;
//       const details = {
//         "departureCity": from,
//         "arrivalCity": to,
//         "date": departureDate
//       };
//       console.log("details: ", details);
//       fetchFlights(details);
//     }
//   }, []);

//   const fetchFlights = async (details) => {
//     console.log("olaaaaa: ", JSON.stringify(details));

//     try {
//       const response = await fetch('http://localhost:8981/api/flights/searchFlight', {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(details),
//       });

//       if (!response.ok) {
//         throw new Error(`Failed to fetch flights: ${response.status}`);
//       }

//       const data = await response.json();
//       console.log("data: ", data);
//       setFlightsData(data);
//     } catch (error) {
//       console.error("Failed to fetch flights:", error);
//     }
//   };

//   // if (userId) {
//   //   navigate("/flightCheckout", null);
//   //   localStorage.setItem("flight", flight["flightNumber"]);
  
//   // } else {
//   //   navigate("/login");
//   // }

//   return (
//       <div className="flightsContainer">
//       <Navbar />
//         <h1 className="flightsTitle">Discover unique places</h1>
//         <div className="containerFlight">
//           {flightsData.length > 0 ? (
//             flightsData.map((flight, index) => (
//               <CardFlights
//                 key={index}
//                 flight={flight}
//               />
//             ))
//           ) : (
//             <p>No flights available</p>
//           )}
//         </div>
//       </div>

//   );
// };

// export default Flights;

