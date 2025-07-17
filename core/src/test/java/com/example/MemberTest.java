package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void testGettersAndToString() {
        Member member = new Member("M1", "Alice");
        assertEquals("M1", member.getId());
        assertEquals("Alice", member.getName());
        String repr = member.toString();
        assertTrue(repr.contains("Alice"));
        assertTrue(repr.contains("M1"));
    }
}
