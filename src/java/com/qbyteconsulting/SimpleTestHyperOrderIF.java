package com.qbyteconsulting;

/**
 Run this simple test to check you can make a connection and execute a method.
 This test runs successfully with HyperOrder 1.0.1.54.
 */

public class SimpleTestHyperOrderIF {

  /**
   * Arguments are not requried.
   * @param args String[]
   */
  public static void main(String[] args) {
    if (com.qbyteconsulting.HyperOrderIF.isHostConnected() == 1) {
      double accountBalance = com.qbyteconsulting.HyperOrderIF.getAccountCashBalance();
      System.out.println("your cash balance = " + accountBalance);
    }
    else {
      System.out.println("No connection to trading platform.");
    }
  }

  private SimpleTestHyperOrderIF() {}

}
