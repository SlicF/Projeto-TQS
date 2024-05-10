import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Register from './pages/Register.jsx';
import Login from './pages/login.jsx';
import AirportControl from './pages/AirportControl.jsx';
import MyComponent from './pages/MyComponent.jsx';
import Formulario from './pages/Formulario.jsx';
import Flights from './pages/Flight.jsx';
import FlightCheckout from './pages/FlightCheckout.jsx';
import Invoice from './pages/Invoice.jsx';
import Payment from './pages/Payment.jsx';


function App() {

  return (
    <div>
      
      <Routes>
        <Route path="/" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/otherpage" element={<AirportControl />} />
        <Route path="/mycomponent" element={<MyComponent />} />
        <Route path="/airport-control" element={<AirportControl />} />
        <Route path="/formulario" element={<Flights />} />
        <Route path="/flightCheckout" element={<FlightCheckout />} /> 
        <Route path="/invoice" element={<Invoice />} />
        <Route path="/payment" element={<Payment />} />
      </Routes>
    </div>
  )
}

export default App;