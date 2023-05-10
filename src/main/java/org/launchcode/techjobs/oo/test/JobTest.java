package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", aJob.getName());
        assertEquals("ACME", (aJob.getEmployer()).toString());
        assertEquals("Desert", (aJob.getLocation()).toString());
        assertEquals("Quality control",(aJob.getPositionType()).toString());
        assertEquals("Persistence", (aJob.getCoreCompetency()).toString());

        assertTrue(aJob.getName().contains("Product tester"));
        assertTrue(aJob.getEmployer() instanceof Employer);
        assertTrue(aJob.getLocation() instanceof Location);
        assertTrue(aJob.getPositionType() instanceof PositionType);
        assertTrue(aJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {

        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1==job2);

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        char firstChar = testJob.toString().charAt(0);
        char lastChar = testJob.toString().charAt(testJob.toString().length() - 1);

        assertEquals("" + firstChar, "\n");
        assertEquals("" + lastChar, "\n");

    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testData= "\n" +
                "ID: " + testJob.getId() + "\n" +
                "Name: " + testJob.getName() + "\n" +
                "Employer: " + testJob.getEmployer() + "\n" +
                "Location: " + testJob.getLocation() + "\n" +
                "Position Type: " + testJob.getPositionType() + "\n" +
                "Core Competency: " + testJob.getCoreCompetency() + "\n";

        assertEquals(testJob.toString(), testData);
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        aJob.toString();

        assertEquals("Product tester", aJob.getName());
        assertEquals("ACME", aJob.getEmployer().toString());
        assertEquals("Desert", aJob.getLocation().toString());
        assertEquals("Quality control", aJob.getPositionType().toString());
        assertEquals("Persistence", aJob.getCoreCompetency().toString());



    }
}

