package practicePOM;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class PracticeTest extends BaseClass{
@Test
public void practiceTest()
{
	Reporter.log(" first Practice Method is executing",true);
}
@Test
public void SecondpracticeTest()
{
	Reporter.log("Second Practice Method is executing",true);
}

}
