package defaultPackage;

public class Test {

    //data fields
    private String testName;
    private double weighting;
    private double goalResult;
    private double achievedResult;

    //Constructors
    public Test(String testName) {
        this.testName = testName;
        weighting = 0.0;
        goalResult = 0.0;
        achievedResult = -1.0; //so I can identify if the student got 0 or hasn't input results yet
    }

    //getters
    public double getWeighting() {
        return weighting;
    }

    public double getAchievedResult() {
        return achievedResult;
    }

    public String getTestName() {
        return testName;
    }

    public double getGoalResult() {
        return goalResult;
    }

    //setters
    public void setAchievedResult(double achievedResult) {
        this.achievedResult = achievedResult;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setGoalResult(double goalResult) {
        this.goalResult = goalResult;
    }

    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }
}