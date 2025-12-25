package com.example.modstick;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.hurtingprojectile.LargeFireball;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;

public class ModStickClickAir extends Item {
    public ModStickClickAir(Item.Properties properties) {
        super(properties);
    }

    public static InteractionResult use(Item item, Level level, Player player, InteractionHand hand) {
        //ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        if (hitResult.getType() != Type.BLOCK && !level.isClientSide()) {
            level.playSound((Entity) null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    public static Projectile asProjectile(Item item, Level level, Player player, InteractionHand hand) {
        //ItemStack itemStack = player.getItemInHand(hand);
        BlockHitResult blockHitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        double dirX = player.getX();
        double dirY = player.getY();
        double dirZ = player.getZ();
        //Vec3 dir = new Vec3(dirX, dirY, dirZ);
        Vec3 playerLookDir = player.getLookAngle();
        Vec3 playerStartDir = player.getEyePosition();
        Vec3 playerEndDir = playerStartDir.add(playerLookDir.scale(5));
        playerLookDir.add(dirX, dirY, dirZ).normalize();
        //playerLookDir.add(0, 1000, 0).normalize();
        //SmallFireball fireball = new SmallFireball(level, dirX, dirY, dirZ, dir.normalize());;
        LargeFireball fireballAir = new LargeFireball(level, player, playerLookDir, 10);
        EntityHitResult entityHitResult = ProjectileUtil.getEntityHitResult(
                level, fireballAir, playerStartDir, playerEndDir, player.getBoundingBox().expandTowards(playerLookDir.scale(5.0)).inflate(1.0),
                entity -> entity instanceof LivingEntity && entity != player);

        if (blockHitResult.getType() != Type.BLOCK) {
            Vec3 fireballChangePosition = player.position().add(0, player.getEyeHeight() - 0.25, 0).add(playerLookDir.scale(2.5));
            fireballAir.moveOrInterpolateTo(fireballChangePosition);
            return fireballAir;

        } else if(blockHitResult.getType() != Type.BLOCK && entityHitResult != null){
            Vec3 fireballChangePosition = player.position().add(0, player.getEyeHeight() - 0.25, 0).add(playerLookDir.scale(2.5));
            fireballAir.moveOrInterpolateTo(entityHitResult.getLocation());
            return fireballAir;
        } else {
            return null;
        }
    }
}
