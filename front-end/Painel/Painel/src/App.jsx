/* eslint-disable no-unused-vars */

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AirportControl from './pages/AirportControl';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/" element={<AirportControl />} />
        </Routes>
      </Router>
    </div>
  );
}
export default App;
