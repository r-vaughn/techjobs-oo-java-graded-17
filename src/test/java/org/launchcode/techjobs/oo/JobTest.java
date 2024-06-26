package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.testng.Assert;
import org.testng.mustache.Value;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;
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

        assertEquals("ACME", String.valueOf(testJobOne.getEmployer()));
        assertEquals("Desert", String.valueOf(testJobOne.getLocation()));
        assertEquals("Quality control", String.valueOf(testJobOne.getPositionType()));
        assertEquals("Persistence", String.valueOf(testJobOne.getCoreCompetency()));
        assertEquals("Product tester", String.valueOf(testJobOne.getName()));

    }

    @Test
    public void testJobsForEquality() {
        Job testJobOne = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJobOne.equals(testJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
//        toString() should return a string containing blank line at beginning and end of job information

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String lineSeparator = System.lineSeparator();

        String firstChar = String.valueOf(testJob.toString().charAt(0));
        String lastChar = String.valueOf(testJob.toString().charAt(testJob.toString().length()-1));

        assertEquals(firstChar, lineSeparator);
        assertEquals(lastChar, lineSeparator);
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job testJob = new Job("Product tester", new Employer("ACME"),new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String lineSeparator = System.lineSeparator();


        String jobLabels = (
                lineSeparator +
                "ID: " + testJob.getId() + "\n" +
                "Name: " + testJob.getName() + "\n" +
                "Employer: " + testJob.getEmployer() + "\n" +
                "Location: " + testJob.getLocation() + "\n" +
                "Position Type: " + testJob.getPositionType() + "\n" +
                "Core Competency: " + testJob.getCoreCompetency() +
                lineSeparator
                );

        assertEquals(jobLabels, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job testJob = new Job("", new Employer(""),new Location(""), new PositionType(""), new CoreCompetency(""));

        assertTrue(testJob.toString().contains("Name: Data not available"));
        assertTrue(testJob.toString().contains("Employer: Data not available"));
        assertTrue(testJob.toString().contains("Location: Data not available"));
        assertTrue(testJob.toString().contains("Position Type: Data not available"));
        assertTrue(testJob.toString().contains("Core Competency: Data not available"));
    }
}
