package com.techsupportred;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class KebabsDelight implements ModInitializer {
    public static final Item SHISHKEBAB = new ConsumableItem(new FabricItemSettings().maxCount(64).recipeRemainder(Items.STICK)
			.food(new FoodComponent.Builder().hunger(10).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(
    				EffectsRegistry.NOURISHMENT.get(), 1800), 1).build()),true);
	public static final Item SHAWARMA = new ConsumableItem(new FabricItemSettings().maxCount(64).recipeRemainder(Items.BREAD)
			.food(new FoodComponent.Builder().hunger(13).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(
					EffectsRegistry.NOURISHMENT.get(), 1800), 1).build()),true);
	public static final Item GRILLEDCHICKEN = new ConsumableItem(new FabricItemSettings().maxCount(64).recipeRemainder(Items.FEATHER)
			.food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(
					EffectsRegistry.NOURISHMENT.get(), 200), 1).build()),true);

    public static final ItemGroup KEBABS_DELIGHT = FabricItemGroup.builder().icon(() -> new ItemStack(SHISHKEBAB))
    		.displayName(Text.translatable("itemGroup.techsupportred.kebabs_delight")).build();
	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("techsupportred", "shishkebab"), SHISHKEBAB);
		Registry.register(Registries.ITEM, new Identifier("techsupportred", "shawarma"), SHAWARMA);
		Registry.register(Registries.ITEM, new Identifier("techsupportred", "grilledchicken"), GRILLEDCHICKEN);
		Registry.register(Registries.ITEM_GROUP, new Identifier("techsupportred", "kebabs_delight"), KEBABS_DELIGHT);
		ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(KEBABS_DELIGHT).get()).register(content -> content.addAfter(Items.COOKED_BEEF,SHISHKEBAB, SHAWARMA, GRILLEDCHICKEN));
	}
}