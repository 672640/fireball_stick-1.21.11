package com.fireball_stick.item_classes.block;

import com.fireball_stick.sticks_click_block.TNTStickClickBlock;
import com.fireball_stick.sticks_click_block.TNTStickFallingBlock;
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
        return TNTStickFallingBlock.use(this, level, player, hand);
    }
}
