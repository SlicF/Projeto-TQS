/* eslint-disable no-unused-vars */
import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginAdmin from './pages/LoginAdmin';
import AdminHome from './pages/AdminHome';
import CheckIn from './pages/CheckIn';
import Luggage from './pages/Luggage';
import FlightAdmnistration from './pages/FlightAdministration';
import './App.css';

function App() {
  const [count, setCount] = useState(0);

  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginAdmin />} /> 
        <Route path="/admin" element={<AdminHome />} />
        <Route path="/home" element={<AdminHome />} />
        <Route path="/flightAdministration" element={<FlightAdmnistration />} />
        <Route path="/checkin" element={<CheckIn />} />
        <Route path="/luggage" element={<Luggage />} />
      </Routes>
    </Router>
  );
}

export default App;
