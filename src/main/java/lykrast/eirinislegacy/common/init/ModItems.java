package lykrast.eirinislegacy.common.init;

import java.util.ArrayList;
import java.util.List;

import lykrast.eirinislegacy.common.item.*;
import lykrast.eirinislegacy.common.util.Config;
import lykrast.eirinislegacy.common.util.CreativeTabEL;
import lykrast.eirinislegacy.common.util.CreativeTabELDecoration;
import lykrast.eirinislegacy.core.EirinisLegacy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	
	public static Item petramiteChunk, petramiteReceptacle, petramiteRod, 
		animite, coalImbued, corpora, corporaSeeds, 
		phantiumIngot, phantiumNugget, 
		spectralResidue, spectralCrystal, 
		staffBase, staffBuilder, staffDestruction, staffFlying, staffFireball;
	private static final List<Item> itemList = new ArrayList<Item>();
	
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
		corporaSeeds = registerItem(new ItemSeedCorpora(), "corpora_seeds");
		
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
		
		staffBase = registerItem(new ItemGeneric(), "staff_base");
		staffBuilder = registerItem(new ItemStaffBuilder(12800,100), "staff_builder");
		staffDestruction = registerItem(new ItemStaffDestruction(12800,100), "staff_destruction");
		staffFlying = registerItem(new ItemStaffFlying(6400,100), "staff_flying");
		staffFireball = registerItem(new ItemStaffFireball(6400,100), "staff_fireball");
		
		if (Config.decorationEnabled)
		{
			petramiteBrick = registerItem(new ItemGeneric(), "petramite_brick", CreativeTabELDecoration.instance);
		}
    }

	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for (Item i : itemList) initModel(i);
	}

	@SideOnly(Side.CLIENT)
    public static void initModel(Item i) {
        ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
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
        
        itemList.add(item);
        
		return item;
	}
}
