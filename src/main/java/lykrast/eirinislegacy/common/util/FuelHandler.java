package lykrast.eirinislegacy.common.util;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
	
	private Map<Item, Integer> fuelList = new HashMap<Item, Integer>();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel == null) {return 0;}        
        Item item = fuel.getItem();
        if (item == null) {return 0;}
        
        // see if the item in general is registered
        if (fuelList.containsKey(item))
        {
            return fuelList.get(item);
        }
        
        // otherwise no value as fuel
        return 0;
	}
	
	public void addFuel(Item item, int value)
	{
		fuelList.put(item, value);
	}
	
	public void addFuel(Block block, int value)
	{
		addFuel(Item.getItemFromBlock(block), value);
	}

}
