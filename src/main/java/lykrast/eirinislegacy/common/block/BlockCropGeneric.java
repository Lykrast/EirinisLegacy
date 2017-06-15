package lykrast.eirinislegacy.common.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCropGeneric extends BlockCrops {
	
	protected Item crop, seed;
	protected int maxAge;
	
	public BlockCropGeneric(Item crop, Item seed) {
		this(crop,seed,7);
	}
	
	public BlockCropGeneric(Item crop, Item seed, int maxAge) {
		super();
		this.crop = crop;
		this.seed = seed;
		this.maxAge = maxAge;
	}

	@Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, (IPlantable) Blocks.WHEAT);
    }

	@Override
	public Item getSeed() {
		return seed;
	}

	@Override
	public Item getCrop() {
		return crop;
	}
	
	@Override
	public int getMaxAge()
	{
		return maxAge;
	}

}
