package defaultPackage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModuleTest {


    @ParameterizedTest
    @CsvSource({
            //BC
            "'[50,-1],[50,50],50,01'",
            "'[50,60],[50,50],50,02'",
            "'[40,-1],[50,50],50,03'",
            "'[40,50],[50,50],50,04'"
    })

    //Method Complete
    void updateProgression(String testValues) {
        //Set up
        ArrayList<Double> convertedTestValues  ;
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