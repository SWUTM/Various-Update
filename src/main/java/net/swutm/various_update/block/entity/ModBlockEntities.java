package net.swutm.various_update.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.various_update.block.ModBlocks;
import net.swutm.various_update.block.entity.custom.ModSignBlockEntity;
import net.swutm.various_update.various_update;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, various_update.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.STRIPPED_BAMBOO_WALL_SIGN.get(),
                            ModBlocks.STRIPPED_BAMBOO_SIGN.get(),
                            ModBlocks.CHISELED_STRIPPED_BAMBOO_WALL_SIGN.get(),
                            ModBlocks.CHISELED_STRIPPED_BAMBOO_SIGN.get(),
                            ModBlocks.BAMBOO_WALL_SIGN.get(),
                            ModBlocks.BAMBOO_SIGN.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
