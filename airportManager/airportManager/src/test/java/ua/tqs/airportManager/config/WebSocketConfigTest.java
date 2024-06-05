package ua.tqs.airportManager.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

class WebSocketConfigTest {

    @InjectMocks
    private WebSocketConfig webSocketConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConfigureWebSocketTransport() {
        WebSocketTransportRegistration registration = new WebSocketTransportRegistration();
        webSocketConfig.configureWebSocketTransport(registration);

        assertThat(registration).isNotNull();
    }
}
