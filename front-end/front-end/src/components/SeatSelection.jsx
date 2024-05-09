import React, { useState } from 'react';

const SeatSelection = ({ seats, onSeatSelect }) => {
  const [selectedSeat, setSelectedSeat] = useState(null);

  const handleSeatClick = (seatNumber) => {
    if (seatNumber !== selectedSeat) {
      setSelectedSeat(seatNumber);
      onSeatSelect(seatNumber);
    } else {
      setSelectedSeat(null);
      onSeatSelect(null);
    }
  };

  return (
    <div className="seat-selection">
      {seats.map((seat) => (
        <div
          key={seat.number}
          className={`seat ${seat.status} ${seat.number === selectedSeat ? "selected" : ""}`}
          onClick={() => handleSeatClick(seat.number)}
        >
          {seat.number}
        </div>
      ))}
    </div>
  );
};

export default SeatSelection;
