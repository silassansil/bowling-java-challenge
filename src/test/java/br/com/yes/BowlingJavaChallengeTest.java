package br.com.yes;

import junit.framework.TestCase;

public class BowlingJavaChallengeTest extends TestCase {

    public void testMain() {
        final String[] path = new String[1];

        System.out.println("=========== none score ===========");
        path[0] = "resource-none-score";
        BowlingJavaChallenge.main(path);

        System.out.println("=========== perfect score ===========");
        path[0] = "resource-perfect-score";
        BowlingJavaChallenge.main(path);

        System.out.println("=========== two players ===========");
        path[0] = "resource-two-players";
        BowlingJavaChallenge.main(path);
    }
}