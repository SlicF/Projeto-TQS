import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import Navbar from '../components/Navbar';
import SeatSelection from '../components/SeatSelection';
import SeatsModal from '../components/SeatsModal';
import "../css/flightcheckout.css";
import Button from 'react-bootstrap/Button'; // npm install react-bootstrap bootstrap


const FlightCheckout = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [selectedFlight, setSelectedFlight] = useState(null);
  const [selectedSeat, setSelectedSeat] = useState(null);
  const [reservationId, setReservationId] = useState(null);
  const [seat, setSeat] = useState({
    seatId: '',
    seatNumber: '',
    flightId: '',
    flight: null  
  });
  const [modalShow, setModalShow] = useState(false);
  // const [selectedSeat, setSelectedSeat] = useState(null);
  const [passenger, setPassenger] = useState({
    passengerId: '',
    firstName: '',
    lastName: '',
    state: 'null',
    sex: '',
    birthDate: '',
    email: '',
    phoneNumber: '',
    passportNumber: '',
    postalCode: '',
    streetAddress: '',
    city: '',
    country: '',
    cardNumber: '',
    cardPIN: '',
  });

  const seats = Array.from({ length: 50 }, (_, index) => ({
    number: index + 1,
    status: index < 10 ? "EMERGENCY_EXIT" : index < 25 ? "PREFERRED" : "AVAILABLE"
  }));

  const handleSeatSelect = (seatNumber) => {
    setSelectedSeat(seatNumber);
    console.log(`Seat ${seatNumber} selected!`);
  };

  const generateRandomId = () => {
    const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    let result = '';
    for (let i = 0; i < 7; i++) {
      result += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return result;
  };

  const generateRandomSeatId = () => {
    const characters = "abcdefghijklmnopqrstuvwxyz0123456789";
    let result = '';
    for (let i = 0; i < 11; i++) {
      result += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return result;
  };

  const generateRandomSeatPrefix = () => {
    const seatPrefixes = ["AA", "AB", "AC", " BA", "BB", "BC", "CA", "CB", "CC"]; // adjust
    let seatPrefix = seatPrefixes[Math.floor(Math.random() * seatPrefixes.length)];
    return seatPrefix;
  };

  const generateRandomReservationId = () => {
    const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    let result = '';
    for (let i = 0; i < 11; i++) {
      result += characters.charAt(Math.floor(Math.random() * characters.length));
    }
    return result;
}

  // const handlePayment = () => {
  //   // Gerar IDs aleatórios para o assento e o passageiro
  //   const newSeatId = generateRandomSeatId();
  //   const newPassengerId = generateRandomId();
  
  //   // Atualizar o estado com os novos IDs
  //   const updatedSeat = {
  //    ...seat,
  //     seatId: newSeatId,
  //     seatNumber: 'AA' + selectedSeat,
  //     flightId: selectedFlight.flightId,
  //     flight: selectedFlight
  //   };
  //   setSeat(updatedSeat);
  //   localStorage.setItem('seat', JSON.stringify(updatedSeat));
  
  //   const updatedPassenger = {
  //    ...passenger,
  //     passengerId: newPassengerId
  //   };
  //   setPassenger(updatedPassenger);
  //   localStorage.setItem('passenger', JSON.stringify(updatedPassenger));
  
  //   // Chamar funções para armazenar o assento e o passageiro na base de dados
  //   Promise.all([
  //     fetch('http://localhost:8981/api/seats/createSeat', {
  //       method: 'POST',
  //       headers: {
  //         'Content-Type': 'application/json',
  //       },
  //       body: JSON.stringify(updatedSeat),
  //     }),
  //     fetch('http://localhost:8981/api/passengers/createPassenger', {
  //       method: 'POST',
  //       headers: {
  //         'Content-Type': 'application/json',
  //       },
  //       body: JSON.stringify(updatedPassenger),
  //     })
  //   ])
  //  .then(([response1, response2]) => {
  //     if (!response1.ok ||!response2.ok) {
  //       throw new Error('Failed to create seat or passenger');
  //     }
  //     return Promise.all([response1.json(), response2.json()]);
  //   })
  //  .then(([seatData, passengerData]) => {
  //     console.log('Seat and passenger created:', seatData, passengerData);
  //     // Redirecionar para a página de reserva com os detalhes do assento e do passageiro
  //     navigate('/reservation', { state: { seatDetails: seatData, passengerDetails: passengerData } });
  //   })
  //  .catch(error => {
  //     console.error('Error creating seat or passenger:', error);
  //   });
  // };

  const handlePassengerStore = (updatedPassenger, reservationId, seatDetails, flightDetails) => {
    // Save passengers data to the database here
    console.log("handle passenger store");
    console.log("passenger: ", JSON.stringify(updatedPassenger));
    fetch('http://localhost:8981/api/passengers/createPassenger', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(updatedPassenger),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to create passenger');
        }
        return response.json();
      })
      .then(data => {
        console.log('Passenger created:', data);
        navigate('/reservation', { state: { passengerId: data, passengerDetails: updatedPassenger, reservationId, seatDetails, flightDetails } });
      })
      .catch(error => {
        console.error('Error creating passenger:', error);
      });
  };

  const handleSeatStore = (updatedSeat) => {
    console.log("handle seat store");
    console.log("seat: ", JSON.stringify(updatedSeat));
    fetch('http://localhost:8981/api/seats/createSeat', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(updatedSeat),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to create seat');
        }
        return response.json();
      })
      .then(data => {
        console.log('Seat created:', data);
        //navigate('/reservation', { state: { seatDetails: data } });
      })
      .catch(error => {
        console.error('Error creating seat:', error);
      });
  };
  
  // useEffect(() => {
  //   const fetchFlightById = async (flightId) => {
  //     try {
  //       const response = await fetch(`http://localhost:8981/api/flights/flightCheckout/${flightId}`, {
  //         method: 'GET',
  //         headers: {
  //           'Content-Type': 'application/json',
  //         },
  //       });

  //       if (!response.ok) {
  //         throw new Error(`Failed to fetch flight: ${response.status}`);
  //       }
  //       setSelectedFlight(data);
  //     } catch (error) {
  //       console.error("Failed to fetch flight:", error);
  //     }
  //   };

  //   if (flight.flightId) {
  //     fetchFlightById(flight.flightId);
  //   }
  // }, [flight.flightId]);

  // if (!selectedFlight) {
  //   return <div>Loading...</div>;
  // }

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setPassenger(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handlePayment = () => {
    // seat
    const newSeatId = generateRandomSeatId();
    const newSeatNumber = generateRandomSeatPrefix() + selectedSeat;
    const updatedSeat = {
      ...seat,
      seatId: newSeatId,
      seatNumber: newSeatNumber,
      flightId: selectedFlight.flightId,
      flight: selectedFlight
    };
    setSeat(updatedSeat);
    localStorage.setItem('seat', JSON.stringify(updatedSeat));
    handleSeatStore(updatedSeat);
    console.log("add Seat");

    // passenger
    const newPassengerId = generateRandomId();
    const updatedPassenger = {
      ...passenger,
      passengerId: newPassengerId
    };
    setPassenger(updatedPassenger);
    localStorage.setItem('passenger', JSON.stringify(updatedPassenger));

    // reservation
    const reservationId = generateRandomReservationId();
    setReservationId(reservationId);
    console.log('reservationId:', reservationId);
    localStorage.setItem('reservationId', JSON.stringify(reservationId));

    handlePassengerStore(updatedPassenger, reservationId, updatedSeat, selectedFlight);
    console.log("add Passenger");
  };

  useEffect(() => {
    const selectedFlight = JSON.parse(localStorage.getItem('selectedFlight'));
    console.log("hereeeee");
    if (selectedFlight && selectedFlight.flightId) {
      // const { flightId, airlineCode, departureCity, arrivalCity, date, departureHour, arrivalHour, price, state, seatsNumber, airline} = selectedFlight;
      // const details = {
      //   "flightId": flightId,
      //   "airlineCode": airlineCode,
      //   "departureCity": departureCity,
      //   "arrivalCity": arrivalCity,
      //   "date": date,
      //   "departureHour": departureHour,
      //   "arrivalHour": arrivalHour,
      //   "price": price,
      //   "state": state,
      //   "seatsNumber": seatsNumber,
      //   "airline": airline
      // };

      // console.log("flight: ", selectedFlight);
      // console.log("flight flightId: ", selectedFlight.flightId);
      fetchFlightById(selectedFlight);
    }
  }, []);

  const fetchFlightById = async (selectedFlight) => {
    console.log("olaaaaa: ", JSON.stringify(selectedFlight));

    try {
      const response = await fetch(`http://localhost:8981/api/flights/flightCheckout/${selectedFlight.flightId}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
        // body: JSON.stringify(
        //   flightId,
        //   airlineCode,
        //   departureCity,
        //   arrivalCity,
        //   date,
        //   departureHour,
        //   arrivalHour,
        //   price,
        //   state,
        //   seatsNumber,
        //   airline
        // ),
      });

      if (!response.ok) {
        throw new Error(`Failed to fetch flights: ${response.status}`);
      }

      const data = await response.json();
      console.log("fetched flight: ", data);
      setSelectedFlight(data);

      // console.log("flights: ", JSON.stringify(selectedFlight));
    } catch (error) {
      console.error("Failed to fetch flights:", error);
    }
  };

  if (!selectedFlight) {
    return <div>Loading...</div>;
  }

  return (
    <div className="flight-checkout">
      <Navbar />
      <div className="flight-checkout-container">
        <div className="flight-details-section">
          <div className='left-side'>
            <h1 className="centered-title">Flight Details</h1>
            <p><strong>Preço:</strong> {selectedFlight.price}€ </p>
            <p><strong>Companhia Aérea:</strong> {selectedFlight.airlineCode} - {selectedFlight.airline.airlineName} </p>
            <p><strong>Data:</strong> {selectedFlight.date} </p>
            <p><strong>Horário de Voo:</strong> {selectedFlight.departureHour} - {selectedFlight.arrivalHour} </p>
            <p><strong>Cidade1 --- Cidade2:</strong> {selectedFlight.departureCity} --- {selectedFlight.arrivalCity} </p>
            <p><strong>Assento Selecionado:</strong> {selectedSeat ? `Seat ${selectedSeat}` : 'None'}</p>

            <Button onClick={() => setModalShow(true)}>Select seat</Button>
            <SeatsModal
              show={modalShow}
              onHide={() => setModalShow(false)}
              seats={seats}
              onSeatSelect={handleSeatSelect}
              selectedSeat={selectedSeat}
            />
          </div>

          <div className='right-side'>
            <h2 className="centered-title">Passenger Details</h2>
            <form>
              {/* <input type="text" name="passengerId" placeholder="Passenger ID" value={passengerData.passengerId} onChange={handleInputChange} required /> */}
              <input type="text" name="firstName" placeholder="First Name" value={passenger.firstName} onChange={handleInputChange} required />
              <input type="text" name="lastName" placeholder="Last Name" value={passenger.lastName} onChange={handleInputChange} required />
              {/* <input type="text" name="state" placeholder="State" value={passengerData.state} onChange={handleInputChange} required /> */}
              <input type="text" name="sex" placeholder="Sex" value={passenger.sex} onChange={handleInputChange} required />
              <input type="date" name="birthDate" placeholder="Birth Date" value={passenger.birthDate} onChange={handleInputChange} required />
              <input type="email" name="email" placeholder="Email" value={passenger.email} onChange={handleInputChange} required />
              <input type="text" name="phoneNumber" placeholder="Phone Number" value={passenger.phoneNumber} onChange={handleInputChange} required />
              <input type="text" name="passportNumber" placeholder="Passport Number" value={passenger.passportNumber} onChange={handleInputChange} required />
              <input type="text" name="postalCode" placeholder="Postal Code" value={passenger.postalCode} onChange={handleInputChange} required />
              <input type="text" name="streetAddress" placeholder="Street Address" value={passenger.streetAddress} onChange={handleInputChange} required />
              <input type="text" name="city" placeholder="City" value={passenger.city} onChange={handleInputChange} required />
              <input type="text" name="country" placeholder="Country" value={passenger.country} onChange={handleInputChange} required />
              <input type="text" name="cardNumber" placeholder="Card Number" value={passenger.cardNumber} onChange={handleInputChange} required />
              <input type="text" name="cardPIN" placeholder="Card PIN" value={passenger.cardPIN} onChange={handleInputChange} required />
            </form>

            {/* <button onClick={handlePayment}>Add Passenger</button> */}

            <div className="button-group">
              <button disabled={!passenger.firstName || !passenger.lastName} onClick={handlePayment}>Payment</button>
              <button className="cancel-button" onClick={() => navigate('/searchFlight')}>Cancel</button>
            </div>
          </div>
          
          { /* <div className='right-side'>
            <h2 className="centered-title">Select Your Seat</h2>
            <SeatSelection seats={seats} onSeatSelect={handleSeatSelect} selectedSeat={selectedSeat} />
          </div> */ }

          {/* <div className="passenger-list">
            <h2>Passengers</h2>
            <ul>
              {passengers.map((passenger, index) => (
                <li key={index}>{passenger.firstName} {passenger.lastName}</li>
              ))}
            </ul>
          </div> */}
        </div>
      </div>
    </div>
  );
};

export default FlightCheckout;



// import React, { useEffect, useState } from "react";
// import Navbar from "../components/Navbar";
// import CardFlights from "../components/CardFlights";
// import "../css/flight.css";

// const Flights = () => {

//   const userId = localStorage.getItem("userId");
//   const [flightsData, setFlightsData] = useState([]);

//   useEffect(() => {
//     const searchDetails = JSON.parse(localStorage.getItem('flightSearch'));
//     if (searchDetails) {
//       const { from, to, departureDate, passengers } = searchDetails;
//       const details = {
//         "departureCity": from,
//         "arrivalCity": to,
//         "date": departureDate
//       };
//       console.log("details: ", details);
//       fetchFlights(details);
//     }
//   }, []);

//   const fetchFlights = async (details) => {
//     console.log("olaaaaa: ", JSON.stringify(details));

//     try {
//       const response = await fetch('http://localhost:8981/api/flights/searchFlight', {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(details),
//       });

//       if (!response.ok) {
//         throw new Error(`Failed to fetch flights: ${response.status}`);
//       }

//       const data = await response.json();
//       console.log("data: ", data);
//       setFlightsData(data);
//     } catch (error) {
//       console.error("Failed to fetch flights:", error);
//     }
//   };

//   // if (userId) {
//   //   navigate("/flightCheckout", null);
//   //   localStorage.setItem("flight", flight["flightNumber"]);
  
//   // } else {
//   //   navigate("/login");
//   // }

//   return (
//       <div className="flightsContainer">
//       <Navbar />
//         <h1 className="flightsTitle">Discover unique places</h1>
//         <div className="containerFlight">
//           {flightsData.length > 0 ? (
//             flightsData.map((flight, index) => (
//               <CardFlights
//                 key={index}
//                 flight={flight}
//               />
//             ))
//           ) : (
//             <p>No flights available</p>
//           )}
//         </div>
//       </div>

//   );
// };

// export default Flights;

