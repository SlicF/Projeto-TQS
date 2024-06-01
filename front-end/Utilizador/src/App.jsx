import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Register from './pages/Register.jsx';
import Login from './pages/Login.jsx';
import AirportControl from './pages/AirportControl.jsx';
import SearchFlight from './pages/SearchFlight.jsx';
import Flights from './pages/Flight.jsx';
import FlightCheckout from './pages/FlightCheckout.jsx';
import Invoice from './pages/Invoice.jsx';
import Payment from './pages/Payment.jsx';
import Profile from './pages/Profile.jsx';
import Navbar from './components/Navbar.jsx';


function App() {
  return (
    <div>
      <Routes>
        <Route path="/register" element={<Register />} />
        <Route path="/" element={<Login />} />
        <Route path="/searchflight" element={<SearchFlight />} />
        <Route path="/flightCheckout/:flightId" element={<FlightCheckout />} />
        <Route path="/invoice" element={<Invoice />} />
        <Route path="/reservation" element={<Payment />} />
        <Route path="/flights" element={<Flights />} />
        <Route path="/profile" element={<Profile />} />

      </Routes>
    </div>
  );
}

export default App;