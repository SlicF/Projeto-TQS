import { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import Navbar from '../components/NavbarAdmin';
import '../css/adminHome.css';
import fundo from '../img/fond.jpg';

const AdminHome = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

  const handleCheckIn = () => {
    navigate("/checkin");
  };

  const handleLuggage = () => {
    navigate("/luggage");
  };

  return (
    <div className="register-container"
        style={{ backgroundImage: `url(${fundo})` }} 
        >
      <Navbar />
      <div className='container'>
        {isLoggedIn? (
          <div className='administrator-form2'>
            <div className="card-container">
              <div className="cardLuggage" onClick={handleLuggage}>
                <h2 className="card-title">Luggage</h2>
                <div className="card-content">
                 Regist the passengers luggage
                </div>
              </div>
            </div>
            <div className="card-container">
              <div className="cardLuggage" onClick={handleCheckIn}>
                <h2 className="card-title">Checkin</h2>
                <div className="card-content">
                  Make the passengers checkIn
                </div>
              </div>
            </div>
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

export default AdminHome;