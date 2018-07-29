package net.cinnamon.common.nbt

import net.minecraft.nbt.NBTBase

class UnsupportedTagTypeException(type: String, caller: String) : Exception("$type from \"$caller\"")

class UnsupportedTagIdException(id: Int, nbt: NBTBase) : Exception("$id from $nbt")
