package defaultPackage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleTest {


    @ParameterizedTest
    @CsvSource({
            //NOTE: Only deals with valid inputs as invalid inputs should be dealt with when received from user
            "'[50,-1],[50,50],50,01'",//progression 01 && score = -1 (Boundary) //TC#1
            "'[50,60],[50,50],50,02'",//Progression 02 //TC#2
            "'[40,-1],[50,50],50,03'",//progression 03 //TC#3
            "'[40,50],[50,50],50,04'",//progression 04 //TC#4
            "'[100,50],[50,50],50,02'",//score = 100 may have been mistakenly identified as a boundary //TC#5
            "'[150,50],[50,50],50,02'",//score = 150 as 100 may have been mistakenly identified as a boundary //TC#6
            "'[50,50,50],[50,0,50],50,02'",//Weighting = 0 (boundary) //TC#7
            "'[50,50],[0,100],50,02'",//weighting = 100 (boundary) //TC#8
            "'[50,50],[0,100],100,04'",//goalGrade = 100 (boundary) //TC#9
            "'[50,50],[0,100],0,02'"//goalGrade = 0 (boundary) //TC#10
    })
    /**
     * Tests progressionCalc()
     **/
    void updateProgression(String testValues) {
        //Set up
        ArrayList<Double> convertedTestValues  ;
        testResources boom = new testResources() ;
        convertedTestValues = boom.parseStringTCToDoubleTC(testValues) ;

        //initialising values
        int numberOfTests = convertedTestValues.size() / 3 ;
        double[] scores = new double[numberOfTests] ;
        double[] weightings = new double[numberOfTests] ;
        String temp = testValues.substring(testValues.lastIndexOf(",") - 4) ;
        double goalGrade = Double.parseDouble(temp.substring(temp.indexOf(",")+ 1,temp.lastIndexOf(","))) ;
        double expectedResult = Double.parseDouble(testValues.substring(testValues.lastIndexOf(",") + 1))  ;

        //adding values
        for (int i = 0; i < (numberOfTests * 2) ; i++) {
            if (i < numberOfTests)
                scores[i] = convertedTestValues.get(i);
            else
                weightings[i / 2 - 1] = convertedTestValues.get(i);

        }

        Module module = new Module() ;
        module.setGoalGrade(goalGrade);
        //adding tests to the module
        for (int i = 0; i < numberOfTests; i++){
            Test test = new Test("" + i) ;

            test.setAchievedResult(scores[i]);
            test.setWeighting(weightings[i]);

            module.addTest(test) ;
        }

        //getting the actual result of the module
        int actualResult = module.updateProgression(module);
        //comparing with the expected result
        assertEquals(expectedResult, actualResult) ;
    }

    @ParameterizedTest
    @CsvSource({
            //BC
            ""
    })
    void addTest(String testValues) {
        //Set up
        ArrayList<Double> convertedTestValues ;
        testResources boom = new testResources() ;
        convertedTestValues = boom.parseStringTCToDoubleTC(testValues) ;

        //initialising values
        int numberOfTests = convertedTestValues.size() / 3 ;
        double[] scores = new double[numberOfTests] ;
        double[] weightings = new double[numberOfTests] ;
        double goalGrade = Double.parseDouble(testValues.substring(testValues.lastIndexOf(",") - 2,testValues.lastIndexOf(","))) ;
        double expectedResult = Double.parseDouble(testValues.substring(testValues.lastIndexOf(",") + 1,testValues.lastIndexOf(",") + 3))  ;

        //adding values
        for (int i = 0; i < (numberOfTests * 2) ; i++) {
            if (i < numberOfTests){
                scores[i] = convertedTestValues.get(i);
            }
            else {
                weightings[i / 2 - 1] = convertedTestValues.get(i);
            }
        }

        //Creating module object
        Module module = new Module() ;
        //adding tests to the module
        for (int i = 0; i < numberOfTests; i++){
            Test test = new Test("" + i) ;

            test.setAchievedResult(scores[i]);
            test.setWeighting(weightings[i]);

            module.setGoalGrade(goalGrade);
            module.addTest(test) ;
        }

        //getting the actual result of the module
        int actualResult = module.updateProgression(module);
        //comparing with the expected result
        assertEquals(expectedResult, actualResult) ;
    }























}