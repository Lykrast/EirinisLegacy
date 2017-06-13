package lykrast.eirinislegacy.common.item;

import lykrast.eirinislegacy.common.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ItemSeedCorpora extends ItemSeedGeneric {

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return ModBlocks.corporaCrop.getDefaultState();
	}

}
