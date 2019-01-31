/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectCode;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Claudio
 */
public class ObjectCodeTest {
    
    public ObjectCodeTest() {
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

    /**
     * Test of concat method, of class ObjectCode.
     */
    @Test
    public void testConcat() {
        ObjectCode code = new ObjectCode();
        code.concat("1");
        code.concat("2");
        code.concatOperation("3");
        for(String i : code.getObjectCode()) {
            System.out.println(i);
        }
    }    
}
