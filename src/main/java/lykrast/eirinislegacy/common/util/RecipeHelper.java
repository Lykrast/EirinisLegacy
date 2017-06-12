/**
 * Original made by jaquadro for Storage Drawers
 * https://github.com/jaquadro/StorageDrawers
*/
package lykrast.eirinislegacy.common.util;

import lykrast.eirinislegacy.core.EirinisLegacy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreIngredient;

public class RecipeHelper
{
    private static int index = 0;

    public static void addShapedRecipe(ItemStack output, int w, int h, Object... input) {
        addRecipe(buildShapedRecipe(output, w, h, input));
    }

    public static void addShapelessRecipe(ItemStack output, Object... input) {
        addRecipe(new ShapelessRecipes(String.valueOf(index), output, buildInput(input)));
    }
    
    public static void add2x2Compression(ItemStack uncompressed, ItemStack compressed)
    {
    	addShapedRecipe(compressed, 2, 2, 
    			uncompressed, uncompressed, 
    			uncompressed, uncompressed);
    	addShapelessRecipe(new ItemStack(uncompressed.getItem(), 4), compressed);
    }
    public static void add3x3Compression(ItemStack uncompressed, ItemStack compressed)
    {
    	addShapedRecipe(compressed, 3, 3, 
    			uncompressed, uncompressed, uncompressed, 
    			uncompressed, uncompressed, uncompressed, 
    			uncompressed, uncompressed, uncompressed);
    	addShapelessRecipe(new ItemStack(uncompressed.getItem(), 9), compressed);
    }

    private static void addRecipe (IRecipe recipe) {
        CraftingManager.func_193372_a(new ResourceLocation(EirinisLegacy.MODID, "recipe" + index++), recipe);
    }

    private static ShapedRecipes buildShapedRecipe (ItemStack output, int w, int h, Object[] input) {
        if (w * h != input.length)
            throw new UnsupportedOperationException("Recipe input does not match dimensions");

        return new ShapedRecipes(String.valueOf(index), w, h, buildInput(input), output);
    }

    private static NonNullList<Ingredient> buildInput (Object[] input) {
        NonNullList<Ingredient> list = NonNullList.create();
        for (int i = 0; i < input.length; i++) {
            Object obj = input[i];
            if (obj instanceof String)
                list.add(i, new OreIngredient((String)obj));
            else if (obj instanceof ItemStack)
                list.add(i, Ingredient.func_193369_a((ItemStack)obj));
            else if (obj instanceof Item)
                list.add(i, Ingredient.func_193367_a((Item)obj));
            else if (obj instanceof Block)
                list.add(i, Ingredient.func_193369_a(new ItemStack((Block)obj)));
            else
                list.add(i, Ingredient.field_193370_a);
        }

        return list;
    }
}
