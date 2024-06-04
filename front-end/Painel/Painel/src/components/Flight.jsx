/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */
// Flight.jsx
// import React from 'react';
// import airportLogo from '../img/logo_s.png'; 

// const Flight = ({ flightNumber, destination, departureTime, gate }) => (
//   <div className="flight">
//     <span><img src={airportLogo} alt="Airport Logo" /></span>
//     <span>{flightNumber}</span>
//     <span>{destination}</span>
//     <span>{departureTime}</span>
//     <span>{gate}</span>
//   </div>
// );

// export default Flight;



// Flight.jsx
import React from 'react';

const Flight = ({ airline, flightNumber, destination, departureTime, gate }) => {
  return (
    <div className="flight">
      <span>{airline}</span>
      <span>{flightNumber}</span>
      <span>{destination}</span>
      <span>{departureTime}</span>
      <span>{gate}</span>
    </div>
  );
};

export default Flight;
