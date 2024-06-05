import React, { useState, useEffect } from "react";
import { useLocation} from 'react-router-dom';
import "../css/Profile.css";
import Navbar from '../components/Navbar';
import FlightsReservedCard from '../components/FligthsReservedCard';

const Profile = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const location = useLocation();
  const { flightDetails, selectedSeat } = location.state || { flightDetails: null, selectedSeat: null };

  const [reservations, setReservations] = useState([]);
  const [loading, setLoading] = useState(true); // Adicionei um estado para carregamento

  useEffect(() => {
    const userId = localStorage.getItem("userId");
    setIsLoggedIn(!!userId);
  }, []);

  const userId = localStorage.getItem("userId"); // Obtendo o userId do localStorage


  useEffect(() => {
    const fetchPassengerIds = async () => {
      try {
        const response = await fetch(`http://192.168.160.219:8981/api/passengers/user/${userId}`);

        console.log('response');
        console.log(response);

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
          const response = await fetch(`http://localhost:8981/api/reservations/getReservationsByPassenger?passengerId=${passengerId}`);
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
      {isLoggedIn? (
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
      </div>) : (
          <div>
            <h1>ACCESS DENIED</h1>
          </div>
        )}
    </div>
  );
};

export default Profile;


// import React, { useState, useEffect } from "react";
// import { useLocation } from 'react-router-dom';
// import "../css/Profile.css";
// import Navbar from '../components/Navbar';
// import FlightsReservedCard from '../components/FligthsReservedCard';

// const Profile = () => {
//   const [isLoggedIn, setIsLoggedIn] = useState(false);

//   const location = useLocation();
//   const { flightDetails, selectedSeat } = location.state || { flightDetails: null, selectedSeat: null };

//   const [reservations, setReservations] = useState([]);
//   const [loading, setLoading] = useState(true); // Adicionei um estado para carregamento

//   useEffect(() => {
//     const userId = localStorage.getItem("userId");
//     setIsLoggedIn(!!userId);
//   }, []);

//   const userId = localStorage.getItem("userId"); // Obtendo o userId do localStorage


//   useEffect(() => {
//     const fetchPassengerIds = async () => {
//       try {
//         const response = await fetch(`http://localhost:8981/api/passengers/user/${userId}`);

//         console.log('response');
//         console.log(response);

//         if (response.ok) {
//           const passengers = await response.json();
//           return passengers.map(p => p.passengerId);
//         } else {
//           console.error("Failed to fetch passengers");
//           return [];
//         }
//       } catch (error) {
//         console.error("Error fetching passengers:", error);
//         return [];
//       }
//     };

//     const fetchReservations = async (passengerIds) => {
//       try {
//         const allReservations = [];
//         for (const passengerId of passengerIds) {
//           const response = await fetch(`http://localhost:8981/api/reservations/getReservationsByPassenger?passengerId=${passengerId}`);
//           if (response.ok) {
//             const reservations = await response.json();
//             allReservations.push(...reservations);
//           } else {
//             console.error(`Failed to fetch reservations for passenger ${passengerId}`);
//           }
//         }
//         setReservations(allReservations);
//       } catch (error) {
//         console.error("Error fetching reservations:", error);
//       } finally {
//         setLoading(false);
//       }
//     };

//     const loadData = async () => {
//       const passengerIds = await fetchPassengerIds();
//       if (passengerIds.length > 0) {
//         await fetchReservations(passengerIds);
//       } else {
//         setLoading(false);
//       }
//     };

//     if (userId) {
//       loadData();
//     }
//   }, [userId]);

//   const fetchLuggageByReservation = async (reservationId) => {
//       try {
//         const response = await fetch(`http://localhost:8981/api/luggage?reservationId=${reservationId}`);
//         if (response.ok) {
//           const luggage = await response.json();
//           return luggage;
//         } else {
//           console.error(`Failed to fetch luggage for reservation ${reservationId}`);
//           return [];
//         }
//       } catch (error) {
//         console.error("Error fetching luggage:", error);
//         return [];
//       }
//     };

//   return (
//     <div className="profile-page">
//       <Navbar />
//       {/* {isLoggedIn? ( */}
//       <div className="profile-content">
//         <h1 className="profile-title">Your Profile</h1>
//         <div className="flight-details">
//           <h2 className="flight-details-title">YOUR PLANE TICKETS</h2>
//         </div>

//         <div>
//           {loading ? (
//             <p>Loading reservations...</p>
//           ) : (
//             reservations.length > 0 ? (
//               reservations.map(async (reservation) => {
//                 const luggage = await fetchLuggageByReservation(reservation.reservationId);
//                 return (
//                   <FlightsReservedCard key={reservation.reservationId} reservation={reservation} luggage={luggage} />
//                 );
//               })
//             ) : (
//               <p>No reservations found.</p>
//             )
//           )}

//         </div>
//       </div>
//       {/* ) : (
//            <div>
//              <h1>ACCESS DENIED</h1>
//            </div>
//          )*/}
//     </div>
//   );
// };

// export default Profile;
