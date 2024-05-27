import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import Navbar from '../components/Navbar';
import SeatSelection from '../components/SeatSelection';
import "../css/flightcheckout.css";

const FlightCheckout = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [selectedSeat, setSelectedSeat] = React.useState(null);

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
  

  return (
    <div className="flight-checkout">
      <Navbar />
      <div className="flight-checkout-container">
        <div className="flight-details-section">
          <div className='left-side'>
            <h1 className="centered-title">Flight Details</h1>
            <p><strong>Preço:</strong> €{location.state?.flightDetails?.price}</p>
            <p><strong>Companhia Aérea:</strong> {location.state?.flightDetails?.airline_Code?.airlineName}</p>
            <p><strong>Data:</strong> {location.state?.flightDetails?.arrivalHour}</p>
            <p><strong>Horário de Voo:</strong> {location.state?.flightDetails?.departureHour} - {location.state?.flightDetails?.arrivalHour}</p>
            <p><strong>Duração do Voo:</strong> {location.state?.flightDetails?.duration}</p>
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
