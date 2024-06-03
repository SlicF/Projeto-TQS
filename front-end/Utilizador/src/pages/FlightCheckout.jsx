import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import Navbar from '../components/Navbar';
import SeatsModal from '../components/SeatsModal';
import "../css/flightcheckout.css";
import Button from 'react-bootstrap/Button';  //npm install react-bootstrap bootstrap//

const FlightCheckout = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const navigate = useNavigate();
  const [selectedFlight, setSelectedFlight] = useState(null);
  const [selectedSeat, setSelectedSeat] = useState(null);
  const [seat, setSeat] = useState({
    seatId: '',
    seatNumber: '',
    flightId: '',
    flight: null
  });
  const [modalShow, setModalShow] = useState(false);
  const [passenger, setPassenger] = useState({
    userId: localStorage.getItem('userId'),
    firstName: '',
    lastName: '',
    state: '',
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

  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

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
    const seatPrefixes = ["AA", "AB", "AC", " BA", "BB", "BC", "CA", "CB", "CC"];
    let seatPrefix = seatPrefixes[Math.floor(Math.random() * seatPrefixes.length)];
    return seatPrefix;
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setPassenger(prevState => ({
      ...prevState,
      [name]: value
    }));
  };



  const handlePayment = async () => {
    try {
      const newSeatId = generateRandomSeatId();
      const newSeatNumber = generateRandomSeatPrefix() + selectedSeat;
      const updatedSeat = {
        seatId: newSeatId,
        seatNumber: newSeatNumber,
        flightId: selectedFlight.flightId,
        flight: selectedFlight
      };
  
      // Save the seat to the database
      createSeat(updatedSeat);
  
      // Create a new passenger object
      const newPassenger = {
        ...passenger
      };
  
      // Save the passenger to the database and get the passengerId
      const passengerId = await createPassenger(newPassenger);
  

      // Create a new reservation object
      const newReservation = {
        // reservationId: generateRandomId(),
        passengerId: passengerId.passengerId, // Use the passengerId returned from createPassenger
        flightId: selectedFlight.flightId,
        seat: newSeatNumber,
        totalPrice: selectedFlight.price, // Define the total price as needed
        reservationDate: new Date().toISOString().slice(0, 10), // Or any logic to set the reservation date
        nameCard: passenger.firstName + ' ' + passenger.lastName, // Or how you want to set the name on the card
        numberCard: passenger.cardNumber, // Or how you want to set the card number
        countryCard: passenger.country, // Or how you want to set the card country
      };
  
      // Save the reservation to the database
      createReservation(newReservation);
    } catch (error) {
      console.error('Error during payment:', error);
    }
  };
  

  const createSeat = (seatData) => {
    fetch('http://localhost:8981/api/seats/createSeat', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(seatData),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to create seat');
        }
        return response.json();
      })
      .then(data => {
        console.log('Seat created:', data);
      })
      .catch(error => {
        console.error('Error creating seat:', error);
      });
  };

  const createReservation = (reservationData) => {
    fetch('http://localhost:8981/api/reservations/createReservation', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(reservationData),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to create reservation');
        }
        return response.json();
      })
      .then(data => {
        console.log('Reservation created:', data);
        alert("RESERVATION CREATED");
        navigate('/searchFlight');
      })
      .catch(error => {
        console.error('Error creating reservation:', error);
      });
  };

  const createPassenger = (passengerData) => {
    return fetch('http://localhost:8981/api/passengers/createPassenger', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(passengerData),
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to create passenger');
        }
        return response.json();
      })
      .then(data => {
        console.log('Passenger created:', data);
        return data;  // Return the passengerId
      })
      .catch(error => {
        console.error('Error creating passenger:', error);
        throw error;
      });
  };
  

  useEffect(() => {
    const selectedFlight = JSON.parse(localStorage.getItem('selectedFlight'));
    if (selectedFlight && selectedFlight.flightId) {
      setSelectedFlight(selectedFlight);
    }
  }, []);

  useEffect(() => {
    const selectedFlight = JSON.parse(localStorage.getItem('selectedFlight'));
    if (selectedFlight && selectedFlight.flightId) {
      fetchFlightById(selectedFlight);
    }
  }, []);

  const fetchFlightById = async (selectedFlight) => {
    try {
      const response = await fetch(`http://localhost:8981/api/flights/flightCheckout/${selectedFlight.flightId}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        throw new Error(`Failed to fetch flights: ${response.status}`);
      }

      const data = await response.json();
      setSelectedFlight(data);

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
      {isLoggedIn? (
      <div className="flight-checkout-container">
        <div className="flight-details-section">
          <div className='left-side'>
            <h1 className="centered-title"><strong>Flight Details</strong></h1>
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
          <div className="separator"></div>
          <div className='right-side'>
            <h2 className="centered-title"><strong>Passenger Details  </strong></h2>
            <div className="form-container">
              <form>
                <div className="form-group">
                  <label htmlFor="firstName">First Name:</label>
                  <input type="text" id="firstName" name="firstName" placeholder="First Name" value={passenger.firstName} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="lastName">Last Name:</label>
                  <input type="text" id="lastName" name="lastName" placeholder="Last Name" value={passenger.lastName} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="sex">Sex:</label>
                  <input type="text" id="sex" name="sex" placeholder="Sex" value={passenger.sex} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="birthDate">Birth Date:</label>
                  <input type="date" id="birthDate" name="birthDate" placeholder="Birth Date" value={passenger.birthDate} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="email">Email:</label>
                  <input type="email" id="email" name="email" placeholder="Email" value={passenger.email} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="phoneNumber">Phone Number:</label>
                  <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value={passenger.phoneNumber} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="passportNumber">Passport Number:</label>
                  <input type="text" id="passportNumber" name="passportNumber" placeholder="Passport Number" value={passenger.passportNumber} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="postalCode">Postal Code:</label>
                  <input type="text" id="postalCode" name="postalCode" placeholder="Postal Code" value={passenger.postalCode} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="streetAddress">Street Address:</label>
                  <input type="text" id="streetAddress" name="streetAddress" placeholder="Street Address" value={passenger.streetAddress} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="city">City:</label>
                  <input type="text" id="city" name="city" placeholder="City" value={passenger.city} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="country">Country:</label>
                  <input type="text" id="country" name="country" placeholder="Country" value={passenger.country} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="cardNumber">Card Number:</label>
                  <input type="text" id="cardNumber" name="cardNumber" placeholder="Card Number" value={passenger.cardNumber} onChange={handleInputChange} required />
                </div>
                <div className="form-group">
                  <label htmlFor="cardPIN">Card PIN:</label>
                  <input type="text" id="cardPIN" name="cardPIN" placeholder="Card PIN" value={passenger.cardPIN} onChange={handleInputChange} required />
                </div>
              </form>
              <div className="button-group">
                <button disabled={!passenger.firstName || !passenger.lastName} onClick={handlePayment}>Finish</button>
                <button className="cancel-button" onClick={() => navigate('/searchFlight')}>Cancel</button>
              </div>
            </div>
          </div>
        </div>
      </div>):(
        <div><h1>ACCESS DENIED</h1></div>
      )}
    </div>
  );
};

export default FlightCheckout;
