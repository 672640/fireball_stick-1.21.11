package com.fireball_stick.item;

import com.fireball_stick.FireballStickClickBlock;
import com.fireball_stick.FireballStickItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item FIREBALL_STICK = register(
            "fireball_stick",
            new FireballStickItem(new Item.Properties().stacksTo(1)));

    private static Item register(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(FireballStickClickBlock.MOD_ID, name),
                item
        );
    }

    public static void init() {

    }
}
