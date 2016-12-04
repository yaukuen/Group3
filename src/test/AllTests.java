package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * A master testing class that contain all other testing class
 * and execute all testing in once.
 *
 * @author Nico Tandyo
 * @author Yau
 */
@RunWith(Suite.class)
@SuiteClasses({DataConnectionTest.class, EmployeeCollectionTest.class, EmployeeTest.class, EmploymentDataTest.class,
        OutputTest.class, RequestCollectionTest.class, RequestTest.class, StudentCollectionTest.class, StudentTest.class})
public class AllTests {

}

