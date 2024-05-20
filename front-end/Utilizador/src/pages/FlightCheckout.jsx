import React from 'react';
import "../css/flightcheckout.css";
import Navbar from '../components/Navbar';
import SeatSelection from '../components/SeatSelection';
import { useNavigate, useLocation } from 'react-router-dom'; 

const FlightCheckout = () => {
  const navigate = useNavigate();

  const [selectedSeat, setSelectedSeat] = React.useState(null);
  const location = useLocation();
  
  const seats = Array.from({ length: 50 }, (_, index) => {
    let status = "AVAILABLE";
    if ([1,2,3,4,5,6,7,8,9,10].includes(index + 1)) {
      status = "EMERGENCY_EXIT";
    } else if ([11,12,13,14,15,16,17,18,19,20,21,22,23,24,25].includes(index + 1)) {
      status = "PREFERRED";
    }
    return { number: index + 1, status };
  });
  

  const handleSeatSelect = (seatNumber) => {
    setSelectedSeat(seatNumber);
    console.log(`Seat ${seatNumber} selected!`);
  };

  const handlePayment = () => {
    navigate('/payment');
  };
  

  return (
    <div className="flight-checkout">
      <Navbar />
      <div className="flight-checkout-container">
        <div className="flight-details-section">
          <div className='left-side'>
            <h1 className="centered-title">Flight Details</h1>
           
              <img src={location.state.flightDetails.airlineLogo} alt="Airline Logo" />
              <h1>{location.state.flightDetails.airlineName}</h1>
              <p>{location.state.flightDetails.departureHour} - {location.state.flightDetails.arrivalHour}</p>
              <p>{location.state.flightDetails.airportCodeOrigin} to {location.state.flightDetails.airportCodeDestination}</p>
              <p>Duration: {location.state.flightDetails.duration}</p>
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
