package lykrast.eirinislegacy.common.util;

import java.util.logging.Level;

import lykrast.eirinislegacy.core.CommonProxy;
import lykrast.eirinislegacy.core.EirinisLegacy;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "General";
	private static final String CATEGORY_TOOLS = "Tools";
	private static final String CATEGORY_WORLD = "World";
	
	public static boolean debug, decorationEnabled, easyImbuing, easyAssembling;
	public static int phantiumAxeDrop, phantiumHoeDrop, phantiumPickaxeDrop, phantiumShovelDrop, phantiumSwordDrop, 
		genPetramiteMaxVein, genPetramiteCount, genPetramiteMinY, genPetramiteMaxY, 
		genAnimiteMaxVein, genAnimiteCount, genAnimiteMinY, genAnimiteMaxY, 
		genAnimitePetramiteChance, genAnimitePetramiteMaxVein;
	
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
        cfg.addCustomCategoryComment(CATEGORY_WORLD, "World generation");
        
        // General
        debug = cfg.getBoolean("debug", CATEGORY_GENERAL, false, 
        		"Set to true to enable a lot of console output");
        decorationEnabled = cfg.getBoolean("decorationEnabled", CATEGORY_GENERAL, true, 
        		"Set to false to disable the Decoration module");
        easyImbuing = cfg.getBoolean("easyImbuing", CATEGORY_GENERAL, true, 
        		"Set to true to enable Imbuer recipes in a crafting table (not recommended if machines are enabled)");
        easyAssembling = cfg.getBoolean("easyAssembling", CATEGORY_GENERAL, true, 
        		"Set to true to enable Assembler recipes in a crafting table (not recommended if machines are enabled)");
        
        // Tools
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
        
        // World
        genPetramiteMaxVein = cfg.getInt("genPetramiteMaxVein", CATEGORY_WORLD, 33, 0, 64, 
        		"Maximum size (in blocks) of a single Petramite vein");
        genPetramiteCount = cfg.getInt("genPetramiteCount", CATEGORY_WORLD, 3, 0, 64, 
        		"Maximum number of Petramite veins in a single chunk");
        genPetramiteMinY = cfg.getInt("genPetramiteMinY", CATEGORY_WORLD, 24, 0, 255, 
        		"Minimum height (in blocks) at which Petramite veins will spawn");
        genPetramiteMaxY = cfg.getInt("genPetramiteMaxY", CATEGORY_WORLD, 48, 0, 255, 
        		"Maximum height (in blocks) at which Petramite veins will spawn");
        
        genAnimiteMaxVein = cfg.getInt("genAnimiteMaxVein", CATEGORY_WORLD, 5, 0, 64, 
        		"Maximum size (in blocks) of a single Animite vein");
        genAnimiteCount = cfg.getInt("genAnimiteCount", CATEGORY_WORLD, 2, 0, 64, 
        		"Maximum number of Animite veins in a single chunk");
        genAnimiteMinY = cfg.getInt("genAnimiteMinY", CATEGORY_WORLD, 24, 0, 255, 
        		"Minimum height (in blocks) at which Animite veins will spawn");
        genAnimiteMaxY = cfg.getInt("genAnimiteMaxY", CATEGORY_WORLD, 48, 0, 255, 
        		"Maximum height (in blocks) at which Animite veins will spawn");
        
        genAnimitePetramiteChance = cfg.getInt("genAnimitePetramiteChance", CATEGORY_WORLD, 4, 0, Integer.MAX_VALUE, 
        		"1 in X chance that a Petramite vein will have an Animite vein in its center, 0 to disable");
        genAnimitePetramiteMaxVein = cfg.getInt("genAnimitePetramiteMaxVein", CATEGORY_WORLD, 12, 0, 64, 
        		"Maximum size (in blocks) of a single Animite vein inside a Petramite vein");
    }
}
