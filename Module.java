import java.util.ArrayList;

public class Module {
    //data fields
    private String ModuleName ;
    private int progression;
    private ArrayList<Test> tests = new ArrayList<Test>() ;

    //methods
    public String getModuleName() {
        return ModuleName;
    }
    public int getProgression() {
        return progression;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }
    public void setProgression(int progression) {
        this.progression = progression;
    }

    public void addTest(String testName){
        Test newTest;
        int count = 0;

        for (Test test:tests){
            if(test.getTestName().equals(testName))
                count++ ;
        }
        if (count > 0)
            newTest = new Test(testName + count) ;
        else
            newTest = new Test(testName) ;

        tests.add(newTest);
    }

    /**
     *Checks whether a module is on track to meet its target grade
     *Can be in three states
     *0 = On track
     *1 = achieved
     *2 = behind
     *3 = not achieved
     * @param module is the module that will be checked
     * @return will be an in representing the state of progression
     **/
    public int checkProgression(Module module){
       int progression = 4 ;

       return  progression ;
    }
}

