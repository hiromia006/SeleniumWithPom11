package com.parabank.parasoft.util;

public class ParaBankUtil {
    public static final int WAIT_TIME = 30;
    public static final String LOGIN_TITTLE = "ParaBank | Welcome | Online Banking";

public static void waitForDom(){
    try {
        Thread.sleep(300);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
}
