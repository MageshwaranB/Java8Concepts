package com.dateTimeAPI;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDate_Example {
    /*
        The need for a separate api for Date Time is due to the shortcomings of previous versions
        They're not thread safe, incomprehensibility of the api documents and time zone handling
        In Java 8, the api is immutable and provides a lot of methods to handle time zones

        Local Time, Local Date and Locale Date Time are most widely used classes from this api. They mainly used when
        there's no need of specifying the time zones. On the previous version of Java, the classes and methods provided does
        basic stuffs, this causes to either go with some third party libraries or writing customized code.
     */
    public static void main(String[] args) {
       // getLocalDateMethods_01();
        //getting back the month, day of the given date
        int dayOfMonth=LocalDate.parse("2023-08-12").getDayOfMonth();
        DayOfWeek dayOfWeek=LocalDate.parse("2023-08-12").getDayOfWeek();
        var dayOfYear=LocalDate.parse("2023-08-12").getDayOfYear();
        System.out.println("Year: "+dayOfYear+"\n"+"Month: "+dayOfMonth+"\n"+"Week: "+dayOfWeek+"\n");
        var isBefore=LocalDate.parse("2012-12-12").isBefore(LocalDate.parse("2012-12-13"));
        var isAfter=LocalDate.parse("2018-08-08").isAfter(LocalDate.parse("2018-08-07"));
        System.out.println(isBefore);
        System.out.println(isAfter);
        checkingLeapYearWithLocalDate();

        //atStartofDay returns the start of the day with Time
        var startOfDay=LocalDate.now().atStartOfDay();
        //The same can be done for month with temporal adjuster
        var firstDayOfMonth=LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("Start of Day: "+startOfDay+"\n"+"First day of Month: "+firstDayOfMonth);

    }

    private static void getLocalDateMethods_01(){
        /*
        Local Date represents a date in ISO format (yyyy-MM-dd) without time. This api found in java.time package consists of a lot of
        factory methods i.e.The Factory Method defines a method, which should be used for creating objects instead of
        using a direct constructor call (new operator). Subclasses can override this method to change the class of
        objects that will be created.
         */
        LocalDate localDate = LocalDate.now(); //Creating an instance of LocalDate class. now method returns the system clock date
        System.out.println("LocalDate with now(): " + localDate);

        //Second overloaded method of now by passing the instance of clock
        Clock clock = Clock.systemDefaultZone();//Sets the clock with a default system time zone
        LocalDate localDate1 = LocalDate.now(clock);
        System.out.println("LocalDate with now(clock): " + localDate1);

        //Third overloaded method of now by passing the instance of zone id
        ZoneId zoneId = ZoneId.of("Asia/Tokyo"); //Mentioning the zone id of Asia/Tokyo. To more about the zone ids, jump into ZoneId class
        LocalDate localDate2 = LocalDate.now(zoneId);
        System.out.println("LocalDate with now(zoneid): " + localDate2);

        //Passing a specific date by using of method
        LocalDate localDate3 = LocalDate.of(2023, 07, 04);
        System.out.println("Specific Date: " + localDate3);

        //parsing a char sequence by using parse method
        LocalDate localDate4 = LocalDate.parse("2023-07-06");
        System.out.println("Parsing a specific date: " + localDate4);

        //adding days, years and month from a specific date or system date
        var added5days = localDate4.plusDays(5);
        System.out.println("Added 5 days " + added5days + " from " + localDate4);

        //subtracting days from a specific or system date
        var minus5Days=localDate3.minus(5, ChronoUnit.DAYS);//ChronoUnit is an enum that implements the TemporalUnit interface, which provides the standard units used in the Java Date Time API.
        System.out.println("Subtracting 5 days "+minus5Days+" from "+localDate3);
    }

    public static void checkingLeapYearWithLocalDate(){
        String year="2012-01-01";
        var test=LocalDate.parse(year);
        System.out.println(test.isLeapYear());
    }
}
