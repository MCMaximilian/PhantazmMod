package com.mcmaximilian.Phantazam.EventListener;

import com.mcmaximilian.Phantazam.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.mcmaximilian.Phantazam.Utils.Keybinds.*;

public class KeyPress {
    private static final Player clientPlayer = Minecraft.getInstance().player;

    @Mod.EventBusSubscriber( modid = Main.MODID, value = Dist.CLIENT)
    public static class EventHandler {

        @SuppressWarnings("DataFlowIssue")
        @SubscribeEvent
        public static void onKeyInput( TickEvent.ClientTickEvent event) {
            if ( event.phase == TickEvent.Phase.END) {

                if ( ToggleCornering.consumeClick() ) {

                    if (CorneringState.equalsIgnoreCase("on")) {

                        CorneringState = "off";
                        net.minecraft.network.chat.Component component = Component.nullToEmpty("Cornering is off!");
//                    component.getStyle().withColor(ChatFormatting.YELLOW);
//                    component.getStyle().withBold( true);
                        clientPlayer.sendSystemMessage(component);
                    }
                    else if ( CorneringState.equalsIgnoreCase("off")) {
                        CorneringState = "on";
                        net.minecraft.network.chat.Component component = Component.nullToEmpty("Cornering is on!");
//                    component.getStyle().withColor(ChatFormatting.YELLOW);
//                    component.getStyle().withBold( true);
                        clientPlayer.sendSystemMessage(component);
                    }
                }
                //TODO: Toggle Cornering
            }
        }
        //TODO: Toggle Keybinding

    }


}

