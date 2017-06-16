package lykrast.eirinislegacy.common.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStaffGeneric extends ItemGeneric {
	protected int useEnergy;
	
	public ItemStaffGeneric(int max, int use) {
		super();
        maxStackSize = 1;
        setMaxDamage(max);
        useEnergy = use;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
    protected void useEnergy(ItemStack stack, EntityLivingBase entityLiving)
    {
    	stack.damageItem(useEnergy, entityLiving);
    }
    
    protected boolean hasEnoughEnergy(ItemStack stack)
    {
    	return (stack.getItemDamage() <= getMaxDamage(stack) - useEnergy);
    }

}
