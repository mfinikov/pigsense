package com.pigsense.anticheat.data;

/*
* @mfinikov:
* current PlayerData is very small
* in future i will make it much bigger
*
* */

public class PlayerData {
    public double x, y, z;
    public double lastX, lastY, lastZ;
    public double deltaX, deltaY, deltaZ;
    public boolean onGround, lastOnGround;
    public int airTicks, groundTicks;
    public float yaw, pitch;
    public float lastYaw, lastPitch;
    public float deltaYaw, deltaPitch;
    public int ping;

    public PlayerData() {}
}
