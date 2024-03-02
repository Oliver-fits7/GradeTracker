package defaultPackage;

import java.util.ArrayList;

public class testResources {
    //parsing String to numerical values
    public ArrayList<Double> parseStringTCToDoubleTC(String inputs) {
        //Remove "["
        inputs = inputs.replaceAll("\\[","") ;
        //remove "]"
        inputs = inputs.replaceAll("]","") ;

        //add to int[]
        String[] tempArray = inputs.split(",") ;
        int noTests = inputs.length() / 3 + 1;

        ArrayList<Double> testInputs = new ArrayList<>() ;
        for(int number = 0; number < noTests; number++){
            testInputs.add(Double.parseDouble(tempArray[number]))  ;
        }

        return testInputs ;
    }
}
