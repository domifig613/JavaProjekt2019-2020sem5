/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * @author Dominik Figlak
 * @version 1.1
 */
@RunWith(Suite.class)
@SuiteClasses({
    TestModel.class,
    TestPolygonFieldCalculator.class,
    })
public class TestSuite {
}
