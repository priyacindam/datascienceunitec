package testngpack;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import org.testng.xml.XmlSuite;
public class Main{
	public static void main(String[] args) {



	//	TestListenerAdapter tla = new TestListenerAdapter();

//TestNG runner=new TestNG();

//Create a list of String 
//List<String> suitefiles=new ArrayList<String>();

//suitefiles.add("\"C:\\Users\\Priyanka\\eclipse-workspace\\testng\\testng.xml\"");

//now set xml file for execution
//runner.setTestSuites(suitefiles);
//runner.setUseDefaultListeners(false);

//finally execute the runner using run method
//runner.run();
//}
//}
TestListenerAdapter tla = new TestListenerAdapter();
TestNG testng = new TestNG();
 Class[] classes = new Class[]{
         NewTest.class,
         testngpdf.class,
         
         };
 testng.setTestClasses(classes);
 testng.addListener(tla);
 testng.run();
}
}