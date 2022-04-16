package de.byteroyal.itembuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class ItemBuilder {
    private Material material;
    private String name;
    private int count;
    private int subid;
    private Enchantment enchantment;
    private int level;
    private List<String> lore;

    public ItemBuilder(Material material, int count) {
        this.material = material;
        this.count = count;
        this.lore = new ArrayList<>();
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(this.material, this.count, (short) this.subid);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(this.lore);
        itemMeta.setDisplayName(this.name);
        if(enchantment != null){
            itemMeta.addEnchant(enchantment,level,true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }
    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        this.enchantment = enchantment;
        this.level = level;
        return this;
    }

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setCount(int count) {
        this.count = count;
        return this;
    }

    public ItemBuilder setSubid(int subid) {
        this.subid = subid;
        return this;
    }
    public ItemBuilder addLore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        return this;
    }
}
