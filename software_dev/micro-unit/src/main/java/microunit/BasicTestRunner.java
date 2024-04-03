package microunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.tinylog.Logger;

/**
 * Class for running unit tests without support for expected exceptions.
 */
public class BasicTestRunner extends TestRunner {

    /**
     * Creates a {@code BasicTestRunner} object for executing the test methods
     * of the test class specified.
     *
     * @param testClass the test class whose test methods will be executed
     */
    public BasicTestRunner(Class<?> testClass) {
        super(testClass);
    }

    @Override
    public void invokeTestMethod(Method testMethod, Object instance, TestResultAccumulator results)
            throws IllegalAccessException {
        try {
            Logger.info("");
            testMethod.invoke(instance);
            results.onSuccess(testMethod);
            Logger.debug("Result: PASS");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            Logger.warn("Caught an exception or error on");
            cause.printStackTrace(System.out);
            if (cause instanceof AssertionError) {
                results.onFailure(testMethod);
            } else {
                results.onError(testMethod);
                Logger.debug("");
            }
        }
    }

    // CHECKSTYLE:OFF
    public static void main(String[] args) throws Exception {
        Class<?> testClass = Class.forName(args[0]);
        new BasicTestRunner(testClass).runTestMethods();
    }

}
