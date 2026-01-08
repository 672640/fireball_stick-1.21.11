package com.fireball_stick.item;

import com.fireball_stick.FireballStickClickBlock;
import com.fireball_stick.FireballStickItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Item;

public class ModItems {
//Creates the fireball_stick's identity
    public static final ResourceKey<Item> FIREBALL_STICK_KEY =
            ResourceKey.create(
                    Registries.ITEM,
                    Identifier.fromNamespaceAndPath(FireballStickClickBlock.MOD_ID, "fireball_stick")
            );
//Registers the fireball_stick
    public static final Item FIREBALL_STICK = Registry.register(
            BuiltInRegistries.ITEM,
            FIREBALL_STICK_KEY,
            new FireballStickItem(
                    new Item.Properties().stacksTo(1).setId(FIREBALL_STICK_KEY)
            )
    );
    //Initializes the item
    public static void init() {

    }
}
