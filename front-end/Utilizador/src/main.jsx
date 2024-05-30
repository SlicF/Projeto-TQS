import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App.jsx';
import './index.css';
import Register from './pages/Register.jsx';
import Login from './pages/login.jsx';
import SearchFlight from './pages/SearchFlight.jsx';
import Formulario from './pages/Formulario.jsx';
import FlightCheckout from './pages/FlightCheckout.jsx';
import Invoice from './pages/Invoice.jsx';
import Payment from './pages/Payment.jsx';
import Flights from './pages/Flight.jsx';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>  
          <Route index element={<Register />} />
          <Route path="login" element={<Login />} />
          <Route path="register" element={<Register />} />
          <Route path="searchflight" element={<SearchFlight />} />
          <Route path="flights" element={<Flights />} />
          <Route path="formulario" element={<Formulario />} />
          <Route path="flightCheckout/:flightId" element={<FlightCheckout />} /> 
          <Route path="invoice" element={<Invoice />} />
          <Route path="payment" element={<Payment />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);