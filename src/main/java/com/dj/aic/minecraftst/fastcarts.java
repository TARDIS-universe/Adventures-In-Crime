package com.dj.aic.minecraftst;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.server.world.ServerWorld;

public class fastcarts implements ModInitializer {

    @Override
    public void onInitialize() {
        // register a server tick event to modify minecarft speed
        ServerTickEvents.END_WORLD_TICK.register(this::onEndWorldTick);
    }

    private void onEndWorldTick(ServerWorld world) {
        // sends shit over all minecart entities in the world
        world.getEntitiesByType(EntityType.MINECART, minecart -> true)
                .forEach(minecart -> {
                    // Set custom speed here, e.g., 1.0D for faster minecarts
                    minecart.setVelocity(minecart.getVelocity().multiply(2.5)); // Multiply speed by 2.5
                });
    }
}
