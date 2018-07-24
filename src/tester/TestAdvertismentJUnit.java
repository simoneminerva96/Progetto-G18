package tester;


import advertisment.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import user.Level;
import user.Sex;
import user.SportType;
import user.User;

import static junit.framework.TestCase.assertEquals;


public class TestAdvertismentJUnit {


    Location l1 = new Location("BRONI", "VIA QUARTIERE PIAVE 14", "LOMBARDIA", "PV");
    Location l2 = new Location("PAVIA", "VIA FERRATA 5", "LOMBARDIA", "PV");
    Advertisment a1 = new Advertisment(SportType.CALCETTO, l1, "2018-09-12", "18:00:00", Role.PORTIERE, Periodicity.SETTIMANALE, 18, 21, Level.HIGH, Sex.F);
    Advertisment a2 = new Advertisment(SportType.PALLAVOLO, l2, "2018-07-12", "22:00:00", Role.PALLEGGIATORE, Periodicity.NONE, 25, 30, Level.LOW, Sex.F );

    @Test
    public void testCheckDate() {
        assertEquals(true, a1.checkDate());
        assertEquals(false,a2.checkDate());
    }

    @Test
    public void testGetSport() {
        assertEquals(SportType.CALCETTO, a1.getSport());
        assertEquals(SportType.PALLAVOLO, a2.getSport());
    }

    @Test
    public void testGetLocation() {
        assertEquals("BRONI VIA QUARTIERE PIAVE 14 LOMBARDIA PV", a1.getLocation());
        assertEquals("PAVIA VIA FERRATA 5 LOMBARDIA PV", a2.getLocation());
    }

    @Test
    public void testGetDate() {
        assertEquals("2018-09-12", a1.getDate());
        assertEquals("2018-07-12", a2.getDate());
    }

    @Test
    public void testGetTime() {
        assertEquals("18:00:00", a1.getTime());
        assertEquals("22:00:00", a2.getTime());
    }

    @Test
    public void testGetRole() {
        assertEquals(Role.PORTIERE, a1.getRole());
        assertEquals(Role.PALLEGGIATORE, a2.getRole());
    }

    @Test
    public void testGetPeriodicity() {
        assertEquals(Periodicity.SETTIMANALE, a1.getPeriodicity());
        assertEquals(Periodicity.NONE, a2.getPeriodicity());
    }

    @Test
    public void testGetAgeMin() {
        assertEquals(18, a1.getAgeMin());
        assertEquals(25, a2.getAgeMin());
    }

    @Test
    public void testAgeMax() {
        assertEquals(21, a1.getAgeMax());
        assertEquals(30, a2.getAgeMax());
    }

    @Test
    public void testGetLevel() {
        assertEquals(Level.HIGH, a1.getLevel());
        assertEquals(Level.LOW, a2.getLevel());
    }

    @Test
    public void testGetSex() {
        assertEquals(Sex.F, a1.getSex());
        assertEquals(Sex.F, a2.getSex());
    }

    @Test
    public void testAddEvent() {
        assertEquals(true, a1.addEvent(a1));
        assertEquals(false, a2.addEvent(a2));
    }


}
