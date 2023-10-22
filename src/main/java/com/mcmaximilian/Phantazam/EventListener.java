package com.mcmaximilian.Phantazam;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.mcmaximilian.Phantazam.Keybinds.CorneringState;
import static com.mcmaximilian.Phantazam.Keybinds.ToggleCornering;

public class EventListener {

    @Mod.EventBusSubscriber( modid = Main.MODID, value = Dist.CLIENT)
    public static class EventHandler {

        @SubscribeEvent
        public static void onKeyInput( TickEvent.ClientTickEvent event) {
            if ( event.phase == TickEvent.Phase.END) {

                if ( ToggleCornering.consumeClick() ) {

                    if (CorneringState.equalsIgnoreCase("on")) {

                        CorneringState = "off";
                        net.minecraft.network.chat.Component component = Component.nullToEmpty("Cornering is off!");
//                    component.getStyle().withColor(ChatFormatting.YELLOW);
//                    component.getStyle().withBold( true);
                        Objects.requireNonNull(Minecraft.getInstance().player).sendSystemMessage(component);
                    }
                    else if ( CorneringState.equalsIgnoreCase("off")) {
                        CorneringState = "on";
                        net.minecraft.network.chat.Component component = Component.nullToEmpty("Cornering is on!");
//                    component.getStyle().withColor(ChatFormatting.YELLOW);
//                    component.getStyle().withBold( true);
                        Objects.requireNonNull(Minecraft.getInstance().player).sendSystemMessage(component);
                    }
                }
            }
        }
        //TODO: Toggle Keybinding

        @SuppressWarnings("rawtypes")
        @SubscribeEvent
        public static void onCheckPlayers( RenderPlayerEvent event) {
            if ( CorneringState.equalsIgnoreCase("on")) {
                event.setCanceled(true);
            }
        }
        //TODO: Make player invisible
    }


}
