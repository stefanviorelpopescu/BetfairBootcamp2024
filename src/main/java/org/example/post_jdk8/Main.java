package org.example.post_jdk8;

import java.time.DayOfWeek;
import java.util.List;

import static java.time.DayOfWeek.*;

public class Main {

    public static void main(String[] args) {
        var cities = List.of("Urlati", "Bran", "Sinaia");

        String name = null;

//        System.out.println(name.length());

        int settingValue = 6 + 5;
        settingValue = settingValue + 8;
        boolean isSettingOn = settingValue > 0 ? true : false;

        var day = WEDNESDAY;
        int numLetters = switch (day)
        {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                System.out.println(6);
                yield 6;
            case TUESDAY:
                System.out.println(7);
                yield 7;
            case THURSDAY:
            case SATURDAY:
                System.out.println(8);
                yield 8;
            case WEDNESDAY:
                System.out.println(9);
                yield 9;
            default:
                throw new
                        IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);

        numLetters = switch (day)
        {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(numLetters);

        // ERROR
//        String name = """Pat Q. Smith""";
        // OK
        String name2 =
                 """
                             red
                                green
                             blue
                    """;
        System.out.println(name2);
    }

}
