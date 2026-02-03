package com.explosion_wands.abstractClasses;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public abstract class BaseUseOn extends Item {
    //Currently unused. Will most likely be used later
    public BaseUseOn(Properties properties) {
        super(properties);
    }
    protected abstract void cast(UseOnContext context);
}
