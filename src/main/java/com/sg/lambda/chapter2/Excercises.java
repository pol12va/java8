package com.sg.lambda.chapter2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Excercises {

    public static void main(String[] args) {
        testThreadLocal();
    }

    public static void testThreadLocal() {
        ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal.withInitial(
                () -> new SimpleDateFormat("dd-MMM-yyyy")
        );

        System.out.println(dateFormatter.get().format(new Date()));
    }

}
