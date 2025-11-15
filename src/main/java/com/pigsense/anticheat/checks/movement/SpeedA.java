package com.pigsense.anticheat.checks.movement;

import com.pigsense.anticheat.checks.Check;
import com.pigsense.anticheat.data.PlayerData;
import org.bukkit.entity.Player;

/*
* @mfinikov:
* simple example of check
* doesn't work btw
*/

public class SpeedA extends Check {
    public SpeedA() {
        super("SpeedA");
    }

    @Override
    public void handle(Player player, PlayerData data) {
        double deltaXZ = Math.hypot(data.deltaX, data.deltaZ);
        double max = 0.35;

        if (deltaXZ > max && !data.onGround) {
            fail(player, "deltaXZ=" + deltaXZ);
        } else {
            reward();
        }
    }
}
