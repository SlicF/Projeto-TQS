package ua.tqs.airportManager.service;

import ua.tqs.airportManager.dto.AuthResponse;
import ua.tqs.airportManager.dto.LoginDTO;
import ua.tqs.airportManager.dto.RegisterDTO;

public interface AuthService {
    AuthResponse register(RegisterDTO registerDTO);
    AuthResponse login(LoginDTO loginDTO);
}
