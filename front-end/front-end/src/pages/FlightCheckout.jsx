// import React from 'react';
// import { useNavigate } from 'react-router-dom'; // Importe useNavigate
// import "../css/flightcheckout.css";
// import Navbar from '../components/Navbar';

// const FlightCheckout = () => {
//   const navigate = useNavigate(); // Hook para navegação

//   const cardName = "John Doe";
//   const cardNumber = "1111 2222 3333 4444";
//   const email = "johndoe@example.com";
//   const cardExpirationDate = "12/24";

//   // Função para redirecionar para a página desejada
//   const handlePayment = () => {
//     alert("Payment Processed ");
//     navigate('/invoice');
//   };

//   return (
//     <div className="flight-checkout">
//       <Navbar />
//       <div className="flight-checkout-container">
//         <div className="flight-details-section">
//           <h2>Flight Details</h2>
//           <p><strong>Departure:</strong> New York (JFK) at 10:00 AM</p>
//           <p><strong>Arrival:</strong> London (LHR) at 10:00 PM</p>
//           <p><strong>Date:</strong> 2024-05-15</p>
//           <p><strong>Airline:</strong> AirExample</p>
//           <p><strong>Flight Number:</strong> AE123</p>
//         </div>

//         <div className="payment-info-section">
//           <h2>Payment Information</h2>
//           <div className="form-group">
//             <label htmlFor="cardName">Cardholder's Name:</label>
//             <input id="cardName" type="text" value={cardName} readOnly />
//           </div>
//           <div className="form-group">
//             <label htmlFor="cardNumber">Card Number:</label>
//             <input id="cardNumber" type="text" value={cardNumber} readOnly />
//           </div>
//           <div className="form-group">
//             <label htmlFor="cardExpirationDate">Expiration Date:</label>
//             <input id="cardExpirationDate" type="text" value={cardExpirationDate} readOnly />
//           </div>
//           <div className="form-group">
//             <label htmlFor="email">Email:</label>
//             <input id="email" type="email" value={email} readOnly />
//           </div>
//           <div className="button-group">
//             <button onClick={handlePayment}>Pay Now</button>
//             <button className="cancel-button" onClick={() => alert("Transaction Cancelled")}>Cancel</button>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default FlightCheckout;
import React from 'react';
import { useNavigate } from 'react-router-dom';
import "../css/flightcheckout.css";
import Navbar from '../components/Navbar';
import SeatSelection from '../components/SeatSelection';

const FlightCheckout = () => {
  const navigate = useNavigate();

  const seats = [
    { number: 1, status: "AVAILABLE" },
    { number: 2, status: "AVAILABLE" },
    { number: 3, status: "AVAILABLE" },
    { number: 4, status: "AVAILABLE" },
  ];

  const [selectedSeat, setSelectedSeat] = React.useState(null);

  const handleSeatSelect = (seatNumber) => {
    setSelectedSeat(seatNumber);
    console.log(`Seat ${seatNumber} selected!`);
  };

  const handlePayment = () => {
    navigate('/invoice');
  };

  return (
    <div className="flight-checkout">
      <Navbar />
      <div className="flight-checkout-container">
        <div className="flight-details-section">
          <div className='left-side'>
            <h1 className="centered-title">Flight Details</h1>
            <p><strong>Departure:</strong> New York (JFK) at 10:00 AM</p>
            <p><strong>Arrival:</strong> London (LHR) at 10:00 PM</p>
            <p><strong>Date:</strong> 2024-05-15</p>
            <p><strong>Airline:</strong> AirExample</p>
            <p><strong>Flight Number:</strong> AE123</p>
            <div className="button-group">
              <button onClick={handlePayment}>Pay Now</button>
              <button className="cancel-button">Cancel</button>
            </div>
          </div>
          
          <div className='right-side'>
            <h2 className="centered-title">Select Your Seat</h2>
            <SeatSelection seats={seats} onSeatSelect={handleSeatSelect} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default FlightCheckout;
