package com_bptn_quiz_app.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getPassword() {
        User user = new User("Emmanuel","Gbaragbo","eg@gmail.com","johndoe");
        String password = user.getPassword();
        assertEquals(password, "johndoe");
        assertNotEquals(password, "");
    }

    @Test
    void getEmail() {
        User user = new User("Emmanuel","Gbaragbo","eg@gmail.com","johndoe");
        String email = user.getEmail();
        assertEquals("eg@gmail.com", email);
        assertNotEquals(email, "");
    }

    @Test
    void getLastName() {
        User user = new User("Emmanuel","Gbaragbo","eg@gmail.com","johndoe");
        String lastname = user.getLastName();
        assertEquals("Gbaragbo", lastname);
        assertNotEquals("", lastname);
    }

    @Test
    void getFirstName() {
        User user = new User("Emmanuel","Gbaragbo","eg@gmail.com","johndoe");
        String firstName = user.getFirstName();
        assertEquals("Emmanuel", firstName);
        assertNotEquals("", firstName, "");
    }

}