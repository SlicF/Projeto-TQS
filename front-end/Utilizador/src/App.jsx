import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Register from './pages/Register.jsx';
import Login from './pages/login.jsx';
import AirportControl from './pages/AirportControl.jsx';
import MyComponent from './pages/MyComponent.jsx';
import Flights from './pages/Flight.jsx';
import FlightCheckout from './pages/FlightCheckout.jsx';
import Invoice from './pages/Invoice.jsx';
import Payment from './pages/Payment.jsx';
import AdminRoutes from './pages/Administration/AdminRoutes.jsx';


function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Register />} />
        <Route path="/login" element={<Login />} />
        {/* <Route path="/airport-control" element={<AirportControl />} /> */}
        <Route path="/mycomponent" element={<MyComponent />} />
        {/* <Route path="/flights" element={<Flights />} /> */}
        <Route path="/flightCheckout" element={<FlightCheckout />} />
        <Route path="/invoice" element={<Invoice />} />
        <Route path="/payment" element={<Payment />} />
        <Route path="/formulario" element={<Flights />} />
        
        {/* Admin routes nested under '/admin' */}
        <Route path="/admin/*" element={<AdminRoutes />} />
      </Routes>
    </div>
  );
}

export default App;
