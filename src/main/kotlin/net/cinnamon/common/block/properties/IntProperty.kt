package net.cinnamon.common.block.properties

import net.minecraft.block.properties.PropertyInteger

// TODO FastUtil IntSet?
class IntProperty(name: String, min: Int, max: Int) : PropertyInteger(name, min, max)
