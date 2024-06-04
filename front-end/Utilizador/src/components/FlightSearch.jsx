/* eslint-disable no-unused-vars */
// import React, { useState, useEffect } from 'react';
// import Fundo from '../img/fundo.jpg';
// import "../css/SearchFlight.css";
// import { useNavigate } from 'react-router-dom';

// const FlightsSearch = () => {

//     const navigate = useNavigate();
//     const [from, setFrom] = useState('');
//     const [to, setTo] = useState('');
//     const [departureDate, setDepartureDate] = useState('');
//     const [filteredDepartureCities, setFilteredDepartureCities] = useState([]);
//     const [filteredArrivalCities, setFilteredArrivalCities] = useState([]);
//     const [showDropdown, setShowDropdown] = useState(false);
//     const [passengers, setPassengers] = useState(1); // initial state 1

//     useEffect(() => {
//         fetchCities();
//     }, []);

//     const fetchCities = async (searchValue, type) => {
//         try {
//             const response = await fetch(`http://localhost:8981/api/flights/cities`);
//             if (!response.ok) {
//                 throw new Error(`Failed fetch: ${response.status}`);
//             }
//             const data = await response.json();
//             const filteredCities = data.filter(city =>
//                 city.toLowerCase().includes(searchValue.toLowerCase())
//             );
//             if (type === 'departure') {
//                 setFilteredDepartureCities(filteredCities);
//             } else {
//                 setFilteredArrivalCities(filteredCities);
//             }
//             setShowDropdown(true);
//         } catch (error) {
//             console.error("Failed to fetch cities:", error);
//         }
//     };

//     const handleDepartureCityChange = (value) => {
//         setFrom(value);
//         console.log("Value from here:", value)
//         fetchCities(value, 'departure');
//     };

//     const handleArrivalCityChange = (value) => {
//         setTo(value);
//         fetchCities(value, 'arrival');
//     };

//     const handleDepartureCitySelect = (city) => {
//         setFrom(city);
//         setShowDropdown(false);
//     };

//     const handleArrivalCitySelect = (city) => {
//         setTo(city);
//         setShowDropdown(false);
//     };

//     // const fetchFlightData = async () => {
//     //     try {

//     //         // console.log("from code")
//     //         // console.log(selectedFromCode)
//     //         // console.log(selectedDestinationCode)

//     //         let formattedDepartureDate = 0;

//     //         const response = await fetch(`http://localhost:8981/api/flights/searchFlight`, {
//     //             method: 'POST',
//     //             headers: {
//     //                 'Content-Type': 'application/json',
//     //             },
//     //             body: JSON.stringify({
//     //                 departureCity: from,
//     //                 arrivalCity: to,
//     //                 departureDate: departureDate,
//     //                 passengers: passengers
//     //             }),
//     //         });

//     //         if (!response.ok) {
//     //             throw new Error(`Failed fetch: ${response.status}`);
//     //         }

//     //         const data = await response.json();
//     //         if (data && data.flights && data.flights.length > 0) {
//     //             const arrivalCity = data.flights[0].arrivalCity;
//     //             localStorage.setItem("flightArrival", arrivalCity);
//     //         }

//     //         navigate("/flights", null);
//     //     } catch (error) {
//     //         console.error("Failed to fetch flights:", error);
//     //     }
//     // };

//     const handleSearch = () => {
//         // gather search details and navigate to next page
//         const searchDetails = {
//             from,
//             to,
//             departureDate,
//             passengers
//         };
//         localStorage.setItem('flightSearch', JSON.stringify(searchDetails));
//         navigate("/flights");
//     };

//     return (
//         <div className="background-image" style={{ backgroundImage: `url(${Fundo})` }}>
//             <div className="container-flight-search">
//                 <input name="from" value={from} className="search-input" type="text" placeholder="From" onChange={(e) => handleDepartureCityChange(e.target.value)} />
//                 {showDropdown && filteredDepartureCities.length > 0 && (
//                     <div className="dropdown">
//                         {filteredDepartureCities.map((departureCity) => (
//                             <div
//                                 key={departureCity}
//                                 onClick={() => handleDepartureCitySelect(departureCity)}
//                                 className="dropdownItem"
//                             >
//                                 {departureCity}
//                             </div>
//                         ))}
//                     </div>
//                 )}
//                 <input name="to" value={to} className="search-input" type="text" placeholder="To" onChange={(e) => handleArrivalCityChange(e.target.value)} />
//                 {showDropdown && filteredArrivalCities.length > 0 && (
//                     <div className="dropdown">
//                         {filteredArrivalCities.map((arrivalCity) => (
//                             <div
//                                 key={arrivalCity}
//                                 onClick={() => handleArrivalCitySelect(arrivalCity)}
//                                 className="dropdownItem"
//                             >
//                                 {arrivalCity}
//                             </div>
//                         ))}
//                     </div>
//                 )}
//                 <input name="departureDate" value={departureDate} className="search-input" type="date" placeholder="Departure" onChange={(e) => setDepartureDate(e.target.value)} />
//                 {/* <select name="travelClass" value={travelClass} className="search-input">
//                 <option value="economy">Economy Class</option>
//                 <option value="first">First Class</option>
//                 <option value="second">Second Class</option>
//             </select> */}
//                 <input name="passengers" value={passengers} className="search-input" type="number" min="1" placeholder="Number of Passengers" onChange={(e) => setPassengers(parseInt(e.target.value))} />
//                 <button type="submit" onClick={handleSearch}>Search</button>
//             </div>
//         </div>
//     );
// };

// export default FlightsSearch;

import React, { useState, useEffect } from 'react';
import Fundo from '../img/fundo.jpg';
import "../css/SearchFlight.css";
import { useNavigate } from 'react-router-dom';

const FlightsSearch = () => {
    const navigate = useNavigate();
    const [from, setFrom] = useState('');
    const [to, setTo] = useState('');
    const [departureDate, setDepartureDate] = useState('');
    const [filteredDepartureCities, setFilteredDepartureCities] = useState([]);
    const [filteredArrivalCities, setFilteredArrivalCities] = useState([]);
    const [showDropdown, setShowDropdown] = useState(false);
    const [passengers, setPassengers] = useState(1); // initial state 1

    useEffect(() => {
        fetchCities();
    }, []);

    const fetchCities = async (searchValue = '', type = '') => {
        try {
            const response = await fetch('http://localhost:8981/api/flights/cities');
            if (!response.ok) {
                throw new Error('Failed fetch: ${response.status}');
            }
            const data = await response.json();
            const filteredCities = searchValue ? data.filter(city =>
                city.toLowerCase().includes(searchValue.toLowerCase())
            ) : data;

            if (type === 'departure') {
                setFilteredDepartureCities(filteredCities);
            } else if (type === 'arrival') {
                setFilteredArrivalCities(filteredCities);
            }
            setShowDropdown(true);
        } catch (error) {
            console.error("Failed to fetch cities:", error);
        }
    };

    const handleDepartureCityChange = (value) => {
        setFrom(value);
        fetchCities(value, 'departure');
    };

    const handleArrivalCityChange = (value) => {
        setTo(value);
        fetchCities(value, 'arrival');
    };

    const handleDepartureCitySelect = (city) => {
        setFrom(city);
        setShowDropdown(false);
    };

    const handleArrivalCitySelect = (city) => {
        setTo(city);
        setShowDropdown(false);
    };

    const handleSearch = () => {
        // gather search details and navigate to next page
        const searchDetails = {
            from,
            to,
            departureDate,
            passengers
        };
        localStorage.setItem('flightSearch', JSON.stringify(searchDetails));
        navigate("/flights");
    };

    return (
        <div className="background-image" style={{ backgroundImage: `url(${Fundo})` }}>
            <div className="container-flight-search">
                <input name="from" value={from} className="search-input" type="text" placeholder="From" onChange={(e) => handleDepartureCityChange(e.target.value)} />
                {showDropdown && filteredDepartureCities.length > 0 && (
                    <div className="dropdown">
                        {filteredDepartureCities.map((departureCity) => (
                            <div
                                key={departureCity}
                                onClick={() => handleDepartureCitySelect(departureCity)}
                                className="dropdownItem"
                            >
                                {departureCity}
                            </div>
                        ))}
                    </div>
                )}
                <input name="to" value={to} className="search-input" type="text" placeholder="To" onChange={(e) => handleArrivalCityChange(e.target.value)} />
                {showDropdown && filteredArrivalCities.length > 0 && (
                    <div className="dropdown">
                        {filteredArrivalCities.map((arrivalCity) => (
                            <div
                                key={arrivalCity}
                                onClick={() => handleArrivalCitySelect(arrivalCity)}
                                className="dropdownItem"
                            >
                                {arrivalCity}
                            </div>
                        ))}
                    </div>
                )}
                <input name="departureDate" value={departureDate} className="search-input" type="date" placeholder="Departure" onChange={(e) => setDepartureDate(e.target.value)} />
                <input name="passengers" value={passengers} className="search-input" type="number" min="1" placeholder="Number of Passengers" onChange={(e) => setPassengers(parseInt(e.target.value))} />
                <button type="submit" onClick={handleSearch}>Search</button>
            </div>
        </div>
    );
};

export default FlightsSearch;