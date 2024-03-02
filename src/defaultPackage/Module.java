package defaultPackage;
import java.util.ArrayList;

public class Module {
    //data fields
    private String ModuleName ;
    private double goalGrade ;
    private int progression;
    private ArrayList<Test> tests = new ArrayList<Test>() ;

    //methods
    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }
    public void setProgression(int progression) {
        this.progression = progression;
    }
    public void setGoalGrade(double goalGrade) { this.goalGrade = goalGrade; }

    public double getGoalGrade(){return goalGrade;}
    public String getModuleName() {
        return ModuleName;
    }
    public int getProgression() {return progression;}


    /**
     *creates a new test and adds it to the list of tests in a module
     *if a test with the given name already exists in the module it adds a number at the end
     *@param test the name of the test
     **/
    public void addTest(Test test) {

    }

    /**
     *Checks whether a module is on track to meet its target grade
     *Can be in three states
     *1 = On track
     *2 = achieved
     *3 = behind
     *4 = Fail
     * @param module is the module that will be checked
     * @return will be an in representing the state of progression
     **/
    public int updateProgression(Module module) {
        double scoresOfTestsCompleted = 0;
        int allTestsCompleted = 0;

        //gets the total scores and weightings of the tests completed
        for (int number = 0; number < module.tests.size(); number++) {
            if (module.tests.get(number).getAchievedResult() != -1) {
                scoresOfTestsCompleted += module.tests.get(number).getAchievedResult();
                allTestsCompleted++;
            }
        }

        //calculates the grade that has been achieved from the tests completed
        double currentGrade = (scoresOfTestsCompleted / (100 * allTestsCompleted)) * 100 ;

        //compares the grade that has been achieved so far with the users target grade
        if (allTestsCompleted == module.tests.size())
            if (currentGrade < module.goalGrade)
                return 4 ;
            else return 2 ;
        else if (currentGrade < module.goalGrade)
            return 3 ;
        else return 1 ;

    }



}

