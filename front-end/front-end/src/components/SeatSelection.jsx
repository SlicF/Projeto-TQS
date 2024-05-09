import React, { useState } from 'react';

const SeatSelection = ({ seats, onSeatSelect }) => {
  const [selectedSeat, setSelectedSeat] = useState(null);

  const handleSeatClick = (seatNumber, status) => {
    if (status !== "EMERGENCY_EXIT") {
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
      <div className="seat-legends">
      <button className="legend-button available"></button><span>Available</span>
        <button className="legend-button preferred"></button><span>Preferred</span>
        <button className="legend-button emergency-exit"></button><span>Emergency Exit</span>
      </div>
    </div>
  );
};

export default SeatSelection;
