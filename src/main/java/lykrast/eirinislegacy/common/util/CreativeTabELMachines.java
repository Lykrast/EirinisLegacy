package lykrast.eirinislegacy.common.util;

import lykrast.eirinislegacy.common.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabELMachines extends CreativeTabs {
	
	public static final CreativeTabs instance = new CreativeTabELMachines(CreativeTabs.getNextID(), "tabEirinisLegacyMachines");

	public CreativeTabELMachines(int index, String label) {
		super(index, label);
	}
	
	@Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ModBlocks.machineCasing, 1, 1);
    }

}
