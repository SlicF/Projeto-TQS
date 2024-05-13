import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import Navbar from '../../components/NavbarAdmin';
import '../../css/Administration/adminHome.css';

const AdminHome = () => {

    const navigate = useNavigate();

    const handleCheckIn = () => {
        navigate("/checkin");
    };

    const handleLuggage = () => {
        navigate("/luggage");
    };


    return (

        <div>
            <Navbar />
            <h1 className='titleAdmin'>Airport Organizer Check-In</h1>

            <div className="card-container">
                <div className="cardLuggage" onClick={handleLuggage}>

                    <h2 className="card-title">Luggage</h2>

                    <div className="card-content">
                        Tenha acesso a todas as reservas e faça alterações quando necessário.
                    </div>

                </div>
            </div>
            <div className="card-container">
                <div className="cardLuggage" onClick={handleLuggage}>

                    <h2 className="card-title">Luggage</h2>

                    <div className="card-content">
                        Tenha acesso a todas as reservas e faça alterações quando necessário.
                    </div>

                </div>
            </div>

        </div>


    );

};


export default AdminHome;