package de.byteroyal.utils;

import de.byteroyal.itembuilder.ItemBuilder;
import org.bukkit.inventory.ItemStack;

public enum Block2Color {
    STAINED_CLAY_15("§0"),
    STAINED_CLAY_11("§1"),
    STAINED_CLAY_13("§2"),
    WOOL_9("§3"),
    STAINED_CLAY_14("§4"),
    STAINED_CLAY_10("§5"),
    STAINED_CLAY_1("§6"),
    WOOL_8("§7"),
    WOOL_7("§8"),
    STAINED_CLAY_3("§9"),
    STAINED_CLAY_5("§a"),
    WOOL_3("§b"),
    STAINED_CLAY_6("§c"),
    STAINED_CLAY_2("§d"),
    STAINED_CLAY_4("§e"),
    STAINED_CLAY_0("§f");
    private String code;
    Block2Color(String code) {
        this.code = code;

    }

    public String getCode() {
        return code;
    }
}
