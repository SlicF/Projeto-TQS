import React, { useState } from 'react';

const SeatSelection = ({ seats, onSeatSelect, selectedSeat }) => {
  const [localSelectedSeat, setLocalSelectedSeat] = useState(selectedSeat);

  const handleSeatClick = (seatNumber) => {
    setLocalSelectedSeat(seatNumber);
    onSeatSelect(seatNumber);
  };

  const rows = [];
  const numSeatsPerRow = 5;
  for (let i = 0; i < seats.length; i += numSeatsPerRow) {
    rows.push(seats.slice(i, i + numSeatsPerRow));
  }

  return (
    <div className="seat-selection">
      {rows.map((row, index) => (
        <div key={index} className={`seat-row ${index % 4 < 2 ? "group-one" : "group-two"}`}>
          {row.map((seat) => (
            <button
              key={seat.number}
              className={`seat ${seat.status} ${seat.number === localSelectedSeat ? "selected" : ""}`}
              onClick={() => handleSeatClick(seat.number)}
              disabled={seat.status !== "AVAILABLE"}
              style={{ margin: "5px", width: "30px", height: "30px", backgroundColor: "rgba(220, 200, 100}" }}
            >
              {seat.number}
            </button>
          ))}
        </div>
      ))}
    </div>
  );
};

export default SeatSelection;
