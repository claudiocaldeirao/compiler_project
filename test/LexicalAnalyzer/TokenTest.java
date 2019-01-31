/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LexicalAnalyzer;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Claudio
 */
public class TokenTest {

    public TokenTest() {
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
     * Test of tokenType method, of class Token.
     */
    @Test
    public void testTokenTypeInteiro() {
        String lexema = "12548";
        Token token = new Token();
        Lexeme lexeme = token.tokenType(lexema);
        assertEquals(lexeme.getToken(), "INTEIRO");
        System.out.println(lexeme.getToken());
    }

    @Test
    public void testTokenTypeReal() {
        String lexema = "2184.2";
        Token token = new Token();
        Lexeme lexeme = token.tokenType(lexema);
        assertEquals(lexeme.getToken(), "REAL");
        System.out.println(lexeme.getToken());
    }

    @Test
    public void testTokenTypeReservada() {
        String lexema = "if";
        Token token = new Token();
        Lexeme lexeme = token.tokenType(lexema);
        assertEquals(lexeme.getToken(), "PALAVRA_RESERVADA");
        System.out.println(lexeme.getToken());
    }

    @Test
    public void testTokenTypeIdentificador() {
        String lexema = "aux1";
        Token token = new Token();
        Lexeme lexeme = token.tokenType(lexema);
        assertEquals(lexeme.getToken(), "IDENTIFICADOR");
        System.out.println(lexeme.getToken());
    }

    @Test
    public void testTokenTypeInvalido() {
        String lexema = "&";
        Token token = new Token();
        Lexeme lexeme = token.tokenType(lexema);
        assertEquals(lexeme.getToken(), "SIMBOLO_INVALIDO");
        System.out.println(lexeme.getToken());
    }
}
