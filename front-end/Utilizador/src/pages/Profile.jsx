import React from 'react';
import { useLocation } from 'react-router-dom';
import "../css/Profile.css";
import Navbar from '../components/Navbar';

const Profile = () => {
  const location = useLocation();
  const { flightDetails, selectedSeat } = location.state || { flightDetails: null, selectedSeat: null };

  return (
    <div className="profile-page">
      <Navbar />
      <div className="profile-content">
        <h1 className="profile-title">Your Profile</h1>
        <div className="flight-details">
          <h2 className="flight-details-title">YOUR PLANE TICKETS</h2>
          
         
        </div>
      </div>
    </div>
  );
};

export default Profile;
