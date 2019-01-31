/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexicalAnalyzer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/*
 *
 */

/**
 *
 * @author Claudio Caldeirão RA:131255061
 */
public class LexicalAnalyzerTest {
    
    public LexicalAnalyzerTest() {
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
     * Test of analyzeEntry method, of class LexicalAnalyzer.
     */
    @Test
    public void testAnalyzeEntry() {
        String code = "ag\n";
        LexicalAnalyzer lexical = new LexicalAnalyzer();
        lexical.analyzeEntry(code);
        LexemeTable table = lexical.getLexemeTable();
        
        LexemePosition a = table.getLexemeTable().get(0);
        assertEquals(a.getLexeme().getToken(), "IDENTIFICADOR");
        //System.out.println("Lexema: " + a.getLexeme().getLexeme() + "Token: " + a.getLexeme().getToken());                 
    }    
}
