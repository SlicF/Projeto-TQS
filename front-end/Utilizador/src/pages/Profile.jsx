import React, { useState, useEffect } from "react";
import { useLocation} from 'react-router-dom';
import "../css/Profile.css";
import Navbar from '../components/Navbar';
import FlightsReservedCard from '../components/FligthsReservedCard';

// const Profile = () => {
//   const location = useLocation();
//   const { flightDetails, selectedSeat } = location.state || { flightDetails: null, selectedSeat: null };

//   const [reservations, setReservations] = useState([]);
//   // const userId = localStorage.getItem("userId"); // Obtendo o userId do localStorage

//   const userId = "787911000u";

//   useEffect(() => {
//     const fetchReservations = async () => {
//       try {
//         const response = await fetch(`/api/reservations/user/${userId}`);
//         if (response.ok) {
//           const data = await response.json();
//           setReservations(data);
//         } else {
//           console.error("Failed to fetch reservations");
//         }
//       } catch (error) {
//         console.error("Error fetching reservations:", error);
//       }
//     };

//     if (userId) {
//       fetchReservations();
//     }
//   }, [userId]);

//   return (
//     <div className="profile-page">
//       <Navbar />
//       <div className="profile-content">
//         <h1 className="profile-title">Your Profile</h1>
//         <div className="flight-details">
//           <h2 className="flight-details-title">YOUR PLANE TICKETS</h2>
//         </div>

//         {/* <FlightsReservedCard/> */}

//         <div>
//           {reservations.length > 0 ? (
//             reservations.map((reservation) => (
//               <FlightReservedCard key={reservation.reservationId} reservation={reservation} />
//             ))
//           ) : (
//             <p>No reservations found.</p>
//           )}
//         </div>


//       </div>
//     </div>
//   );
// };

// export default Profile;

// import React, { useState, useEffect } from "react";
// import { useLocation } from 'react-router-dom';
// import "../css/Profile.css";
// import Navbar from '../components/Navbar';
// import FlightsReservedCard from '../components/FlightsReservedCard'; 

const Profile = () => {
  const location = useLocation();
  const { flightDetails, selectedSeat } = location.state || { flightDetails: null, selectedSeat: null };

  const [reservations, setReservations] = useState([]);
  const [loading, setLoading] = useState(true); // Adicionei um estado para carregamento

  const userId = localStorage.getItem("userId"); // Obtendo o userId do localStorage
  // const userId = "787911000u"; // Substitua isso pelo método correto de obter o userId

  useEffect(() => {
    const fetchPassengerIds = async () => {
      try {
        const response = await fetch(`/api/passengers/user/${userId}`);
        if (response.ok) {
          const passengers = await response.json();
          return passengers.map(p => p.passengerId);
        } else {
          console.error("Failed to fetch passengers");
          return [];
        }
      } catch (error) {
        console.error("Error fetching passengers:", error);
        return [];
      }
    };

    const fetchReservations = async (passengerIds) => {
      try {
        const allReservations = [];
        for (const passengerId of passengerIds) {
          const response = await fetch(`/api/reservations/getReservationsByPassenger?passengerId=${passengerId}`);
          if (response.ok) {
            const reservations = await response.json();
            allReservations.push(...reservations);
          } else {
            console.error(`Failed to fetch reservations for passenger ${passengerId}`);
          }
        }
        setReservations(allReservations);
      } catch (error) {
        console.error("Error fetching reservations:", error);
      } finally {
        setLoading(false);
      }
    };

    const loadData = async () => {
      const passengerIds = await fetchPassengerIds();
      if (passengerIds.length > 0) {
        await fetchReservations(passengerIds);
      } else {
        setLoading(false);
      }
    };

    if (userId) {
      loadData();
    }
  }, [userId]);

  return (
    <div className="profile-page">
      <Navbar />
      <div className="profile-content">
        <h1 className="profile-title">Your Profile</h1>
        <div className="flight-details">
          <h2 className="flight-details-title">YOUR PLANE TICKETS</h2>
        </div>

        <div>
          {loading ? (
            <p>Loading reservations...</p>
          ) : (
            reservations.length > 0 ? (
              reservations.map((reservation) => (
                <FlightsReservedCard key={reservation.reservationId} reservation={reservation} />
              ))
            ) : (
              <p>No reservations found.</p>
            )
          )}
        </div>
      </div>
    </div>
  );
};

export default Profile;

