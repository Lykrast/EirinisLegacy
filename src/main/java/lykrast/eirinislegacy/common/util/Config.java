package lykrast.eirinislegacy.common.util;

import java.util.logging.Level;

import lykrast.eirinislegacy.core.CommonProxy;
import lykrast.eirinislegacy.core.EirinisLegacy;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "General";
	private static final String CATEGORY_TOOLS = "Tools";
	
	public static boolean debug, decorationEnabled;
	public static int phantiumAxeDrop, phantiumHoeDrop, phantiumPickaxeDrop, phantiumShovelDrop, phantiumSwordDrop;
	
	public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e) {
        	EirinisLegacy.logger.log(Level.WARNING, "Problem loading config file!", e);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
	}
	
	private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        cfg.addCustomCategoryComment(CATEGORY_TOOLS, "Tool configuration");
        
        debug = cfg.getBoolean("debug", CATEGORY_GENERAL, false, 
        		"Set to true to enable a lot of console output");
        decorationEnabled = cfg.getBoolean("decorationEnabled", CATEGORY_GENERAL, true, 
        		"Set to false to disable the Decoration module");
        
        phantiumAxeDrop = cfg.getInt("phantiumAxeDrop", CATEGORY_TOOLS, 5, 0, Integer.MAX_VALUE, 
        		"1 in X chance that the Phantium Axe will drop Spectral Residue when harvesting a valid block, 0 to disable");
        phantiumHoeDrop = cfg.getInt("phantiumHoeDrop", CATEGORY_TOOLS, 10, 0, Integer.MAX_VALUE, 
        		"1 in X chance that the Phantium Hoe will drop Spectral Residue when tiling dirt, 0 to disable");
        phantiumPickaxeDrop = cfg.getInt("phantiumPickaxeDrop", CATEGORY_TOOLS, 5, 0, Integer.MAX_VALUE, 
        		"1 in X chance that the Phantium Pickaxe will drop Spectral Residue when harvesting a valid block, 0 to disable");
        phantiumShovelDrop = cfg.getInt("phantiumShovelDrop", CATEGORY_TOOLS, 5, 0, Integer.MAX_VALUE, 
        		"1 in X chance that the Phantium Shovel will drop Spectral Residue when harvesting a valid block, 0 to disable");
        phantiumSwordDrop = cfg.getInt("phantiumSwordDrop", CATEGORY_TOOLS, 3, 0, Integer.MAX_VALUE, 
        		"1 in X chance that the Phantium Sword will drop Spectral Residue when hitting something, 0 to disable");
    }
}
