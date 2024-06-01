import React, {useState, useEffect} from "react";
import { useNavigate } from "react-router-dom";
// import "../css/FlightReservedCard.css";
// import airlineLogo from "../img/TAP.png";

// const FlightReservedCard = ({ flight }) => {
// //   const navigate = useNavigate();
// //   const [selectedFlight, setSelectedFlight] = useState(null);

// //   const handleSelectFlight = (flight) => {
// //     setSelectedFlight(flight.id);
// //   };

// //   const handleBookFlight = () => {
// //     localStorage.setItem("selectedFlight", JSON.stringify(flight));
// //     navigate(`/flightCheckout/${flight.flightId}`);

// //     // const userId = localStorage.getItem("userId");
  
// //     // if (userId) {
// //     //   navigate("/Flightcheckout", null);
// //     //   localStorage.setItem("flightOutbound", flightOutbound["flightNumber"]);
    
// //     // } else {
// //     //   navigate("/login");
// //     // }
// //   };


// return (
//   <div class="containerFlightReserved">

//   <div class="infoFlightReserved">

//     <div class="titleFlightReserved">Flight ID: </div>

//     <div class="subtitleFlightReserved">Flight Date:</div>
//     <div class="subtitleFlightReserved">Airline: </div>
//     <div class="subtitleFlightReserved">Seat: </div>

//     <div class="subtitleFlightReserved"><br /></div>

//     <div class="flightFlightReserved">

//       <div class="flightFlightReserved-details">

//         <div class="flightFlightReserved-time">Departure Time</div>

//         <div class="flightFlightReserved-location">Departure City</div>

//       </div>

//       <div class="flightFlightReserved-duration">11h 05m duration </div>

//       <div class="flightFlightReserved-details">

//         <div class="flightFlightReserved-time">Arrival TIme</div>

//         <div class="flightFlightReserved-location">ARrival City</div>

//       </div>

//     </div>
//     <div class="subtitleFlightReserved"><br /></div>
//     <div class="subtitleFlightReserved"><br /></div>


//   </div>
//   <div class="infoFlightReserved">


//     <div class="titleFlightReserved">Reservation ID: </div>

//     <div class="subtitleFlightReserved">Reservation Date:</div>
//     <div class="subtitleFlightReserved">Total Price:</div>
//     <div class="subtitleFlightReserved"><br /></div>

//     <div class="subtitleFlightReserved"><b>Passenger Information</b></div>
//     <div class="subtitleFlightReserved">First Name:</div>
//     <div class="subtitleFlightReserved">Last Name:</div>
//     <div class="subtitleFlightReserved">Birthday Date:</div>
//     <div class="subtitleFlightReserved">Passaport Number:</div>
    
//   </div>

// </div>
// );
// };

// export default FlightReservedCard;


// import React, { useState, useEffect } from "react";
// import { useNavigate } from "react-router-dom";
// import "../css/FlightReservedCard.css";
// import airlineLogo from "../img/TAP.png";

// const FlightReservedCard = ({ flightId }) => {
//   const [flight, setFlight] = useState(null);
//   const [reservation, setReservation] = useState(null);

//   useEffect(() => {
//     // Fetch flight and reservation details based on flightId
//     const fetchFlightDetails = async () => {
//       try {
//         const flightResponse = await fetch(`/api/flights/${flightId}`);
//         const flightData = await flightResponse.json();
        
//         const reservationResponse = await fetch(`/api/reservations/${flightId}`);
//         const reservationData = await reservationResponse.json();

//         setFlight(flightData);
//         setReservation(reservationData);
//       } catch (error) {
//         console.error("Error fetching flight details:", error);
//       }
//     };

//     fetchFlightDetails();
//   }, [flightId]);

//   if (!flight || !reservation) {
//     return <div>Loading...</div>;
//   }

//   return (
//     <div className="containerFlightReserved">
//       <div className="infoFlightReserved">
//         <div className="titleFlightReserved">Flight ID: {flight.flightId}</div>
//         <div className="subtitleFlightReserved">Flight Date: {flight.date}</div>
//         <div className="subtitleFlightReserved">Airline: {flight.airline.airlineName}</div>
//         <div className="subtitleFlightReserved">Seat: {reservation.seat}</div>
//         <div className="subtitleFlightReserved"><br /></div>
//         <div className="flightFlightReserved">
//           <div className="flightFlightReserved-details">
//             <div className="flightFlightReserved-time">Departure Time: {flight.departureHour}</div>
//             <div className="flightFlightReserved-location">Departure City: {flight.departureCity}</div>
//           </div>
//           <div className="flightFlightReserved-duration">
//             Duration: {calculateDuration(flight.departureHour, flight.arrivalHour)}
//           </div>
//           <div className="flightFlightReserved-details">
//             <div className="flightFlightReserved-time">Arrival Time: {flight.arrivalHour}</div>
//             <div className="flightFlightReserved-location">Arrival City: {flight.arrivalCity}</div>
//           </div>
//         </div>
//         <div className="subtitleFlightReserved"><br /></div>
//         <div className="subtitleFlightReserved"><br /></div>
//       </div>
//       <div className="infoFlightReserved">
//         <div className="titleFlightReserved">Reservation ID: {reservation.reservationId}</div>
//         <div className="subtitleFlightReserved">Reservation Date: {reservation.reservationDate}</div>
//         <div className="subtitleFlightReserved">Total Price: €{reservation.totalPrice}</div>
//         <div className="subtitleFlightReserved"><br /></div>
//         <div className="subtitleFlightReserved"><b>Passenger Information</b></div>
//         <div className="subtitleFlightReserved">First Name: {reservation.passenger.firstName}</div>
//         <div className="subtitleFlightReserved">Last Name: {reservation.passenger.lastName}</div>
//         <div className="subtitleFlightReserved">Birthday Date: {reservation.passenger.birthDate}</div>
//         <div className="subtitleFlightReserved">Passport Number: {reservation.passenger.passportNumber}</div>
//       </div>
//     </div>
//   );
// };

// const calculateDuration = (departure, arrival) => {
//   const departureTime = new Date(`1970-01-01T${departure}Z`);
//   const arrivalTime = new Date(`1970-01-01T${arrival}Z`);
//   const diff = (arrivalTime - departureTime) / 1000 / 60;
//   const hours = Math.floor(diff / 60);
//   const minutes = diff % 60;
//   return `${hours}h ${minutes}m`;
// };

// export default FlightReservedCard;


import "../css/FlightReservedCard.css";
import airlineLogo from "../img/TAP.png";

const FlightReservedCard = ({ reservation }) => {
  const { flight, passenger } = reservation;

  return (
    <div className="containerFlightReserved">
      <div className="infoFlightReserved">
        <div className="titleFlightReserved">Flight ID: {flight.flightId}</div>
        <div className="subtitleFlightReserved">Flight Date: {flight.date}</div>
        <div className="subtitleFlightReserved">Airline: {flight.airlineCode}</div>
        <div className="subtitleFlightReserved">Seat: {reservation.seat}</div>
        <div className="subtitleFlightReserved"><br /></div>
        <div className="flightFlightReserved">
          <div className="flightFlightReserved-details">
            <div className="flightFlightReserved-time">Departure Time: {flight.departureHour}</div>
            <div className="flightFlightReserved-location">Departure City: {flight.departureCity}</div>
          </div>
          <div className="flightFlightReserved-duration">Duration: {flight.duration}</div>
          <div className="flightFlightReserved-details">
            <div className="flightFlightReserved-time">Arrival Time: {flight.arrivalHour}</div>
            <div className="flightFlightReserved-location">Arrival City: {flight.arrivalCity}</div>
          </div>
        </div>
        <div className="subtitleFlightReserved"><br /></div>
        <div className="subtitleFlightReserved"><br /></div>
      </div>
      <div className="infoFlightReserved">
        <div className="titleFlightReserved">Reservation ID: {reservation.reservationId}</div>
        <div className="subtitleFlightReserved">Reservation Date: {reservation.reservationDate}</div>
        <div className="subtitleFlightReserved">Total Price: {reservation.totalPrice}</div>
        <div className="subtitleFlightReserved"><br /></div>
        <div className="subtitleFlightReserved"><b>Passenger Information</b></div>
        <div className="subtitleFlightReserved">First Name: {passenger.firstName}</div>
        <div className="subtitleFlightReserved">Last Name: {passenger.lastName}</div>
        <div className="subtitleFlightReserved">Birthday Date: {passenger.birthDate}</div>
        <div className="subtitleFlightReserved">Passport Number: {passenger.passportNumber}</div>
      </div>
    </div>
  );
};

export default FlightReservedCard;
