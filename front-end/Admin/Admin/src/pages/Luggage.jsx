// import React, { useState, useEffect } from "react";
// import "../css/luggage.css";
// import Navbar from '../components/NavbarAdmin';
// import { useNavigate } from "react-router-dom";
// import fundo from '../img/fond.jpg';



// const BaggageRegistration = () => {

//     const [isLoggedIn, setIsLoggedIn] = useState(false);
//     const navigate = useNavigate();

//     useEffect(() => {
//         const userId = localStorage.getItem("userId");
//         setIsLoggedIn(!!userId);
//       }, []);

//     const handleHome = () => {
//         navigate("/adminHome");
//     };

//     const [baggageInfo, setBaggageInfo] = useState({
//         passengerName: "",
//         flightNumber: "",
//         weight: "",
//         size: "",
//     });

//     const handleChange = (e) => {
//         const { name, value } = e.target;
//         setBaggageInfo((prevState) => ({
//             ...prevState,
//             [name]: value,
//         }));
//     };

//     const handleSubmit = (e) => {
//         e.preventDefault();
//         console.log("Baggage Information:", baggageInfo);
//     };

//     const handleChange2 = (e) => {
//         const { name, value } = e.target;

//         if (!isNaN(value)) {
//             setBaggageInfo({
//                 ...baggageInfo,
//                 ...baggageSize,
//                 [name]: parseFloat(value)
//             });
//         }
//     };


//     return (
//         <div className="register-container"
//         style={{ backgroundImage: `url(${fundo})` }} 
//         >
//             <Navbar />
//             <div className="container">
//             {isLoggedIn ? (
//                 <div className="baggage-registration">
//                     <h2>Baggage Registration</h2>
//                     <form onSubmit={handleSubmit}>
//                         <div className="form-group">
//                             <label htmlFor="passengerName">Passenger Name:</label>
//                             <input
//                                 type="text"
//                                 id="passengerName"
//                                 name="passengerName"
//                                 value={baggageInfo.passengerName}
//                                 onChange={handleChange}
//                             />
//                         </div>
//                         <div className="form-group">
//                             <label htmlFor="flightNumber">Flight Number:</label>
//                             <input
//                                 type="text"
//                                 id="flightNumber"
//                                 name="flightNumber"
//                                 value={baggageInfo.flightNumber}
//                                 onChange={handleChange}
//                             />
//                         </div>
//                         <div className="form-group">
//                             <label htmlFor="weight">Weight (kg):</label>
//                             <input
//                                 type="text"
//                                 id="weight"
//                                 name="weight"
//                                 value={baggageInfo.weight}
//                                 onChange={handleChange2}
//                             />
//                         </div>
//                         <div className="form-group">
//                             <label htmlFor="size">Size (cm):</label>
//                             <input
//                                 type="text"
//                                 id="size"
//                                 name="size"
//                                 value={baggageInfo.size}
//                                 onChange={handleChange2}
//                             />
//                         </div>
//                         <button type="submit" onClick={handleHome}>Regist Baggage</button>
//                     </form>
//                 </div>

//             ):(<div>
//                 <h1>ACCESS DENIED</h1>
//             </div>)}
//             </div>
//         </div>
//     );
// };

// export default BaggageRegistration;


import React, { useState, useEffect } from "react";
import "../css/luggage.css";
import Navbar from '../components/NavbarAdmin';
import { useNavigate } from "react-router-dom";
import fundo from '../img/fond.jpg';

const BaggageRegistration = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const userId = localStorage.getItem("userId");
        setIsLoggedIn(!!userId);
    }, []);

    const handleHome = () => {
        navigate("/adminHome");
    };

    const generateRandomId = () => {
        const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        let result = '';
        for (let i = 0; i < 7; i++) {
            result += characters.charAt(Math.floor(Math.random() * characters.length));
        }
        return result;
    };

    const [baggageInfo, setBaggageInfo] = useState({
        luggageId: generateRandomId(),
        reservationId: "",
        weight: "",
    });

    const handleReservation = (e) => {
        const { name, value } = e.target;
        setBaggageInfo((prevState) => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleWeight = (e) => {
        const { name, value } = e.target;
        if (!isNaN(value)) {
            setBaggageInfo((prevState) => ({
                ...prevState,
                [name]: parseFloat(value),
            }));
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log("Baggage Information:", baggageInfo);

        try {
            const response = await fetch("http://localhost:8981/api/luggage/createLuggage", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(baggageInfo),
            });

            if (!response.ok) {
                throw new Error("Failed to register luggage");
            }

            const data = await response.json();
            console.log("Luggage registered successfully:", data);
            alert("Luggage registered successfully");

            navigate("/admin");
        } catch (error) {
            console.error("Error registering luggage:", error);
            alert("Error registering luggage");
        }
    };

    return (
        <div className="register-container" style={{ backgroundImage: `url(${fundo})` }}>
            <Navbar />
            <div className="container">
                {isLoggedIn ? (
                    <div className="baggage-registration">
                        <h2>Baggage Registration</h2>
                        <form onSubmit={handleSubmit}>
                            {/* <div className="form-group">
                                <label htmlFor="luggageId">Luggage ID:</label>
                                <input
                                    type="text"
                                    id="luggageId"
                                    name="luggageId"
                                    value={baggageInfo.luggageId}
                                    onChange={handleChange}
                                    required
                                />
                            </div> */}
                            <div className="form-group">
                                <label htmlFor="reservationId">Reservation ID:</label>
                                <input
                                    type="text"
                                    id="reservationId"
                                    name="reservationId"
                                    value={baggageInfo.reservationId}
                                    onChange={handleReservation}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="weight">Weight (kg):</label>
                                <input
                                    type="text"
                                    id="weight"
                                    name="weight"
                                    value={baggageInfo.weight}
                                    onChange={handleWeight}
                                    required
                                />
                            </div>
                            <button type="submit">Register Baggage</button>
                        </form>
                    </div>
                ) : (
                    <div>
                        <h1>ACCESS DENIED</h1>
                    </div>
                )}
            </div>
        </div>
    );
};

export default BaggageRegistration;
