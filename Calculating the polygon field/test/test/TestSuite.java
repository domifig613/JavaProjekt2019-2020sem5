/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 *
 * @author Dominik Figlak
 * @version 1.0
 */


@RunWith(Suite.class)
@SuiteClasses({
    ModelTest.class,
    PolygonFieldCalculatorTest.class,})
public class TestSuite {
}
