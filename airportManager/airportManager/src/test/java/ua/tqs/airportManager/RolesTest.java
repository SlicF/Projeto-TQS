package ua.tqs.airportManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class RolesTest {

    @Test
    void testEnumValues() {
        Roles[] roles = Roles.values();

        assertNotNull(roles);
        assertEquals(2, roles.length);
        assertEquals(Roles.ADMIN, roles[0]);
        assertEquals(Roles.USER, roles[1]);
    }

    @Test
    void testValueOf() {
        assertEquals(Roles.ADMIN, Roles.valueOf("ADMIN"));
        assertEquals(Roles.USER, Roles.valueOf("USER"));
    }
}
