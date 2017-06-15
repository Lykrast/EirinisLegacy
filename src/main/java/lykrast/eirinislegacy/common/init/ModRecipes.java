package lykrast.eirinislegacy.common.init;

import lykrast.eirinislegacy.common.util.Config;
import lykrast.eirinislegacy.common.util.FuelHandler;
import lykrast.eirinislegacy.common.util.RecipeHelper;
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
	
	private static ItemStack animiteOre = new ItemStack(ModBlocks.animiteOre);
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
	
	private static ItemStack machineCasing = new ItemStack(ModBlocks.machineCasing);
	private static ItemStack machineCasingAdvanced = new ItemStack(ModBlocks.machineCasingAdvanced);

	public static void init()
	{
		initOreDictionary();
		initCrafting();
		initSmelting();
		initFuel();
	}

	private static void initOreDictionary()
	{
		OreDictionary.registerOre("stonePetramite", petramite);
		OreDictionary.registerOre("oreAnimite", animiteOre);
		OreDictionary.registerOre("gemAnimite", animite);
		OreDictionary.registerOre("blockAnimite", animiteBlock);
		OreDictionary.registerOre("nuggetPhantium", phantiumNugget);
		OreDictionary.registerOre("ingotPhantium", phantiumIngot);
		OreDictionary.registerOre("blockPhantium", phantiumBlock);
	}
	
	private static void initCrafting()
	{
		ItemStack stick = new ItemStack(Items.STICK);
		
		// Compression
		RecipeHelper.add2x2Compression(petramiteChunk, petramite);
		RecipeHelper.add3x3Compression(animite, animiteBlock);
		RecipeHelper.add3x3Compression(coalImbued, coalImbuedBlock);
		RecipeHelper.add3x3Compression(new ItemStack(ModItems.corpora), new ItemStack(ModBlocks.corporaBlock));
		RecipeHelper.add3x3Compression(phantiumIngot, phantiumBlock);
		RecipeHelper.add3x3Compression(phantiumNugget, phantiumIngot);
		RecipeHelper.add3x3Compression(spectralResidue, spectralCrystal);
		RecipeHelper.add3x3Compression(spectralCrystal, spectralCrystalBlock);
		
		// Easy Imbuing
		if (Config.easyImbuing)
		{
			RecipeHelper.addShapelessRecipe(coalImbued, animite, Items.COAL, Items.COAL);
			RecipeHelper.addShapelessRecipe(coalImbuedBlock, animiteBlock, Blocks.COAL_BLOCK, Blocks.COAL_BLOCK);
			RecipeHelper.addShapelessRecipe(new ItemStack(ModItems.corporaSeeds, 4), animite, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS);
			RecipeHelper.addShapelessRecipe(phantiumIngot, animite, Items.GOLD_INGOT);
			RecipeHelper.addShapelessRecipe(phantiumBlock, animiteBlock, Blocks.GOLD_BLOCK);
		}

		// Petramite stuff
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramiteReceptacle, 5), 3, 3, 
				null, petramiteChunk, null, 
				petramiteChunk, petramiteChunk, petramiteChunk, 
				null, petramiteChunk, null);
		RecipeHelper.addShapedRecipe(petramiteRod, 1, 2, petramiteChunk, petramiteChunk);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramiteRod, 4), 1, 2, petramite, petramite);
		
		// Tools
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramiteAxe), 2, 3, 
				petramite, petramite, 
				petramite, stick, 
				null, stick);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramiteHoe), 2, 3, 
				petramite, petramite, 
				null, stick, 
				null, stick);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramitePickaxe), 3, 3, 
				petramite, petramite, petramite, 
				null, stick, null, 
				null, stick, null);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramiteShovel), 1, 3, petramite, stick, stick);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.petramiteSword), 1, 3, petramite, petramite, stick);
		
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.phantiumAxe), 2, 3, 
				phantiumIngot, phantiumIngot, 
				phantiumIngot, petramiteRod, 
				null, petramiteRod);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.phantiumHoe), 2, 3, 
				phantiumIngot, phantiumIngot, 
				null, petramiteRod, 
				null, petramiteRod);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.phantiumPickaxe), 3, 3, 
				phantiumIngot, phantiumIngot, phantiumIngot, 
				null, petramiteRod, null, 
				null, petramiteRod, null);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.phantiumShovel), 1, 3, phantiumIngot, petramiteRod, petramiteRod);
		RecipeHelper.addShapedRecipe(new ItemStack(ModItems.phantiumSword), 1, 3, phantiumIngot, phantiumIngot, petramiteRod);

		// Machines
		RecipeHelper.addShapedRecipe(machineCasing, 3, 3, 
				petramiteChunk, petramiteChunk, petramiteChunk, 
				petramiteChunk, animite, petramiteChunk, 
				petramiteChunk, petramiteChunk, petramiteChunk);
		RecipeHelper.addShapedRecipe(machineCasingAdvanced, 3, 3, 
				phantiumIngot, petramiteChunk, phantiumIngot, 
				petramiteChunk, machineCasing, petramiteChunk, 
				phantiumIngot, petramiteChunk, phantiumIngot);
		
		if (Config.decorationEnabled)
		{
			ItemStack petramiteBrick = new ItemStack(ModItems.petramiteBrick);
			ItemStack petramitePolished = new ItemStack(ModBlocks.petramiteDecoration, 1, 0);
			ItemStack petramiteTilesBig = new ItemStack(ModBlocks.petramiteDecoration, 1, 1);
			ItemStack petramiteBricksBig = new ItemStack(ModBlocks.petramiteDecoration, 1, 3);
			ItemStack petramiteBricksSmall = new ItemStack(ModBlocks.petramiteDecoration, 1, 4);
			
			RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.petramiteDecoration, 4, 1), 2, 2, 
					petramitePolished, petramitePolished, 
					petramitePolished, petramitePolished);
			RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.petramiteDecoration, 4, 2), 2, 2, 
					petramiteTilesBig, petramiteTilesBig, 
					petramiteTilesBig, petramiteTilesBig);
			RecipeHelper.addShapedRecipe(petramiteBricksBig, 2, 2, 
					petramiteBrick, petramiteBrick, 
					petramiteBrick, petramiteBrick);
			RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.petramiteDecoration, 4, 4), 2, 2, 
					petramiteBricksBig, petramiteBricksBig, 
					petramiteBricksBig, petramiteBricksBig);
			RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.petramiteDecoration, 2, 5), 2, 1, 
					petramiteBricksSmall, petramiteBricksSmall);
			RecipeHelper.addShapedRecipe(new ItemStack(ModBlocks.petramiteDecoration, 3, 6), 3, 3, 
					petramiteBrick, petramiteBrick, petramiteBrick, 
					petramiteBrick, petramitePolished, petramiteBrick, 
					petramiteBrick, petramiteBrick, petramiteBrick);
		}
	}
	
	private static void initSmelting()
	{
		GameRegistry.addSmelting(animiteOre, animite, 1.0F);
		
		if (Config.decorationEnabled)
		{
			GameRegistry.addSmelting(petramiteChunk, new ItemStack(ModItems.petramiteBrick), 0);
			GameRegistry.addSmelting(petramite, new ItemStack(ModBlocks.petramiteDecoration, 1, 0), 0);
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
