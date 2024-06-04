import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import "../css/Payment.css";
import Navbar from '../components/Navbar';

const Payment = () => {
  const navigate = useNavigate();
  const location = useLocation();

  // Retrieve flight details and selected seat from location state
  const { passengerId, passengerDetails, reservationId, seatDetails, flightDetails } = location.state || { passengerId: null, passengerDetails: null, reservationId:null, seatDetails: null, flightDetails: null };
  
  const updatedPassengerDetails = {
    ...passengerDetails,
     passengerId: passengerId
   };

  const [reservation, setReservation] = useState({
    reservationId: reservationId,
    passengerId: passengerId.passengerId,
    flightId: flightDetails.flightId,
    seat: seatDetails.seatNumber,
    totalPrice: flightDetails.price,
    reservationDate: flightDetails.date,
    nameCard: '',
    numberCard: '',
    expirationDateCard: '',
    countryCard: '',
    passenger: updatedPassengerDetails,
    flight: flightDetails
  });

  // const handleInputChange = (e) => {
  //   const { name, value } = e.target;
  //   setReservation(prevState => ({
  //     ...prevState,
  //     [name]: value
  //   }));
  // };

  const handleReservation = () => {
    const nameCard = document.getElementById('nameCard').value;
    const numberCard = document.getElementById('numberCard').value;
    const expirationDateCard = document.getElementById('expirationDateCard').value;
    const countryCard = document.getElementById('countryCard').value;

    const updatedReservation = {
      ...reservation,
       nameCard,
       numberCard,
       expirationDateCard,
       countryCard,
       passenger: {
        ...updatedPassengerDetails,
         passengerId: updatedPassengerDetails.passengerId.passengerId
       }
     };
   
    setReservation(updatedReservation);

    localStorage.setItem('reservation', JSON.stringify(updatedReservation));
    handleReservationStore(updatedReservation);
  };

  const handleReservationStore = (reservation) => {
    fetch('http://localhost:8981/api/reservations/createReservation', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(reservation),
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to create reservation');
      }
      return response.json();
    })
    .then(data => {
      console.log('Reservation created:', data);
      navigate('/reservation', { state: { passengerId: data, passengerDetails: updatedPassengerDetails, reservationId, seatDetails, flightDetails } });
    })
    .catch(error => {
      console.error('Error creating reservation:', error);
    });
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
                <label>Reservation ID</label>
                <input type="text" value={reservationId} readOnly />
              </div>
              <div>
                <label>Passenger ID</label>
                <input type="text" value={passengerId.passengerId} readOnly />
              </div>
              {/* <div>
                <label>Passenger Name</label>
                <input type="text" value={`${passengerDetails.firstName} ${passengerDetails.lastName}`} readOnly />
              </div>
              <div>
                <label>Flight ID</label>
                <input type="text" value={flightDetails.flightId} readOnly />
              </div>
              <div>
                <label>Seat</label>
                <input type="text" value={seatDetails.seatNumber} readOnly />
              </div>
              <div>
                <label>Total Price</label>
                <input type="text" value={`${flightDetails.price} €`} readOnly />
              </div>
              <div>
                <label>Reservation Date</label>
                <input type="text" value={flightDetails.date} readOnly />
              </div> */}
              <div>
                <label htmlFor="nameCard">Nome no cartão</label>
                <input type="text" id="nameCard" placeholder="Nome no cartão" />
              </div>
              <div>
                <label htmlFor="numberCard">Número do Cartão</label>
                <input type="text" id="numberCard" placeholder="Número do Cartão" />
              </div>
              <div>
                <label htmlFor="expirationDateCard">Validade do cartão</label>
                <input type="text" id="expirationDateCard" placeholder="mm-yyyy" />
              </div>
              <div>
                <label htmlFor="countryCard">País do cartão</label>
                <input type="text" id="countryCard" placeholder="País do cartão" />
              </div>
              <div className="button-group">
                <button onClick={handleReservation}>Pay</button>
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