package by.epam.training.jwd.godot.bean;

import java.time.Month;

public enum SeasonType {
    WINTER, SPRING, SUMMER, AUTUMN, ANY;

    public static SeasonType of(final Month month) {
        switch (month) {

            // Spring.
            case MARCH:
                return SeasonType.SPRING;

            case APRIL:
                return SeasonType.SPRING;

            // Summer.
            case MAY:
                return SeasonType.SUMMER;

            case JUNE:
                return SeasonType.SUMMER;

            case JULY:
                return SeasonType.SUMMER;

            case AUGUST:
                return SeasonType.SUMMER;

            // Fall.
            case SEPTEMBER:
                return SeasonType.AUTUMN;

            case OCTOBER:
                return SeasonType.AUTUMN;

            // Winter.
            case NOVEMBER:
                return SeasonType.WINTER;

            case DECEMBER:
                return SeasonType.WINTER;

            case JANUARY:
                return SeasonType.WINTER;

            case FEBRUARY:
                return SeasonType.WINTER;

            default:
                return null;
        }
    }
}
