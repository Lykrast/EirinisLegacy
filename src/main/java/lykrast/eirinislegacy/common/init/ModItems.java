package lykrast.eirinislegacy.common.init;

import lykrast.eirinislegacy.common.item.*;
import lykrast.eirinislegacy.common.util.Config;
import lykrast.eirinislegacy.common.util.CreativeTabEL;
import lykrast.eirinislegacy.common.util.CreativeTabELDecoration;
import lykrast.eirinislegacy.core.EirinisLegacy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static Item petramiteChunk, petramiteReceptacle, petramiteRod, 
		animite, coalImbued, corpora, 
		phantiumIngot, phantiumNugget, 
		spectralResidue, spectralCrystal;
	
	// Tools
	public static Item petramiteAxe, petramiteHoe, petramitePickaxe, petramiteShovel, petramiteSword, 
		phantiumAxe, phantiumHoe, phantiumPickaxe, phantiumShovel, phantiumSword;
	
	// Decoration module
	public static Item petramiteBrick;
	
	public static void init() {
		petramiteChunk = registerItem(new ItemGeneric(), "petramite_chunk");
		petramiteReceptacle = registerItem(new ItemGeneric(), "petramite_receptacle");
		petramiteRod = registerItem(new ItemGeneric(), "petramite_rod");
		
		animite = registerItem(new ItemGeneric(), "animite");
		coalImbued = registerItem(new ItemGeneric(), "coal_imbued");
		corpora = registerItem(new ItemFoodGeneric(3,4), "corpora");
		
		phantiumIngot = registerItem(new ItemGeneric(), "phantium_ingot");
		phantiumNugget = registerItem(new ItemGeneric(), "phantium_nugget");
		
		spectralResidue = registerItem(new ItemGeneric(), "spectral_residue");
		spectralCrystal = registerItem(new ItemGeneric(), "spectral_crystal");
		
		// Tools
		petramiteAxe = registerItem(new ItemAxeGeneric(ModToolMaterials.PETRAMITE), "petramite_axe");
		petramiteHoe = registerItem(new ItemHoeGeneric(ModToolMaterials.PETRAMITE), "petramite_hoe");
		petramitePickaxe = registerItem(new ItemPickaxeGeneric(ModToolMaterials.PETRAMITE), "petramite_pickaxe");
		petramiteShovel = registerItem(new ItemShovelGeneric(ModToolMaterials.PETRAMITE), "petramite_shovel");
		petramiteSword = registerItem(new ItemSwordGeneric(ModToolMaterials.PETRAMITE), "petramite_sword");
		
		phantiumAxe = registerItem(new ItemAxePhantium(ModToolMaterials.PHANTIUM), "phantium_axe");
		phantiumHoe = registerItem(new ItemHoePhantium(ModToolMaterials.PHANTIUM), "phantium_hoe");
		phantiumPickaxe = registerItem(new ItemPickaxePhantium(ModToolMaterials.PHANTIUM), "phantium_pickaxe");
		phantiumShovel = registerItem(new ItemShovelPhantium(ModToolMaterials.PHANTIUM), "phantium_shovel");
		phantiumSword = registerItem(new ItemSwordPhantium(ModToolMaterials.PHANTIUM), "phantium_sword");
		
		if (Config.decorationEnabled)
		{
			petramiteBrick = registerItem(new ItemGeneric(), "petramite_brick", CreativeTabELDecoration.instance);
		}
    }

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		((ItemGeneric) petramiteChunk).initModel();
		((ItemGeneric) petramiteReceptacle).initModel();
		((ItemGeneric) petramiteRod).initModel();
		
		((ItemGeneric) animite).initModel();
		((ItemGeneric) coalImbued).initModel();
		((ItemFoodGeneric) corpora).initModel();
		
		((ItemGeneric) phantiumIngot).initModel();
		((ItemGeneric) phantiumNugget).initModel();
		
		((ItemGeneric) spectralResidue).initModel();
		((ItemGeneric) spectralCrystal).initModel();
		
		((ItemAxeGeneric) petramiteAxe).initModel();
		((ItemHoeGeneric) petramiteHoe).initModel();
		((ItemPickaxeGeneric) petramitePickaxe).initModel();
		((ItemShovelGeneric) petramiteShovel).initModel();
		((ItemSwordGeneric) petramiteSword).initModel();
		
		((ItemAxeGeneric) phantiumAxe).initModel();
		((ItemHoeGeneric) phantiumHoe).initModel();
		((ItemPickaxeGeneric) phantiumPickaxe).initModel();
		((ItemShovelGeneric) phantiumShovel).initModel();
		((ItemSwordGeneric) phantiumSword).initModel();
		
		if (Config.decorationEnabled)
		{
			((ItemGeneric) petramiteBrick).initModel();
		}
	}
	
	public static Item registerItem(Item item, String name)
	{
		return registerItem(item,name,CreativeTabEL.instance);
	}
	
	public static Item registerItem(Item item, String name, CreativeTabs tab)
	{
        item.setRegistryName(name);
		item.setUnlocalizedName(EirinisLegacy.MODID + "." + name);
        
        GameRegistry.register(item);
        
        if (tab != null) item.setCreativeTab(tab);
        
		return item;
	}
}
