/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoicapital.stockchartsfx;

import java.text.DecimalFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RobTerpilowski
 */
public class DecimalAxisFormatterTest {
    
    
    
    public DecimalAxisFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testStringConstructor() {
        String format = "#000.00";
        DecimalAxisFormatter formatter = new DecimalAxisFormatter(format);
        
        assertEquals( "1234.45", formatter.toString(1234.45) );
        assertEquals( 1234.45, formatter.fromString("1234.45") );
    }

    @Test
    public void testFormatterConstructor() {
        String format = "#000.00";
        DecimalAxisFormatter formatter = new DecimalAxisFormatter(new DecimalFormat(format));
        
        assertEquals( "1234.45", formatter.toString(1234.45) );
        assertEquals( 1234.45, formatter.fromString("1234.45") );
    }
    
}