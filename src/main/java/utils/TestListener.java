package utils;

import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Complete: " + result.getMethod().getMethodName());
        AllureUtils.takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test Failed: " + result.getMethod().getMethodName());
        AllureUtils.takeScreenshot(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}