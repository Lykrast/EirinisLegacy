package lykrast.eirinislegacy.common.item;

import lykrast.eirinislegacy.common.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStaffBuilder extends ItemStaffGeneric {

	public ItemStaffBuilder(int max, int use) {
		super(max, use);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		if (!hasEnoughEnergy(itemstack)) return EnumActionResult.FAIL;
		
		BlockPos location = pos.offset(facing);
		if (!player.canPlayerEdit(location, facing, itemstack)) return EnumActionResult.FAIL;
		else
		{
			if (worldIn.isAirBlock(location))
			{
				worldIn.playSound(player, location, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

		        if (!worldIn.isRemote)
		        {
		            worldIn.setBlockState(location, ModBlocks.spectralBlock.getDefaultState(), 11);
		            useEnergy(itemstack, player);
		        }
                return EnumActionResult.SUCCESS;
			}
			return EnumActionResult.PASS;
		}
	}

}
