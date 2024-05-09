import React, { useState } from 'react';

const SeatSelection = ({ seats, onSeatSelect }) => {
  const [selectedSeat, setSelectedSeat] = useState(null);

  const handleSeatClick = (seatNumber, status) => {
    if (status === "AVAILABLE" || status === "PREFERRED") {
      setSelectedSeat(seatNumber);
      onSeatSelect(seatNumber);
    }
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
              className={`seat ${seat.status} ${seat.number === selectedSeat ? "selected" : ""}`}
              onClick={() => handleSeatClick(seat.number, seat.status)}
              disabled={seat.status === "EMERGENCY_EXIT"}
              style={{ margin: "5px", width: "30px", height: "30px" }}
            >
              {seat.number}
            </button>
          ))}
          {(index + 1) % 2 === 0 && <div className="row-spacer" />}
        </div>
      ))}
    </div>
  );
};

export default SeatSelection;
