package com.defr0st.umaproject.item;

import com.defr0st.umaproject.ProjectUMA;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProjectUMA.MOD_ID);

    public static final DeferredItem<Item> UMA_SOUL = ITEMS.register("uma_soul",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
