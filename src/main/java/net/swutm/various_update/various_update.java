package net.swutm.various_update;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.swutm.various_update.block.ModBlocks;
import net.swutm.various_update.block.entity.ModBlockEntities;
import net.swutm.various_update.block.entity.ModWoodTypes;
import net.swutm.various_update.item.ModItems;
import org.slf4j.Logger;

import java.util.stream.Collectors;

@Mod(various_update.MOD_ID)
public class various_update
{
    public static final String MOD_ID = "various_update";
    private static final Logger LOGGER = LogUtils.getLogger();

    public various_update()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModBlockEntities.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::setup);

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        WoodType.register(ModWoodTypes.BAMBOO);
        WoodType.register(ModWoodTypes.STRIPPED_BAMBOO);
        WoodType.register(ModWoodTypes.CHISELED_STRIPPED_BAMBOO);

        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }




    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.BAMBOO);
            Sheets.addWoodType(ModWoodTypes.STRIPPED_BAMBOO);
            Sheets.addWoodType(ModWoodTypes.CHISELED_STRIPPED_BAMBOO);
        });
    }
}
