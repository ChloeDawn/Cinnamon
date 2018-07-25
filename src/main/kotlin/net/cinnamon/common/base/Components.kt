@file:JvmName("Components")

package net.cinnamon.common.base

typealias Component = net.minecraft.util.text.ITextComponent
typealias BaseComponent = net.minecraft.util.text.TextComponentBase
typealias KeybindComponent = net.minecraft.util.text.TextComponentKeybind
typealias ScoreComponent = net.minecraft.util.text.TextComponentScore
typealias SelectorComponent = net.minecraft.util.text.TextComponentSelector
typealias TextComponent = net.minecraft.util.text.TextComponentString
typealias TranslatableComponent = net.minecraft.util.text.TextComponentTranslation

@JvmName("newKeybindComponent")
fun keybindComponentOf(keybind: String) =
    KeybindComponent(keybind)

@JvmName("newKeybindComponent")
fun keybindComponentOf(keybind: String, vararg siblings: Component) =
    KeybindComponent(keybind).apply { siblings.forEach { appendSibling(it) } }

@JvmName("newKeybindComponent")
fun keybindComponentOf(keybind: String, vararg siblings: String) =
    KeybindComponent(keybind).apply { siblings.forEach { appendText(it) } }

@JvmName("newScoreComponent")
fun scoreComponentOf(name: String, objective: String) =
    ScoreComponent(name, objective)

@JvmName("newScoreComponent")
fun scoreComponentOf(name: String, objective: String, vararg siblings: Component) =
    ScoreComponent(name, objective).apply { siblings.forEach { appendSibling(it) } }

@JvmName("newScoreComponent")
fun scoreComponentOf(name: String, objective: String, vararg siblings: String) =
    ScoreComponent(name, objective).apply { siblings.forEach { appendText(it) } }

@JvmName("newSelectorComponent")
fun selectorComponentOf(selector: String) =
    SelectorComponent(selector)

@JvmName("newSelectorComponent")
fun selectorComponentOf(selector: String, vararg siblings: Component) =
    SelectorComponent(selector).apply { siblings.forEach { appendSibling(it) } }

@JvmName("newSelectorComponent")
fun selectorComponentOf(selector: String, vararg siblings: String) =
    SelectorComponent(selector).apply { siblings.forEach { appendText(it) } }

@JvmName("newTextComponent")
fun textComponentOf(text: String) =
    TextComponent(text)

@JvmName("newTextComponent")
fun textComponentOf(text: String, vararg siblings: Component) =
    TextComponent(text).apply { siblings.forEach { appendSibling(it) } }

@JvmName("newTextComponent")
fun textComponentOf(text: String, vararg siblings: String) =
    TextComponent(text).apply { siblings.forEach { appendText(it) } }

@JvmName("newTranslatableComponent")
fun translatableComponentOf(key: String) =
    TranslatableComponent(key)

@JvmName("newTranslatableComponent")
fun translatableComponentOf(key: String, vararg args: Any) =
    TranslatableComponent(key, args)

@JvmName("toTranslatableComponent")
fun TextComponent.toTranslatable(vararg args: Any) =
    TranslatableComponent(text, args).also { tc ->
        tc.siblings.forEach { tc.appendSibling(it) }
        tc.style = style
    }

@JvmName("withSibling")
infix fun <T : Component> T.with(string: String): T =
    apply { appendText(string) }

@JvmName("withSibling")
infix fun <T : Component> T.with(sibling: Component): T =
    apply { appendSibling(sibling) }
