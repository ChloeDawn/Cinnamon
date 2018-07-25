@file:JvmName("I18n")

package net.cinnamon.common.base

import net.cinnamon.common.reflection.findObfuscatedField
import net.cinnamon.support.fml.sidedProxy
import net.minecraft.util.text.translation.LanguageMap
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraft.client.resources.I18n as ClientI18n

private val proxy: Impl = sidedProxy({ Client }, { Server })

@JvmName("translate")
fun translateKey(key: String): String =
    proxy.translate(key)

@JvmName("translate")
fun translateKey(key: String, vararg args: Any): String =
    proxy.translate(key, *args)

@JvmName("translate")
fun translateKey(component: TranslatableComponent): String =
    proxy.translate(component)

@JvmName("hasKey")
fun hasTranslationKey(key: String): Boolean =
    proxy.hasKey(key)

@JvmName("hasKey")
fun hasTranslationKey(component: TranslatableComponent): Boolean =
    proxy.hasKey(component)

private interface Impl {
    fun translate(key: String): String

    fun translate(key: String, vararg args: Any): String

    fun hasKey(key: String): Boolean

    fun translate(component: TranslatableComponent): String =
        component.unformattedComponentText

    fun hasKey(component: TranslatableComponent): Boolean =
        translate(component) != component.key
}

@SideOnly(Side.CLIENT)
private object Client : Impl {
    override fun translate(key: String): String =
        ClientI18n.format(key)

    override fun translate(key: String, vararg args: Any): String =
        ClientI18n.format(key, args)

    override fun hasKey(key: String): Boolean =
        ClientI18n.hasKey(key)
}

@SideOnly(Side.SERVER)
private object Server : Impl {
    private val map = LanguageMap::class.findObfuscatedField("field_74817_a")[null] as LanguageMap

    override fun translate(key: String): String =
        map.translateKey(key)

    override fun translate(key: String, vararg args: Any): String =
        map.translateKeyFormat(key, args)

    override fun hasKey(key: String): Boolean =
        map.isKeyTranslated(key)
}
