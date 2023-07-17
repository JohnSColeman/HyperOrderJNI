/*
 Copyright 2004 J. S. Coleman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.qbyteconsulting;

/**
 * This class uses the hoctsjni.dll to provide operation
 * of HyperOrder. All code included in this project should be treated as
 * untested prototype material, and is  provided as an example of how to
 * implement the JNI. Although the code is operational, <u>you are not advised
 * to use it in a live trading environment</u>.
 * <p>
 * Native methods have been provided for all of the basic trading functions. In
 * some cases the method functions have not been implemented in the DLL,
 * although the interface exists.
 * <p>
 * Documentation is provided by the HyperOrder SDK.
 * <p>
 * @author John Coleman
 * @version 0.9
 */

public final class HyperOrderIF {

    /**
     * Attempt to load and initialise jni DLL and report status of HyperOrder.
     * <p>
     * Change this functionality as required.
     */
    static {
    try {
      System.loadLibrary("hoctsjni"); // NB: required
      if (initialiseDLL()) {
        String status = "- linked to hoctsjni";
        if (isHostRunning() == 1) {
          status += "- HyperOrder is running";
          if (isHostConnected() == 1) {
            status += "\n- HyperOrder is connected";
          }
          else {
            status += "- HyperOrder is not connected!";
          }
        }
        else {
          status += "\n- HyperOrder is not running!";
        }
        popupAlert(status, "");
      }
      else {
        System.out.println("ERROR: hoctsjni failed to link to DLL");
      }
    }
    catch (UnsatisfiedLinkError ex) {
      System.out.println(
          "hoctsjni.dll file not found - make sure it is on the path");
    }
    catch (SecurityException ex) {
      System.out.println(
          "security manager prevented link - change checkLink setting");
    }
  }

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details.
   * Run this method prior to using any of the other methods - this is usually
   * done when the class loads.</p>
   */
  public static native boolean initialiseDLL();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native int isHostRunning();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native int isHostConnected();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native double getAccountCashBalance();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native int getAccountUpdateTime();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native double getAccountItem(int number);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long getFirstOpenOrder();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long getNextOpenOrder(long prevOrdId);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long buyMarket(String symbol, String symType, String expiry,
                               String right, float strike, String exchange,
                               String currency, int quantity);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long sellMarket(String symbol, String symType, String expiry,
                                String right, float strike, String exchange,
                                String currency, int quantity);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long buyLimit(String symbol, String symType, String expiry,
                              String right, float strike, String exchange,
                              String currency, int quantity, float limitPrice);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long sellLimit(String symbol, String symType, String expiry,
                               String right, float strike, String exchange,
                               String currency, int quantity, float limitPrice);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long buyStop(String symbol, String symType, String expiry,
                             String right, float strike, String exchange,
                             String currency, int quantity, float auxPrice);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long sellStop(String symbol, String symType, String expiry,
                              String right, float strike, String exchange,
                              String currency, int quantity, float auxPrice);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long buyStopLimit(String symbol, String symType, String expiry,
                                  String right, float strike, String exchange,
                                  String currency, int quantity, float auxPrice,
                                  float limitPrice);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long sellStopLimit(String symbol, String symType, String expiry,
                                   String right, float strike, String exchange,
                                   String currency, int quantity,
                                   float auxPrice,
                                   float limitPrice);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long BuyTrailStop(String symbol, String symType, String expiry,
                                  String right, float strike, String exchange,
                                  String currency, int quantity,
                                  float auxDistance);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long sellTrailStop(String symbol, String symType, String expiry,
                                   String right, float strike, String exchange,
                                   String currency, int quantity,
                                   float auxDistance);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void cancelOrder(long orderId);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void cancelAll();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void cancelAllFor(String symbol, String symType, String expiry,
                                  String right, float strike, String exchange,
                                  String currency);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long getMarketPosition(String symbol, String symType,
                                       String expiry,
                                       String right, float strike,
                                       String currency);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long closePositionFor(String symbol, String symType,
                                      String expiry,
                                      String right, float strike,
                                      String exchange,
                                      String currency);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void startOCAGroup(String ocaGroup);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void stopOCAGroup();

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void setTIF(String tif);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native int getOrderStatus(long orderId);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native float getOrderPrice(long orderId);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long getOrderFilled(long orderId);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native long getOrderRemaining(long orderId);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native void writeIntValue(String name, int value);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native int readIntValue(String name);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native void writeLongValue(String name, long value);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native long readLongValue(String name);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native void writeFloatValue(String name, float value);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native float readFloatValue(String name);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native void writeStringValue(String name, String value);

  /**
   * <p>NOT IMPLEMENTED</p>
   */
  public static native String readStringValue(String name);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void soundAlert(String path);

  /**
   * <p>IMPLEMENTED - see HyperOrder SDK for further details</p>
   */
  public static native void popupAlert(String text, String path);

  /** @todo new live data function implementations */

  private HyperOrderIF(){}

}
