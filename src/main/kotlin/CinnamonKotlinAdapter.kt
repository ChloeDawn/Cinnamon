import net.minecraftforge.fml.common.FMLModContainer
import net.minecraftforge.fml.common.ILanguageAdapter
import net.minecraftforge.fml.common.ModContainer
import net.minecraftforge.fml.relauncher.Side
import java.lang.reflect.Field
import java.lang.reflect.Method

class CinnamonKotlinAdapter : ILanguageAdapter {
    override fun supportsStatics() = false

    override fun getNewInstance(mod: FMLModContainer, clazz: Class<*>, loader: ClassLoader, factory: Method?): Any =
        factory?.invoke(null) ?: clazz.run { kotlin.objectInstance ?: newInstance() }

    override fun setProxy(field: Field, target: Class<*>, proxy: Any) = Unit

    override fun setInternalProxies(mod: ModContainer, side: Side, loader: ClassLoader) = Unit
}
