package ru.javawebinar.topjava.web;

import static ru.javawebinar.topjava.util.MealsUtil.DEFAULT_CALORIES_PER_DAY;

public class SecurityUtil {
    private static Integer authUserId = 1;

    public static void setAuthUserId(Integer userId) {
        SecurityUtil.authUserId = userId;
    }

    public static int authUserId() {
        return authUserId;
    }

    public static int authUserCaloriesPerDay() {
        return DEFAULT_CALORIES_PER_DAY;
    }
}