import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginAdmin from './pages/LoginAdmin';
import AdminHome from './pages/AdminHome';
import CheckIn from './pages/CheckIn';
import Luggage from './pages/Luggage';
import './App.css';

function App() {
  const [count, setCount] = useState(0); // This state appears unused currently.

  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginAdmin />} />
        <Route path="/home" element={<AdminHome />} />
        <Route path="/checkin" element={<CheckIn />} />
        <Route path="/luggage" element={<Luggage />} />
      </Routes>
    </Router>
  );
}

export default App;
