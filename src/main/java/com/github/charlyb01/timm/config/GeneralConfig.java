package com.github.charlyb01.timm.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "general")
public class GeneralConfig implements ConfigData {
    @ConfigEntry.BoundedDiscrete(max = 600)
    public int minDelay = 120;
    @ConfigEntry.BoundedDiscrete(max = 600)
    public int maxDelay = 300;

    public boolean printOnSkip = true;

    @ConfigEntry.Gui.Excluded
    public boolean debugLog = false;
}
