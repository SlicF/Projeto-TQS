// import React from 'react';
// import { useNavigate } from 'react-router-dom';
// import "../css/Payment.css";
// import Navbar from '../components/Navbar';

// const Payment = () => {
//   const navigate = useNavigate();
//   const [selectedSeat, setSelectedSeat] = React.useState(null);

//   const handleSeatSelect = (seatNumber) => {
//     setSelectedSeat(seatNumber);
//     console.log(`Seat ${seatNumber} selected!`);
//   };

//   const handlePayment = () => {
//     navigate('/invoice', {
//       state: {
//         flightDetails: flightDetails,
//         selectedSeat: selectedSeat
//       }
//     });
//   };

//   return (
//     <div className="flights-checkout">
//       <Navbar />
//       <div className="flightsContainer">
//         <div className="flight-details-section invoice-container">
//           <div className='invoice'>
//             <h1 className="centered-title">Payment</h1>
//             <div className="payment-details">
//               <div>
//               <label htmlFor="passengerName">Nome do Passageiro</label>
//               <input type="text" id="passengerName" placeholder="Nome do Passageiro" />
//               </div>
//               <div>
//               <label htmlFor="cardNumber">Número do Cartão</label>
//               <input type="text" id="cardNumber" placeholder="Número do Cartão" />
//               </div>
//               <div>
//               <label htmlFor="expiration">Validade</label>
//               <input type="text" id="expiration" placeholder="Validade" />
//               </div>

//               <div>
//               <label htmlFor="cvv">CVV</label>
//               <input type="text" id="cvv" placeholder="CVV" />
//               </div>
//               <div>
//               <label htmlFor="cpf">CPF</label>
//               <input type="text" id="cpf" placeholder="CPF" />
//               </div>
//               <div>
//               <label htmlFor="dob">Data de Nascimento</label>
//               <input type="text" id="dob" placeholder="Data de Nascimento" />
//               </div>
//               <div>
//               <label htmlFor="passportNumber">Número do Passaporte</label>
//               <input type="text" id="passportNumber" placeholder="Número do Passaporte" />
//               </div> 
//               <div>
//               <label htmlFor="address">Endereço</label>
//               <input type="text" id="address" placeholder="Endereço" />
//               </div> 
//               <div>
//               <label htmlFor="addressNumber">Número</label>
//               <input type="text" id="addressNumber" placeholder="Número" />
//               </div>
//               <div className="button-group">
//                 <button onClick={handlePayment}>Pagar Agora</button>
//                 <button className="cancel-button">Cancelar</button>
//               </div>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Payment;

import React from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import "../css/Payment.css";
import Navbar from '../components/Navbar';

const Payment = () => {
  const navigate = useNavigate();
  const location = useLocation();

  // Retrieve flight details and selected seat from location state
  const { flightDetails, selectedSeat } = location.state || { flightDetails: null, selectedSeat: null };

  const handlePayment = async () => {
    const paymentData = {
      cardNumber: document.getElementById('cardNumber').value,
      cvv: document.getElementById('cvv').value,
      expirationDate: document.getElementById('expiration').value,
      passengerName: document.getElementById('passengerName').value,
      cpf: document.getElementById('cpf').value,
    };
  
    try {
      const response = await fetch('http://localhost:8980/api/reservations/createReservation', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(paymentData),
      });
  
      if (response.ok) {
        const responseData = await response.json();
        alert('Payment successful');
        navigate('/invoice', {
          state: {
            flightDetails: flightDetails,
            selectedSeat: selectedSeat
          }
        });
      } else {
        const errorData = await response.json();
        alert(`Payment failed: ${errorData.message}`);
      }
    } catch (error) {
      alert('Failed to connect to the server. Please check your connection and try again.');
      console.error('Failed to fetch:', error);
    }
  };
  

  return (
    <div className="flights-checkout">
      <Navbar />
      <div className="flightsContainer">
        <div className="flight-details-section invoice-container">
          <div className='invoice'>
            <h1 className="centered-title">Payment</h1>
            <div className="payment-details">
              <div>
                <label htmlFor="passengerName">Nome do Passageiro</label>
                <input type="text" id="passengerName" placeholder="Nome do Passageiro" />
              </div>
              <div>
                <label htmlFor="cardNumber">Número do Cartão</label>
                <input type="text" id="cardNumber" placeholder="Número do Cartão" />
              </div>
              <div>
                <label htmlFor="expiration">Validade</label>
                <input type="text" id="expiration" placeholder="Validade" />
              </div>
              <div>
                <label htmlFor="cvv">CVV</label>
                <input type="text" id="cvv" placeholder="CVV" />
              </div>
              <div>
                <label htmlFor="cpf">CPF</label>
                <input type="text" id="cpf" placeholder="CPF" />
              </div>
              <div>
                <label htmlFor="dob">Data de Nascimento</label>
                <input type="text" id="dob" placeholder="Data de Nascimento" />
              </div>
              <div>
                <label htmlFor="passportNumber">Número do Passaporte</label>
                <input type="text" id="passportNumber" placeholder="Número do Passaporte" />
              </div>
              <div>
                <label htmlFor="address">Endereço</label>
                <input type="text" id="address" placeholder="Endereço" />
              </div>
              <div>
                <label htmlFor="addressNumber">Número</label>
                <input type="text" id="addressNumber" placeholder="Número" />
              </div>
              <div className="button-group">
                <button onClick={handlePayment}>Pagar Agora</button>
                <button className="cancel-button">Cancelar</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Payment;
