package lykrast.eirinislegacy.common.util;

import lykrast.eirinislegacy.common.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabEL extends CreativeTabs {
	
	public static final CreativeTabs instance = new CreativeTabEL(CreativeTabs.getNextID(), "tabEirinisLegacy");

	public CreativeTabEL(int index, String label) {
		super(index, label);
	}
	
	@Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModItems.animite);
    }

}
