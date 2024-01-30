package practicePOM;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class DemoTest extends BaseClass{
@Test
public void demoTest()
{
Reporter.log("1st demo",true);
}
@Test
public void seconddemoTest()
{
Reporter.log("2nd demo",true);
}
}
