package lykrast.eirinislegacy.common.init;

import lykrast.eirinislegacy.common.util.Config;
import lykrast.eirinislegacy.common.util.FuelHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipes {

	private static ItemStack petramite = new ItemStack(ModBlocks.petramite);
	private static ItemStack petramiteChunk = new ItemStack(ModItems.petramiteChunk);
	private static ItemStack petramiteRod = new ItemStack(ModItems.petramiteRod);
	
	private static ItemStack animite = new ItemStack(ModItems.animite);
	private static ItemStack animiteBlock = new ItemStack(ModBlocks.animiteBlock);
	private static ItemStack coalImbued = new ItemStack(ModItems.coalImbued);
	private static ItemStack coalImbuedBlock = new ItemStack(ModBlocks.coalImbuedBlock);
	
	private static ItemStack phantiumNugget = new ItemStack(ModItems.phantiumNugget);
	private static ItemStack phantiumIngot = new ItemStack(ModItems.phantiumIngot);
	private static ItemStack phantiumBlock = new ItemStack(ModBlocks.phantiumBlock);
	
	private static ItemStack spectralResidue = new ItemStack(ModItems.spectralResidue);
	private static ItemStack spectralCrystal = new ItemStack(ModItems.spectralCrystal);
	private static ItemStack spectralCrystalBlock = new ItemStack(ModBlocks.spectralCrystalBlock);
	
	private static ItemStack machineCasing = new ItemStack(ModBlocks.machineCasing, 1, 0);
	private static ItemStack machineCasingAdvanced = new ItemStack(ModBlocks.machineCasing, 1, 1);
	
	private static ItemStack staffBase = new ItemStack(ModItems.staffBase);

	public static void init()
	{
		initOreDictionary();
		//initCrafting();
		initSmelting();
		initFuel();
	}

	private static void initOreDictionary()
	{
		OreDictionary.registerOre("stonePetramite", petramite);
		OreDictionary.registerOre("stickPetramite", petramiteRod);
		OreDictionary.registerOre("oreAnimite", ModBlocks.animiteOre);
		OreDictionary.registerOre("gemAnimite", animite);
		OreDictionary.registerOre("blockAnimite", animiteBlock);
		OreDictionary.registerOre("nuggetPhantium", phantiumNugget);
		OreDictionary.registerOre("ingotPhantium", phantiumIngot);
		OreDictionary.registerOre("blockPhantium", phantiumBlock);
	}
	
//	private static void initCrafting()
//	{
//		ItemStack stick = new ItemStack(Items.STICK);
//		
//		// Easy Imbuing
//		if (Config.easyImbuing)
//		{
//			RecipeHelper.addShapelessRecipe(coalImbued, animite, Items.COAL, Items.COAL);
//			RecipeHelper.addShapelessRecipe(coalImbuedBlock, animiteBlock, Blocks.COAL_BLOCK, Blocks.COAL_BLOCK);
//			RecipeHelper.addShapelessRecipe(new ItemStack(ModItems.corporaSeeds, 4), animite, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS);
//			RecipeHelper.addShapelessRecipe(phantiumIngot, animite, Items.GOLD_INGOT);
//			RecipeHelper.addShapelessRecipe(phantiumBlock, animiteBlock, Blocks.GOLD_BLOCK);
//		}
//		
//		// Staves
//		if (Config.easyAssembling)
//		{
//			RecipeHelper.addShapelessRecipe(new ItemStack(ModItems.staffBuilder), staffBase, petramite, Blocks.GLASS, Blocks.GLOWSTONE, Blocks.STONE);
//			RecipeHelper.addShapelessRecipe(new ItemStack(ModItems.staffDestruction), staffBase, Items.IRON_PICKAXE, Blocks.TNT, Items.LAVA_BUCKET, Blocks.CACTUS);
//			RecipeHelper.addShapelessRecipe(new ItemStack(ModItems.staffFlying), staffBase, Items.SLIME_BALL, Items.FEATHER, Items.STRING, Items.IRON_BOOTS);
//			RecipeHelper.addShapelessRecipe(new ItemStack(ModItems.staffFireball), staffBase, Items.FLINT_AND_STEEL, Items.BLAZE_POWDER, Blocks.NETHERRACK, Items.COAL);
//		}
//	}
	
	private static void initSmelting()
	{
		GameRegistry.addSmelting(ModBlocks.animiteOre, animite, 1.0F);
		
		if (Config.decorationEnabled)
		{
			GameRegistry.addSmelting(petramiteChunk, new ItemStack(ModItems.petramiteBrick), 0.1F);
			//Polished
			GameRegistry.addSmelting(petramite, new ItemStack(ModBlocks.petramiteDecoration, 1, 0), 0.1F);
		}
	}

	private static void initFuel()
	{
		FuelHandler fuelHandler = new FuelHandler();
		fuelHandler.addFuel(ModItems.coalImbued, 3200);
		fuelHandler.addFuel(ModBlocks.coalImbuedBlock, 32000);

		GameRegistry.registerFuelHandler(fuelHandler);
	}

}
