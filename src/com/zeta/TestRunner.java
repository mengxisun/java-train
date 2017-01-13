package com.zeta;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Formatter;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by kang on 06/01/2017.
 */
public class TestRunner {
    private Class testClass;
    private Result testResult;

    public TestRunner(Class testClass) {
        this.testClass = testClass;
    }

    public void execute() {
        testResult = JUnitCore.runClasses(testClass);
    }

    public Result getTestResult() {
        return testResult;
    }

    public String getTestResultText() {
        String resultText = "";

        if (testResult.wasSuccessful()) {
            resultText = "您的代码已通过全部测试。";
        } else {
            resultText = "您的代码有如下测试未通过，请检查。";
            for (Failure fail: testResult.getFailures()) {
                resultText += "\n" + fail.getTestHeader() + ": " + fail.getMessage();
            }
        }

        double score = 100 - testResult.getFailureCount() * 100.0 / testResult.getRunCount();
        resultText += "\n" + "您的当前成绩：" + score;

        return resultText;
    }

    public void saveTestResult(String fileName) {
        try {
            Formatter formatter = new Formatter(new File(fileName));
            formatter.format(getTestResultText());
            formatter.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void sendTestResultByMail(String toAddr, String password) {
        final String fromAddr = "kangyuzhe@zeta-inc.co.jp";
        final String userName = "kangyuzhe@zeta-inc.co.jp";
        final String host = "zeta-inc.co.jp";
        Scanner scanner = new Scanner(System.in);

        if (toAddr == null || toAddr.isEmpty()) {
            System.out.print("Please input recipient mail address:");
            toAddr = scanner.next();
        }

        if (password == null || password.isEmpty()) {
            System.out.print("Please input sender password:");
            password = scanner.next();
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        final String pwd = password;
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, pwd);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddr));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddr));
            message.setSubject("测试结果");
            message.setText(getTestResultText());
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void runTests(Class testClass, String toAddr, String password) {
        TestRunner testRunner = new TestRunner(testClass);
        testRunner.execute();

        System.out.println(testRunner.getTestResultText());
        testRunner.sendTestResultByMail(toAddr, password);
    }
}
