import React from 'react';
import { useNavigate } from 'react-router-dom';
import "../css/flightcheckout.css";
import Navbar from '../components/Navbar';
import SeatSelection from '../components/SeatSelection';

const FlightCheckout = () => {
  const navigate = useNavigate();

  const seats = Array.from({ length: 100 }, (_, index) => {
    let status = "AVAILABLE";
    // Assumindo que os assentos de saída de emergência são os de número 9, 18, 27, 36.
    if ([9, 18, 27, 36].includes(index + 1)) {
      status = "EMERGENCY_EXIT";
    // Assumindo que os assentos preferenciais são os de número 1, 10, 19, 28, 37, 46, 55, 64, 73, 82, 91.
    } else if ([1, 10, 19, 28, 37, 46, 55, 64, 73, 82, 91].includes(index + 1)) {
      status = "PREFERRED";
    }
    return { number: index + 1, status };
  });
  

 
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
