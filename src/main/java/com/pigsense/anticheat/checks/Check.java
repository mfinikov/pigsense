package com.pigsense.anticheat.checks;

import com.pigsense.anticheat.data.PlayerData;
import org.bukkit.entity.Player;

public abstract class Check {

    protected final String name;
    protected double buffer = 0;

    public Check(String name) {
        this.name = name;
    }

    public abstract void handle(Player player, PlayerData data);

    protected void fail(Player player, String info) {
        buffer += 1;

        if (buffer > 5) {
            player.sendMessage("PigSense > " + name + " failed: " + info);
            buffer = 0;
        }
    }

    // @mfinikov: basically, that method is used to decrease buffer, if player acts much more legit
    protected void reward() {
        buffer = Math.max(0, buffer - 0.25);
    }

}
