package com.github.charlyb01.timm.client.music;

import com.github.charlyb01.timm.Timm;
import com.github.charlyb01.timm.config.ModConfig;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class BiomePlaylist {
    public static final HashMap<Identifier, ArrayList<Identifier>> EVENTS_BY_BIOME = new HashMap<>();

    public static void init() {
        Timm.LOGGER.info("Initializing biome playlists");

        Path path = getPath();
        if (path == null) return;

        try {
            JsonReader jsonReader = new JsonReader(new FileReader(path.toString()));
            while (jsonReader.hasNext()) {
                JsonToken jsonToken = jsonReader.peek();
                if (jsonToken == JsonToken.BEGIN_OBJECT) {
                    jsonReader.beginObject();
                } else if (jsonToken == JsonToken.END_OBJECT) {
                    jsonReader.endObject();
                } else {
                    String biomeName = jsonReader.nextName();
                    Identifier biomeId = new Identifier(biomeName);
                    ArrayList<Identifier> musics = new ArrayList<>();

                    if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            String musicId = jsonReader.nextString();
                            musics.add(new Identifier(musicId));
                        }
                        jsonReader.endArray();
                    }

                    EVENTS_BY_BIOME.put(biomeId, musics);
                }
            }
        } catch (IOException e) {
            Timm.LOGGER.error("Error reading biome playlist file: {}", e.getMessage());
        }

        Timm.LOGGER.info("Biome playlists successfully initialized");
    }

    private static Path getPath() {
        FabricLoader loader = FabricLoader.getInstance();
        Path filePath = loader.getConfigDir()
                .resolve(Timm.MOD_ID)
                .resolve("biome_playlists.json");

        if (Files.exists(filePath)) {
            return filePath;
        }

        if (ModConfig.get().general.debugLog) {
            Timm.LOGGER.info("Player biome_playlist.json not found, using default one");
        }

        if (loader.getModContainer(Timm.MOD_ID).isEmpty()) {
            Timm.LOGGER.error("Mod not correctly loaded");
            return null;
        }

        ModContainer mod = loader.getModContainer(Timm.MOD_ID).get();
        Optional<Path> path = mod.findPath("assets/timm/custom/biome_playlists.json");
        if (path.isEmpty()) {
            Timm.LOGGER.error("Could not locate default biome_playlist.json");
            return null;
        }

        filePath = path.get();
        if (!Files.exists(filePath)) {
            Timm.LOGGER.error("Default biome_playlist.json does not exist");
            return null;
        }

        return filePath;
    }
}
