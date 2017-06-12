package lykrast.eirinislegacy.common.item;

import java.util.Random;

import lykrast.eirinislegacy.common.init.ModItems;
import lykrast.eirinislegacy.common.util.Config;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHoePhantium extends ItemHoeGeneric {

	public ItemHoePhantium(ToolMaterial material) {
		super(material);
	}

	// Based on Ellpack's drop chance for worms in Actually Additions
	// https://github.com/Ellpeck/ActuallyAdditions
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (Config.phantiumHoeDrop == 0) return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		if (worldIn.isRemote) return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);

		if (worldIn.isAirBlock(pos.up()))
		{
			IBlockState state = worldIn.getBlockState(pos);
			Random random = worldIn instanceof World ? ((World)worldIn).rand : new Random();
			if((state.getBlock() instanceof BlockGrass || state.getBlock() instanceof BlockDirt) && random.nextInt(Config.phantiumHoeDrop) == 0){
				EntityItem residue = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.spectralResidue));
				worldIn.spawnEntity(residue);
			}
		}

		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}

}
