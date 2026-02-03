package com.explosion_wands.item_classes.block;

import com.explosion_wands.sticks_click_block.TNTStickFallingClickBlock;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class TNTStickFallingBlockItem extends Item {
    public TNTStickFallingBlockItem(Properties properties) {
        super(properties);
    }

    //Click on block
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        return TNTStickFallingClickBlock.use(this, level, player, hand);
    }
}
