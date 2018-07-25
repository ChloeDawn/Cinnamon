package net.cinnamon.common.base

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

open class ItemGroup @JvmOverloads constructor(
    val label: String = ModContainers.activeModId,
    val showLabel: Boolean = true,
    val hasSearchBar: Boolean = false,
    private val icon: () -> ItemStack
) : CreativeTabs("") {
    @SideOnly(Side.CLIENT)
    override fun getTranslatedTabLabel() = "item_group.$label.label"

    @SideOnly(Side.CLIENT)
    override fun getTabIconItem() = icon()

    @SideOnly(Side.CLIENT)
    override fun getBackgroundImageName() = when {
        hasSearchBar -> "item_search.png"
        else -> "items.png"
    }

    @SideOnly(Side.CLIENT)
    override fun drawInForegroundOfTab() = showLabel

    override fun hasSearchBar() = hasSearchBar
}
