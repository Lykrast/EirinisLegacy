package lykrast.eirinislegacy.common.world;

import java.util.Random;

import com.google.common.base.Predicate;

import lykrast.eirinislegacy.common.block.BlockAnimiteOre;
import lykrast.eirinislegacy.common.init.ModBlocks;
import lykrast.eirinislegacy.common.util.Config;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOre implements IWorldGenerator {

	public WorldGenOre() {
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		//Only generate in Overworld for now
		if (world.provider.getDimension() == 0)
		{
			genOverworld(world, random, chunkX, chunkZ);
		}
	}
	
	private void genOverworld(World world, Random random, int chunkX, int chunkZ)
	{
		addOreSpawnPetra(ModBlocks.petramite.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 
				Config.genPetramiteMaxVein, Config.genPetramiteCount, Config.genPetramiteMinY, Config.genPetramiteMaxY, BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(ModBlocks.animiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 
				Config.genAnimiteMaxVein, Config.genAnimiteCount, Config.genAnimiteMinY, Config.genAnimiteMaxY, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	private void addOreSpawnPetra(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, 
			int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn)
	{
		int diffY = maxY - minY;
		for (int i=0;i<chance;i++)
		{
			int posX = blockXPos * 16 + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffY);
			int posZ = blockZPos * 16 + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize, blockToSpawnIn).generate(world, random, new BlockPos(posX, posY, posZ));
			
			if (Config.genAnimitePetramiteChance > 0 && Config.genAnimitePetramiteMaxVein > 0 && random.nextInt(Config.genAnimitePetramiteChance) == 0)
			{
				new WorldGenMinable(ModBlocks.animiteOre.getDefaultState().withProperty(BlockAnimiteOre.VARIANT, BlockAnimiteOre.VariantsAnimiteOre.PETRAMITE), 
						Config.genAnimitePetramiteMaxVein, BlockMatcher.forBlock(ModBlocks.petramite)).generate(world, random, new BlockPos(posX, posY, posZ));
			}
		}
	}
	
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, 
			int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn)
	{
		int diffY = maxY - minY;
		for (int i=0;i<chance;i++)
		{
			int posX = blockXPos * 16 + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffY);
			int posZ = blockZPos * 16 + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize, blockToSpawnIn).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, 
			int maxVeinSize, float chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn)
	{
		if (chance >= 1) addOreSpawn(block, world, random, blockXPos, blockZPos, maxX, maxZ, maxVeinSize, Math.round(chance), minY, maxY, blockToSpawnIn);
		else
		{
			if (random.nextFloat() <= chance) 
				addOreSpawn(block, world, random, blockXPos, blockZPos, maxX, maxZ, maxVeinSize, 1, minY, maxY, blockToSpawnIn);
		}
	}

}
