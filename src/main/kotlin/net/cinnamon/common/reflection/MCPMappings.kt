package net.cinnamon.common.reflection

import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper

object MCPMappings {
    @JvmStatic val mapper: FMLDeobfuscatingRemapper
        get() = FMLDeobfuscatingRemapper.INSTANCE

    @JvmStatic val fieldPattern = "^field_\\d*_\\w*\$".toRegex()
    @JvmStatic val methodPattern = "^func_\\d*_\\w*\$".toRegex()

    @JvmStatic
    fun mapFieldName(declaringClassName: String, fieldName: String): String {
        require(declaringClassName.isNotEmpty()) { "Declaring class name cannot be empty" }
        require(fieldName matches fieldPattern) {
            "Field name \"$fieldName\" does not match pattern ${methodPattern.pattern}"
        }
        return mapper.mapFieldName(mapper.unmap(declaringClassName.replace('.', '/')), fieldName, null)
    }

    @JvmStatic
    fun mapFieldName(declaringClass: Class<*>, fieldName: String) =
        this.mapFieldName(declaringClass.name, fieldName)

    @JvmStatic
    fun mapMethodName(declaringClassName: String, methodName: String): String {
        require(declaringClassName.isNotEmpty()) { "Declaring class name cannot be empty" }
        require(methodName matches methodPattern) {
            "Method name \"$methodName\" does not match pattern ${methodPattern.pattern}"
        }
        return mapper.mapMethodName(mapper.unmap(declaringClassName.replace('.', '/')), methodName, null)
    }

    @JvmStatic
    fun mapMethodName(declaringClass: Class<*>, methodName: String) =
        this.mapMethodName(declaringClass.name, methodName)
}
