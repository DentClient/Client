package net.dent.client.module.modules.player;

import net.dent.client.event.EventTarget;
import net.dent.client.event.events.EventUpdate;
import net.dent.client.module.Category;
import net.dent.client.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFall extends Module {
    private boolean PlayerMoveC2SPacket;

    public NoFall() {
        super("No Fall", -1, Category.PLAYER, false);

    }



    @EventTarget
    public void onUpdate(EventUpdate e) {
        ClientPlayerEntity player = mc.player;
        if(player.fallDistance <= (player.isFallFlying() ? 1 : 2) && (player.fallDistance >= 2))
            return;

        if(player.isFallFlying() && player.isSneaking()
                && !isFallingFastEnoughToCauseDamage(player))
            return;

        player.networkHandler.sendPacket(new PlayerMoveC2SPacket(true));


    if (PlayerMoveC2SPacket) {
        player.networkHandler.sendPacket(new PlayerMoveC2SPacket(true));
    }




    }

    private boolean isFallingFastEnoughToCauseDamage(ClientPlayerEntity player)
    {
        return player.getVelocity().y < -0.5;

    }

}
