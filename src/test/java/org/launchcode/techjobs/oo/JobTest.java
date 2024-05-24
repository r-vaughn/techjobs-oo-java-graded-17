package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.testng.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job testJobOne = new Job();
        Job testJobTwo = new Job();

        assertNotEquals(testJobOne.getId(), testJobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJobOne.getEmployer() instanceof Employer);
        assertTrue(testJobOne.getLocation() instanceof Location);
        assertTrue(testJobOne.getPositionType() instanceof PositionType);
        assertTrue(testJobOne.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJobOne.getName() instanceof String);

        assertEquals("ACME", testJobOne.getEmployer());
        assertEquals("Desert", testJobOne.getLocation());
        assertEquals("Quality control", testJobOne.getPositionType());
        assertEquals("Persistence", testJobOne.getCoreCompetency());
        assertEquals("Product tester", testJobOne.getName());

    }

    @Test
    public void testJobsForEquality() {
        Job testJobOne = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJobOne.equals(testJobTwo));
    }
}
