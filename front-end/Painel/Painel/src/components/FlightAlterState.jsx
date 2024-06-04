/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */

// FlightAlterState.jsx
import React from 'react';

const FlightAlterState = ({ airline, flightNumber, destination, departureTime, state }) => {
  return (
    <div className="flight">
      <span>{airline}</span>
      <span>{flightNumber}</span>
      <span>{destination}</span>
      <span>{departureTime}</span>
      <span>{state}</span>
    </div>
  );
};

export default FlightAlterState;
