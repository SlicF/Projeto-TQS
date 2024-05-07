import React, { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Register from './pages/Register.jsx';
import Login from './pages/login.jsx';
import AirportControl from './pages/AirportControl.jsx';
import MyComponent from './pages/MyComponent.jsx';
import Formulario from './pages/Formulario.jsx';

function App() {

  return (
    <div>
      
      
      <Routes>
        <Route path="/" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/otherpage" element={<AirportControl />} />
        <Route path="/mycomponent" element={<MyComponent />} />
        <Route path="/airport-control" element={<AirportControl />} />
        <Route path="/formulario" element={<Formulario />} />

      </Routes>
    </div>
  )
}

export default App;
