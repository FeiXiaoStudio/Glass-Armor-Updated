package feixiaostudio.glassarmor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GlassArmorItems {
    public static final Item GLASS_INGOT;
    public static final Item GLASS_HELMET;
    public static final Item GLASS_CHESTPLATE;
    public static final Item GLASS_LEGGINGS;
    public static final Item GLASS_BOOTS;
    
    public static Item register(String id, Item item) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(GlassArmor.MOD_ID, id);

        // Register the item and return it!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    static {
        GLASS_INGOT = register(
            "glass_ingot",
            new Item(new Item.Settings())
        );
        GLASS_HELMET = register(
            "glass_helmet",
            new ArmorItem(GlassArmorMaterials.GLASS_INGOT, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(GlassArmorMaterials.GLASS_DURABILITY_MULTIPLIER)))
        );
        GLASS_CHESTPLATE = register(
            "glass_chestplate",
            new ArmorItem(GlassArmorMaterials.GLASS_INGOT, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(GlassArmorMaterials.GLASS_DURABILITY_MULTIPLIER)))
        );
        GLASS_LEGGINGS = register(
            "glass_leggings",
            new ArmorItem(GlassArmorMaterials.GLASS_INGOT, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(GlassArmorMaterials.GLASS_DURABILITY_MULTIPLIER)))
        );
        GLASS_BOOTS = register(
            "glass_boots",
            new ArmorItem(GlassArmorMaterials.GLASS_INGOT, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(GlassArmorMaterials.GLASS_DURABILITY_MULTIPLIER)))
        );
    }

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> content.addBefore(Items.IRON_INGOT, GLASS_INGOT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(Items.CHAINMAIL_HELMET, GLASS_HELMET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(Items.CHAINMAIL_HELMET, GLASS_CHESTPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(Items.CHAINMAIL_HELMET, GLASS_LEGGINGS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.addBefore(Items.CHAINMAIL_HELMET, GLASS_BOOTS));
    }
}
