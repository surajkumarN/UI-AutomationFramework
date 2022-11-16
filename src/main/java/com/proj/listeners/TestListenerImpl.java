package com.proj.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.proj.annotations.FrameworkAnnotations;
import com.proj.listeners.extentreport.ExtentManager;
import com.proj.listeners.extentreport.ExtentReport;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.proj.utils.ScreenshotUtils.takeScreenShot;


public class TestListenerImpl implements ITestListener {
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReport.tearDownReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());

        //find the author and category and then i need to call that extent report method
        String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author();
        ExtentReport.addAuthor(authors);

        String[] category = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
        ExtentReport.addCategory(category);

        ExtentManager.getTest().log(Status.INFO,result.getMethod().getMethodName()+" is executed");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().log(Status.PASS,result.getMethod().getMethodName()+" is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getTest().log(Status.FAIL,result.getMethod().getMethodName()+"is failed");
        ExtentManager.getTest().log(Status.FAIL,result.getThrowable());
        String testCaseName = result.getMethod().getMethodName();
        try {
            String path = takeScreenShot();
            ExtentManager.getTest().fail(testCaseName,MediaEntityBuilder.createScreenCaptureFromBase64String(path).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getTest().log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");
        ExtentManager.getTest().log(Status.SKIP,result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }
}
