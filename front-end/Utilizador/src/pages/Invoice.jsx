// import React from 'react';
// import "../css/Invoice.css";
// import Navbar from '../components/Navbar';

// const Invoice = () => {
    
//   const flightDetails = {
//     departure: "New York (JFK) at 10:00 AM",
//     arrival: "London (LHR) at 10:00 PM",
//     date: "2024-05-15",
//     airline: "AirExample",
//     flightNumber: "AE123",
//     code: "X112loa22"
//   };

//   const paymentInfo = {
//     cardName: "John Doe",
//     cardNumber: "1111 2222 3333 4444",
//     expirationDate: "12/24",
//     email: "johndoe@example.com",
//     code: "X112loa22"
//   };

//   return (
//     <div className="invoice">
//       <Navbar />
//       <div className="invoice-container">
//         <h1>Invoice for Your Flight</h1>
//         <div className="flight-details">
//           <h2>Flight Details</h2>
//           <p><strong>Departure:</strong> {flightDetails.departure}</p>
//           <p><strong>Arrival:</strong> {flightDetails.arrival}</p>
//           <p><strong>Date:</strong> {flightDetails.date}</p>
//           <p><strong>Airline:</strong> {flightDetails.airline}</p>
//           <p><strong>Flight Number:</strong> {flightDetails.flightNumber}</p>
//           <p><strong>Code:</strong> {flightDetails.code}</p>
//         </div>
       
//         <div className="payment-details">
//           <h2>Payment Information</h2>
//           <p><strong>Cardholder's Name:</strong> {paymentInfo.cardName}</p>
//           <p><strong>Card Number:</strong> {paymentInfo.cardNumber}</p>
//           <p><strong>Expiration Date:</strong> {paymentInfo.expirationDate}</p>
//           <p><strong>Email:</strong> {paymentInfo.email}</p>
//           </div>
//         </div>
//       </div>
//   );
// };

// export default Invoice;

import React from 'react';
import { useLocation } from 'react-router-dom';
import "../css/Invoice.css";
import Navbar from '../components/Navbar';

const Invoice = () => {
  const location = useLocation();
  const { flightDetails, selectedSeat } = location.state;

  return (
    <div className="invoice">
      <Navbar />
      <div className="invoice-container">
        <h1>Invoice for Your Flight</h1>
        <div className="flight-details">
          <h2>Flight Details</h2>
          <p><strong>Departure:</strong> {flightDetails.departureHour} - {flightDetails.airline_Code.airlineName}</p>
          <p><strong>Arrival:</strong> {flightDetails.arrivalHour}</p>
          <p><strong>Date:</strong> {flightDetails.date}</p>
          <p><strong>Airline:</strong> {flightDetails.airline_Code.airlineName}</p>
          <p><strong>Flight Number:</strong> {flightDetails.flightNumber}</p>
          <p><strong>Selected Seat:</strong> {selectedSeat ? `Seat ${selectedSeat}` : 'None'}</p>
        </div>
      </div>
    </div>
  );
};

export default Invoice;
