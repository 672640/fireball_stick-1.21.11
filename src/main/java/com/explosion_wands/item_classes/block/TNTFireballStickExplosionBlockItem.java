package com.explosion_wands.item_classes.block;

import com.explosion_wands.sticks_click_block.TNTFireballStickExplosionClickBlock;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class TNTFireballStickExplosionBlockItem extends Item {
    public TNTFireballStickExplosionBlockItem(Properties properties) {
        super(properties);
    }

    //Click on block
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        return TNTFireballStickExplosionClickBlock.use(this, level, player, hand);
    }
}
