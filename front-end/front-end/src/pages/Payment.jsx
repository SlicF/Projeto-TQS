import React from 'react';
import { useNavigate } from 'react-router-dom';
import "../css/Payment.css";
import Navbar from '../components/Navbar';

const Payment = () => {
  const navigate = useNavigate();
  const [selectedSeat, setSelectedSeat] = React.useState(null);

  const handleSeatSelect = (seatNumber) => {
    setSelectedSeat(seatNumber);
    console.log(`Seat ${seatNumber} selected!`);
  };

  const handlePayment = () => {
    navigate('/invoice');
  };
  

  return (
    <div className="flights-checkout">
      <Navbar />
      <div className="flightsContainer">
        <div className="flight-details-section invoice-container">
          <div className='invoice'>
            <h1 className="centered-title">Payment</h1>
            <div className="payment-details">
              <p><strong>Voo:</strong> [Flight Number]</p>
              <p><strong>Origem:</strong> [Departure]</p>
              <p><strong>Destino:</strong> [Destination]</p>
              <p><strong>Data:</strong> [Date]</p>
              <p><strong>Horário:</strong> [Time]</p>
              <p><strong>Preço:</strong> [Price]</p>
              
              <input type="text" placeholder="Nome do Passageiro" />
              <input type="text" placeholder="Número do Cartão" />
              <input type="text" placeholder="Validade" />
              <input type="text" placeholder="CVV" />
              <input type="text" placeholder="CPF" />
              <input type="text" placeholder="Data de Nascimento" />
              <input type="text" placeholder="Número do Passaporte" />
              <input type="text" placeholder="Endereço" />
              <input type="text" placeholder="Número" />

              <div className="button-group">
                <button onClick={handlePayment}>Pay Now</button>
                <button className="cancel-button">Cancel</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Payment;
