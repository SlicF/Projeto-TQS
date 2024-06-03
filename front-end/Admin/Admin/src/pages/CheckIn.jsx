import React, { useState, useEffect } from 'react';
import Navbar from '../components/NavbarAdmin';
import '../css/administrator.css'
import { useNavigate } from "react-router-dom";
import fundo from '../img/fond.jpg';

const Administrator = () => {

    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const userId = localStorage.getItem("userId");
        setIsLoggedIn(!!userId);
      }, []);

    const handleHome = () => {
        navigate("/admin");
    };

    const handleCheckIn = () => {
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
                <form className="administrator-form" onSubmit={handleSubmit}>
                    <h2>Enter your reservation details</h2>
                    <label htmlFor="reservationCode">Reservation Code:</label>
                    <input
                        type="text"
                        id="reservationCode"
                        value={reservationCode}
                        onChange={(event) => setReservationCode(event.target.value)}
                    />
                    <br />
                    <label htmlFor="lastName">Last Name:</label>
                    <input
                        type="text"
                        id="lastName"
                        value={lastName}
                        onChange={(event) => setLastName(event.target.value)}
                    />
                    <br />
                    <label htmlFor="date">Date:</label>

                    <input
                        type="date"
                        id="date"
                        value={date}
                        onChange={(event) => setDate(event.target.value)}
                    />
                    <br />
                    <button type="submit" onClick={handleHome}>Continue</button>
                </form>
            ):(<div>
                <h1>ACCESS DENIED</h1>
            </div>
                )}
            </div>
        </div>
    );
};

export default Administrator;