package lykrast.eirinislegacy.common.item;

import java.util.Random;

import lykrast.eirinislegacy.common.init.ModItems;
import lykrast.eirinislegacy.common.util.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSwordPhantium extends ItemSwordGeneric {

	public ItemSwordPhantium(ToolMaterial material) {
		super(material);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		if (Config.phantiumSwordDrop == 0) return super.hitEntity(stack, target, attacker);
		World world = target.getEntityWorld();
		if (world.isRemote) return super.hitEntity(stack, target, attacker);
		
		Random random = world instanceof World ? ((World)world).rand : new Random();
		if (random.nextInt(Config.phantiumSwordDrop) == 0)
		{
			BlockPos pos = target.getPosition();
			
			EntityItem residue = new EntityItem(world, pos.getX(), pos.getY() + 0.5, pos.getZ(), new ItemStack(ModItems.spectralResidue));
			world.spawnEntity(residue);
		}
		
		return super.hitEntity(stack, target, attacker);
	}

}
