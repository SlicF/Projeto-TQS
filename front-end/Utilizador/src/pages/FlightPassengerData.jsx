// import React, { useState, useEffect } from 'react';
// import { useNavigate, useLocation } from 'react-router-dom';
// import Navbar from '../components/Navbar';
// import SeatSelection from '../components/SeatSelection';
// import "../css/flightcheckout.css";

// const FlightCheckout = () => {
//   const navigate = useNavigate();
//   const location = useLocation();
//   const [selectedFlight, setSelectedFlight] = useState(null);
//   const [selectedSeat, setSelectedSeat] = useState(null);

//   const seats = Array.from({ length: 50 }, (_, index) => ({
//     number: index + 1,
//     status: index < 10 ? "EMERGENCY_EXIT" : index < 25 ? "PREFERRED" : "AVAILABLE"
//   }));

//   const handleSeatSelect = (seatNumber) => {
//     setSelectedSeat(seatNumber);
//     console.log(`Seat ${seatNumber} selected!`);
//   };

//   const handlePayment = () => {
//     navigate('/payment');
//   };
  

//   // useEffect(() => {
//   //   const fetchFlightById = async (flightId) => {
//   //     try {
//   //       const response = await fetch(`http://localhost:8981/api/flights/flightCheckout/${flightId}`, {
//   //         method: 'GET',
//   //         headers: {
//   //           'Content-Type': 'application/json',
//   //         },
//   //       });

//   //       if (!response.ok) {
//   //         throw new Error(`Failed to fetch flight: ${response.status}`);
//   //       }

//   //       const data = await response.json();
//   //       console.log("oleee: ", data);
//   //       setSelectedFlight(data);
//   //     } catch (error) {
//   //       console.error("Failed to fetch flight:", error);
//   //     }
//   //   };

//   //   if (flight.flightId) {
//   //     fetchFlightById(flight.flightId);
//   //   }
//   // }, [flight.flightId]);

//   // if (!selectedFlight) {
//   //   return <div>Loading...</div>;
//   // }

//   useEffect(() => {
//     const selectedFlight = JSON.parse(localStorage.getItem('selectedFlight'));
//     console.log("hereeeee");
//     if (selectedFlight && selectedFlight.flightId) {
//       const { flightId, airlineCode, departureCity, arrivalCity, date, departureHour, arrivalHour, price, state, seatsNumber, airline} = selectedFlight;
//       // const details = {
//       //   "flightId": flightId,
//       //   "airlineCode": airlineCode,
//       //   "departureCity": departureCity,
//       //   "arrivalCity": arrivalCity,
//       //   "date": date,
//       //   "departureHour": departureHour,
//       //   "arrivalHour": arrivalHour,
//       //   "price": price,
//       //   "state": state,
//       //   "seatsNumber": seatsNumber,
//       //   "airline": airline
//       // };

//       console.log("flight: ", selectedFlight);
//       console.log("flight flightId: ", selectedFlight.flightId);
//       fetchFlightById(selectedFlight);
//     }
//   }, []);

//   const fetchFlightById = async (selectedFlight) => {
//     console.log("olaaaaa: ", JSON.stringify(selectedFlight));

//     try {
//       const response = await fetch(`http://localhost:8981/api/flights/flightCheckout/${selectedFlight.flightId}`, {
//         method: 'GET',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         // body: JSON.stringify(
//         //   flightId,
//         //   airlineCode,
//         //   departureCity,
//         //   arrivalCity,
//         //   date,
//         //   departureHour,
//         //   arrivalHour,
//         //   price,
//         //   state,
//         //   seatsNumber,
//         //   airline
//         // ),
//       });

//       if (!response.ok) {
//         throw new Error(`Failed to fetch flights: ${response.status}`);
//       }

//       const data = await response.json();
//       console.log("fetched flight: ", data);
//       setSelectedFlight(data);

//       // console.log("flights: ", JSON.stringify(selectedFlight));
//     } catch (error) {
//       console.error("Failed to fetch flights:", error);
//     }
//   };

//   if (!selectedFlight) {
//     return <div>Loading...</div>;
//   }

//   return (
//     <div className="flight-checkout">
//       <Navbar />
//       <div className="flight-checkout-container">
//         <div className="flight-details-section">
//           <div className='left-side'>
//             <h1 className="centered-title">Flight Details</h1>
//             <p><strong>Preço:</strong> {selectedFlight.price}€ </p>
//             <p><strong>Companhia Aérea:</strong> {selectedFlight.airlineCode} - {selectedFlight.airline.airlineName} </p>
//             <p><strong>Data:</strong> {selectedFlight.date} </p>
//             <p><strong>Horário de Voo:</strong> {selectedFlight.departureHour} - {selectedFlight.arrivalHour} </p>
//             <p><strong>Cidade1 ---> Cidade2:</strong> {selectedFlight.departureCity} ---> {selectedFlight.arrivalCity} </p>
//             {/* <p><strong>Assento Selecionado:</strong> {selectedSeat ? `Seat ${selectedSeat}` : 'None'}</p> */}

//             <button>Add passenger</button>

//             <div className="button-group">
//               <button onClick={handlePayment}>Pay Now</button>
//               <button className="cancel-button" onClick={() => navigate('/')}>Cancel</button>
//             </div>
//           </div>
//           <div className='right-side'>
//             <h2 className="centered-title">Select Your Seat</h2>
                       
//           <SeatSelection seats={seats} onSeatSelect={handleSeatSelect} selectedSeat={selectedSeat} />

//                 {/* <SeatSelection seats={seats} onSeatSelect={handleSeatSelect} selectedSeat={selectedSeat} /> */}
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default FlightCheckout;


