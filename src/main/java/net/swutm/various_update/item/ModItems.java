package net.swutm.various_update.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swutm.various_update.block.ModBlocks;
import net.swutm.various_update.various_update;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, various_update.MOD_ID);

    public static final RegistryObject<Item> BAMBOO_SIGN = ITEMS.register("bamboo_sign",
            () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).stacksTo(16),
                    ModBlocks.BAMBOO_SIGN.get(), ModBlocks.BAMBOO_WALL_SIGN.get()));

    public static final RegistryObject<Item> STRIPPED_BAMBOO_SIGN = ITEMS.register("stripped_bamboo_sign",
            () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).stacksTo(16),
                    ModBlocks.STRIPPED_BAMBOO_SIGN.get(), ModBlocks.STRIPPED_BAMBOO_WALL_SIGN.get()));

    public static final RegistryObject<Item> CHISELED_STRIPPED_BAMBOO_SIGN = ITEMS.register("chiseled_stripped_bamboo_sign",
            () -> new SignItem(new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE).stacksTo(16),
                    ModBlocks.CHISELED_STRIPPED_BAMBOO_SIGN.get(), ModBlocks.CHISELED_STRIPPED_BAMBOO_WALL_SIGN.get()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
