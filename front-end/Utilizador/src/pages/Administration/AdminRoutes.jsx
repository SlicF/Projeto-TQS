import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import CheckIn from './CheckIn.jsx';
import Luggage from './Luggage.jsx';
import LoginAdmin from './LoginAdmin.jsx';
import AdminHome from './AdminHome.jsx';

function AdminRoutes() {
  return (
    <Routes>
      <Route path="/" element={<LoginAdmin />} />   // Redirects '/admin' to '/admin/' which shows LoginAdmin
      <Route path="/home" element={<AdminHome />} />
      <Route path="/checkin" element={<CheckIn />} />
      <Route path="/luggage" element={<Luggage />} />
      {/* Optionally redirect or provide a default view at '/admin/' if no specific sub-route */}
      <Route path="*" element={<Navigate to="/" replace />} />
    </Routes>
  );
}

export default AdminRoutes;
