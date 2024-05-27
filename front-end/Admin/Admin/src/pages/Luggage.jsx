import React, { useState } from "react";
import "../css/luggage.css";
import Navbar from '../components/NavbarAdmin';
import { useNavigate } from "react-router-dom";
import fundo from '../img/fond.jpg';



const BaggageRegistration = () => {

    const navigate = useNavigate();

    const handleHome = () => {
        navigate("/adminHome");
    };


    const [baggageInfo, setBaggageInfo] = useState({
        passengerName: "",
        flightNumber: "",
        weight: "",
        size: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setBaggageInfo((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Baggage Information:", baggageInfo);
    };

    const handleChange2 = (e) => {
        const { name, value } = e.target;

        if (!isNaN(value)) {
            setBaggageInfo({
                ...baggageInfo,
                ...baggageSize,
                [name]: parseFloat(value)
            });
        }
    };


    return (
        <div className="register-container"
        style={{ backgroundImage: `url(${fundo})` }} 
        >
            <Navbar />
            <div className="container">
                <div className="baggage-registration">
                    <h2>Baggage Registration</h2>
                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="passengerName">Passenger Name:</label>
                            <input
                                type="text"
                                id="passengerName"
                                name="passengerName"
                                value={baggageInfo.passengerName}
                                onChange={handleChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="flightNumber">Flight Number:</label>
                            <input
                                type="text"
                                id="flightNumber"
                                name="flightNumber"
                                value={baggageInfo.flightNumber}
                                onChange={handleChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="weight">Weight (kg):</label>
                            <input
                                type="text"
                                id="weight"
                                name="weight"
                                value={baggageInfo.weight}
                                onChange={handleChange2}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="size">Size (cm):</label>
                            <input
                                type="text"
                                id="size"
                                name="size"
                                value={baggageInfo.size}
                                onChange={handleChange2}
                            />
                        </div>
                        <button type="submit" onClick={handleHome}>Regist Baggage</button>
                    </form>
                </div>


            </div>
        </div>
    );
};

export default BaggageRegistration;
