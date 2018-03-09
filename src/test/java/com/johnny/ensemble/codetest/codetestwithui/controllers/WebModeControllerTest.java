package com.johnny.ensemble.codetest.codetestwithui.controllers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WebModeControllerTest {

    private static String testString;
    private static String testAnswer;

    @Before
    public void setup() throws Exception {
        testString = "A mate material may maybe right maybe";
        testAnswer = "Material: 1\nMaybe: 2\nRight: 1\n";
    }

    @Test
    public void testWebModeControllerResultCorrect() throws Exception {
        WebModeController webModeController = new WebModeController();
        assertTrue(webModeController.count(testString).equals(testAnswer));
    }

}
