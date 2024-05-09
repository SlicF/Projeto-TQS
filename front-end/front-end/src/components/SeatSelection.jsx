import React, { useState } from 'react';

const SeatSelection = ({ seats, onSeatSelect }) => {
  const [selectedSeat, setSelectedSeat] = useState(null);

  const handleSeatClick = (seatNumber, status) => {
    if (status === "AVAILABLE" || status === "PREFERRED") {
      setSelectedSeat(seatNumber);
      onSeatSelect(seatNumber);
    }
  };
  

  return (
    <div className="seat-selection">
      {seats.map((seat, index) => (
        <button
          key={index}
          className={`seat ${seat.status} ${seat.number === selectedSeat ? "selected" : ""}`}
          onClick={() => handleSeatClick(seat.number, seat.status)}
          disabled={seat.status === "EMERGENCY_EXIT"}
          style={{ margin: "5px", width: "30px", height: "30px" }}
        >
          {seat.number}
        </button>
      ))}
    </div>
  );
};

export default SeatSelection;
