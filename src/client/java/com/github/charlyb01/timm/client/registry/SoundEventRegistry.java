package com.github.charlyb01.timm.client.registry;

import com.github.charlyb01.timm.Timm;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class SoundEventRegistry {
    public static final HashMap<Identifier, RegistryEntry<SoundEvent>> SOUNDEVENT_BY_ID = new HashMap<>();

    public static void init() {
        register("menu");

        register("badlands");
        register("bamboo_jungle");
        register("beach");
        register("birch_forest");
        register("cherry_grove");
        register("cold_ocean");
        register("dark_forest");
        register("deep_dark");
        register("desert");
        register("dripstone_caves");
        register("flower_forest");
        register("forest");
        register("ice_spikes");
        register("jungle");
        register("lush_caves");
        register("meadow");
        register("mountains");
        register("mushroom_fields");
        register("ocean");
        register("plains");
        register("river");
        register("savanna");
        register("snow_plains");
        register("swamp");
        register("taiga");
        register("warm_ocean");
        register("windy_hills");
        
        register("basalt_deltas");
        register("crimson_forest");
        register("nether_wastes");
        register("soul_sand_valley");

        register("end");
    }

    private static void register(final String path) {
        Identifier id = Timm.id(path);
        SOUNDEVENT_BY_ID.put(id, Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id)));
    }
}
