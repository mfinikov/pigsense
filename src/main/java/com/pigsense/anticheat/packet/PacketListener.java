package com.pigsense.anticheat.packet;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerFlying;
import com.pigsense.anticheat.data.PlayerData;
import com.pigsense.anticheat.manager.CheckManager;
import com.pigsense.anticheat.manager.DataManager;
import com.pigsense.anticheat.util.MovementUtil;
import org.bukkit.entity.Player;

public class PacketListener extends PacketListenerAbstract {

    private final DataManager dataManager;
    private final CheckManager checkManager;

    public PacketListener(DataManager dataManager, CheckManager checkManager) {
        this.dataManager = dataManager;
        this.checkManager = checkManager;
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent e) {
        if (!(e.getPlayer() instanceof Player)) return;
        Player player = e.getPlayer();

        if (e.getPacketType() == PacketType.Play.Client.PLAYER_FLYING) {

            WrapperPlayClientPlayerFlying flying = new WrapperPlayClientPlayerFlying(e);
            PlayerData data = dataManager.getData(player);

            MovementUtil.updateMovement(flying, data);

            checkManager.handleMovementChecks(player, data);
        }
    }
}
