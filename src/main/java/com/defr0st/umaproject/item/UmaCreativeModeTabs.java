package com.defr0st.umaproject.item;

import com.defr0st.umaproject.ProjectUMA;
import com.defr0st.umaproject.block.UmaBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UmaCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectUMA.MOD_ID);

    public static final Supplier<CreativeModeTab> UMA_ITEMS_TAB = CREATIVE_MODE_TAB.register("uma_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(UmaItems.UMA_SOUL.get()))
                    .title(Component.translatable("creativetab.umaproject.uma_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(UmaItems.UMA_SOUL);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> UMA_BLOCKS_TAB = CREATIVE_MODE_TAB.register("uma_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(UmaBlocks.UMA_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ProjectUMA.MOD_ID, "uma_items_tab"))
                    .title(Component.translatable("creativetab.umaproject.uma_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(UmaBlocks.UMA_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
