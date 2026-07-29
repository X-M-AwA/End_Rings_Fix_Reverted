package com.end_rings_fix_reverted.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.DensityFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(DensityFunctions.EndIslandDensityFunction.class)
public abstract class DensityFunctionsMixin {
    @ModifyConstant(
            method = "getHeightValue",
            constant = @Constant(floatValue = -100.0F)
    )
    private static float seyValue(float constant, @Local(ordinal = 0, argsOnly = true) int subSectionX, @Local(ordinal = 1, argsOnly = true) int subSectionZ) {
        return 100.0F - Mth.sqrt(subSectionX * subSectionX + subSectionZ * subSectionZ) * 8.0F;
    }
}
