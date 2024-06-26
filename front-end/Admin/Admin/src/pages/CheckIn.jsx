/* eslint-disable no-unused-vars */
import React, { useState, useEffect } from 'react';
import Navbar from '../components/NavbarAdmin';
import '../css/administrator.css'
import { useNavigate } from "react-router-dom";
import fundo from '../img/fond.jpg';

const Administrator = () => {

    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [passengers, setPassengers] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const userId = localStorage.getItem("userId");
        setIsLoggedIn(!!userId);

      fetch('http://192.168.160.219:8981/api/passengers/passengers/null')
            .then(response => response.json())
            .then(data => setPassengers(data))
            .catch(error => console.error('Error fetching passengers:', error));
    }, []);

    const handleHome = () => {
        navigate("/admin");
    };

    const handleCheckIn = (passengerId) => {
        
        fetch(`http://192.168.160.219:8981/api/passengers/${passengerId}/check-in`, {
            method: 'PATCH'
        })
            .then(response => {
                if (response.ok) {
                    // update the passenger state locally
                    setPassengers(passengers.map(p => 
                        p.passengerId === passengerId ? { ...p, state: 'checked-in' } : p
                    ));

                    // alert(JSON.stringify(response));
                } else {
                    console.error('Error checking in passenger');
                }
            })
            .catch(error => console.error('Error:', error));


            console.log('Passenger checked in successfully!');
        };

    const [reservationCode, setReservationCode] = React.useState('');
    const [lastName, setLastName] = React.useState('');
    const [date, setDate] = React.useState('');


    const handleSubmit = (event) => {

        event.preventDefault();
        console.log('Check-in submitted:', { reservationCode, lastName });
    };

    return (
        <div className="register-container"
        style={{ backgroundImage: `url(${fundo})` }} 
        >
            <Navbar />  
            <div className="container">
            {isLoggedIn ? (
                // <form className="administrator-form" onSubmit={handleSubmit}>
                //     <h2>Enter your reservation details</h2>
                //     <label htmlFor="reservationCode">Reservation Code:</label>
                //     <input
                //         type="text"
                //         id="reservationCode"
                //         value={reservationCode}
                //         onChange={(event) => setReservationCode(event.target.value)}
                //     />
                //     <br />
                //     <label htmlFor="lastName">Last Name:</label>
                //     <input
                //         type="text"
                //         id="lastName"
                //         value={lastName}
                //         onChange={(event) => setLastName(event.target.value)}
                //     />
                //     <br />
                //     <label htmlFor="date">Date:</label>

                //     <input
                //         type="date"
                //         id="date"
                //         value={date}
                //         onChange={(event) => setDate(event.target.value)}
                //     />
                //     <br />
                //     <button type="submit" onClick={handleHome}>Continue</button>
                // </form>

                <div>
                <h2>Passengers with pending check-in</h2>
                <ul>
                    {passengers.filter(p => p.state === "null").map(passenger => (
                        <li key={passenger.passengerId}>
                            {passenger.firstName} {passenger.lastName}
                            <button onClick={() => handleCheckIn(passenger.passengerId)}>Check In</button>
                        </li>
                    ))}
                </ul>
            </div>
            ):(
            <div>
                <h1>ACCESS DENIED</h1>
            </div>
                )}
            </div>
        </div>
    );
};

export default Administrator;