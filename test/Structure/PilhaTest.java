/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

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
public class PilhaTest {
    
    public PilhaTest() {
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
     * Test of insere method, of class Pilha.
     */
    @Test
    public void testInsere() {
        System.out.println("insere");
        String elemento = "0";
        String elemento1 = "1";
        String elemento2 = "2";
        Pilha instance = new Pilha();
        instance.insere(elemento);
        instance.insere(elemento1);
        instance.insere(elemento2);
        System.out.println("TOPO:" + instance.onTop());
        instance.remove();
        System.out.println("TOPO:" + instance.onTop());
        instance.remove();
        System.out.println("TOPO:" + instance.onTop());        
    }
  
}
