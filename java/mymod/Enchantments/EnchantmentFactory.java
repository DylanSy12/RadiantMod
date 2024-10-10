package mymod.Enchantments;

import java.util.Collections;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class EnchantmentFactory implements IRecipeFactory {

	@Override
	public IRecipe parse(final JsonContext context, final JsonObject json) {
		final String group = JsonUtils.getString(json, "group", "");
		final CraftingHelper.ShapedPrimer primer = CraftingHelper.parseShaped(context, json);
		JsonObject resultJson = JsonUtils.getJsonObject(json, "result");
		final ItemStack result = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "result"), context);

		String enchantName = JsonUtils.getString(resultJson, "enchantment");
	    int enchantLvl = JsonUtils.getInt(resultJson, "enchantment_lvl");

	    Enchantment enchantment = Enchantment.getEnchantmentByLocation(enchantName);
	    if (enchantment == null)
	    	throw new JsonSyntaxException("Unknown enchantment '" + enchantName + "'");

	    Map<Enchantment, Integer> enchMap = Collections.singletonMap(enchantment, enchantLvl);
	    EnchantmentHelper.setEnchantments(enchMap, result);
		return new ShapedRecipes(enchantName, enchantLvl, enchantLvl, null, result);
//		return new ShapedRecipes(group.isEmpty() ? null : new ResourceLocation(group), result, primer);
	}
}
