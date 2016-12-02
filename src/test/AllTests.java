package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Run all tests in this project.
 * @author Nico Tandyo
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ DataConnectionTest.class, EmployeeCollectionTest.class, EmployeeTest.class, EmploymentDataTest.class,
	OutputTest.class, RequestCollectionTest.class, RequestTest.class, StudentCollectionTest.class, StudentTest.class})
public class AllTests {

}

