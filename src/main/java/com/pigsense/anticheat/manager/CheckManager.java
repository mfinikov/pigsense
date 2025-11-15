package com.pigsense.anticheat.manager;

import com.pigsense.anticheat.checks.Check;
import com.pigsense.anticheat.checks.movement.SpeedA;
import com.pigsense.anticheat.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckManager {

    private final List<Check> movementCheck = new ArrayList<>();

    public CheckManager() {
        movementCheck.add(new SpeedA());
    }

    public void handleMovementChecks(Player player, PlayerData data) {
        movementCheck.forEach(check -> {check.handle(player, data);});
    }
}
