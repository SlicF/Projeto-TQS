/* eslint-disable no-undef */
/* eslint-disable no-unused-vars */
import React, { useState, useEffect } from 'react';
import Navbar from '../components/NavbarAdmin';
import '../css/flightAdministrator.css';
import { useNavigate } from "react-router-dom";
import fundo from '../img/fond.jpg';

const FlightAdministrator = () => {

    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [flights, setFlights] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const userId = localStorage.getItem("userId");
        setIsLoggedIn(!!userId);

        fetch('http://localhost:8981/api/flights/flights/OK')
            .then(response => response.json())
            .then(data => setFlights(data))
            .catch(error => console.error('Error fetching flights:', error));
    }, []);

    const handleHome = () => {
        navigate("/admin");
    };

    const handleState = (state, flightId) => {

        fetch(`http://localhost:8981/api/flights/${flightId}/${state}`, {
            method: 'PATCH'
        })
            .then(response => {
                if (response.ok) {
                    // update the flight state locally
                    setFlights(flights.map(p =>
                        p.flightId === flightId ? { ...p, state: state } : p
                    ));

                    // alert(JSON.stringify(response));
                } else {
                    console.error('Error updating the flight');
                }
            })
            .catch(error => console.error('Error:', error));


        console.log('Flight updated successfully!');
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

                    <div>
                        <h2>Update flights state</h2>
                        <ul>
                            {flights.filter(p => p.state === "OK").map(flight => (
                                <li key={flight.flightId}>
                                    {flight.departureCity} --- {flight.arrivalCity}
                                    <button className="button-blue" onClick={() => handleState('Embarque', flight.flightId)}>
                                        Boarding
                                    </button>
                                    <button className="button-yellow" onClick={() => handleState('Atrasado', flight.flightId)}>
                                        Delay
                                    </button>
                                    <button className="button-red" onClick={() => handleState('Cancelado', flight.flightId)}>
                                        Cancel
                                    </button>
                                </li>
                            ))}
                        </ul>
                    </div>
                ) : (
                    <div>
                        <h1>ACCESS DENIED</h1>
                    </div>
                )}
            </div>
        </div>
    );
};

export default FlightAdministrator;