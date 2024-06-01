import React from 'react';
import { useLocation } from 'react-router-dom';
import "../css/Profile.css";
import Navbar from '../components/Navbar';

const Profile = () => {
  const location = useLocation();
  const { flightDetails, selectedSeat } = location.state || {}; // Use um valor padrão vazio para evitar erros

  return (
    <div className="profile-page">
      <Navbar />
      <div className="profile-content">
        <h1>TEU PERFIL</h1>
        <div className="flight-details">
          <h2>TEUS BILHETES DE AVIÃO</h2>
          {flightDetails && selectedSeat ? (
            <div>
              <p>Flight Details: {flightDetails}</p>
              <p>Selected Seat: {selectedSeat}</p>
            </div>
          ) : (
            <p>No flight details available.</p>
          )}
        </div>
      </div>
    </div>
  );
};

export default Profile;
