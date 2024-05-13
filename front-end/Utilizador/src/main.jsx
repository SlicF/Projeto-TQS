import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import App from './App.jsx';
import './index.css';
import Register from './pages/Register.jsx';
import Login from './pages/login.jsx';
import MyComponent from './pages/MyComponent.jsx';
import Formulario from './pages/Formulario.jsx';
import FlightCheckout from './pages/FlightCheckout.jsx';
import Invoice from './pages/Invoice.jsx';
import Payment from './pages/Payment.jsx';
import CheckIn from './pages/Administration/CheckIn.jsx';
import Luggage from './pages/Administration/Luggage.jsx';
import LoginAdmin from './pages/Administration/LoginAdmin.jsx';
import AdminHome from './pages/Administration/AdminHome.jsx';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />}>  
          <Route index element={<Register />} />
          <Route path="login" element={<Login />} />
          <Route path="register" element={<Register />} />
          <Route path="mycomponent" element={<MyComponent />} />
          <Route path="formulario" element={<Formulario />} />
          <Route path="flightcheckout" element={<FlightCheckout />} /> 
          <Route path="invoice" element={<Invoice />} />
          <Route path="payment" element={<Payment />} />
          <Route path="/checkin" element={<CheckIn />} />
          <Route path="/luggage" element={<Luggage />} />
          <Route path="/loginAdmin" element={<LoginAdmin />} />
          <Route path="/adminHome" element={<AdminHome />} />


        </Route>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
