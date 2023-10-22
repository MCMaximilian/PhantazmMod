package com.mcmaximilian.Phantazam.EventListener;

import com.mcmaximilian.Phantazam.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.mcmaximilian.Phantazam.Utils.Keybinds.CorneringState;

public class Cornering {

    private static final Player clientPlayer = Minecraft.getInstance().player;

    @Mod.EventBusSubscriber( modid = Main.MODID, value = Dist.CLIENT)
    public static class CorneringListener {

        @SubscribeEvent
        public static void onCheckPlayers( RenderPlayerEvent event) {
            if ( CorneringState.equalsIgnoreCase("on")) {
                Player player = event.getEntity();
                //noinspection DataFlowIssue
                if ( player != clientPlayer && player.distanceTo(clientPlayer) <= 4.0 ) {
                    event.setCanceled(true);
                }
            }
        }
        //TODO: Make player invisible

    }

}
