package lykrast.eirinislegacy.common.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCropCorpora extends BlockCropGeneric {

	public BlockCropCorpora(Item crop, Item seed) {
		super(crop, seed);
	}
	
	public BlockCropCorpora(Item crop, Item seed, int maxAge) {
		super(crop, seed, maxAge);
	}
	
	public int getCropQuantity(Random rand)
	{
		return rand.nextInt(3) + 1;
	}
	
	@Override
	public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		java.util.List<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(getSeed()));
		int age = getAge(state);

		if (age >= getMaxAge()) {
			Random random = world instanceof World ? ((World)world).rand : new Random();
			ret.add(new ItemStack(getCrop(), getCropQuantity(random)));
		}

		return ret;
	}

}
