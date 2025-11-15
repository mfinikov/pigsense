package com.pigsense.anticheat.util;

/*
* @mfinikov:
* made for future use
*
* */
public class RotationUtil {

    public static float wrapAngle(float angle) {
        angle %= 360.0F;
        if (angle >= 180.0F) angle -= 360.0F;
        if (angle < -180.0F) angle += 360.0F;
        return angle;
    }

    public static float getAngleDifference(float a, float b) {
        return Math.abs(wrapAngle(a - b));
    }
}

