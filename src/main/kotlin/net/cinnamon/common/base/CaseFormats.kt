@file:JvmName("CaseFormats")

package net.cinnamon.common.base

import com.google.common.base.CaseFormat
import java.util.Locale

private const val UPPER         = "(\\p{Upper})"
private const val LOWER         = "(\\p{Lower})"
private const val CHAR          = "(\\p{ASCII})"
private const val NO_UPPER      = "(?!.*$UPPER)"
private const val NO_LOWER      = "(?!.*$LOWER)"
private const val NO_HYPHEN     = "(?!.*-)"
private const val NO_UNDERSCORE = "(?!.*_)"
private const val NON_EMPTY     = "(?=^$CHAR+$)"
private const val CHARS         = "($CHAR*)"

private val LOWER_HYPHEN_MATCHER     = (NON_EMPTY            + NO_UPPER + NO_UNDERSCORE                             + CHARS).toRegex()
private val LOWER_UNDERSCORE_MATCHER = (NON_EMPTY            + NO_UPPER                 + NO_HYPHEN                 + CHARS).toRegex()
private val UPPER_UNDERSCORE_MATCHER = (NON_EMPTY + NO_LOWER                            + NO_HYPHEN                 + CHARS).toRegex()
private val LOWER_CAMEL_MATCHER      = (NON_EMPTY                       + NO_UNDERSCORE + NO_HYPHEN + LOWER         + CHARS).toRegex()
private val UPPER_CAMEL_MATCHER      = (NON_EMPTY                       + NO_UNDERSCORE + NO_HYPHEN         + UPPER + CHARS).toRegex()

val String.caseFormat
    get() = when {
        isLowerHyphen()     -> CaseFormat.LOWER_HYPHEN
        isLowerUnderscore() -> CaseFormat.LOWER_UNDERSCORE
        isUpperUnderscore() -> CaseFormat.UPPER_UNDERSCORE
        isLowerCamel()      -> CaseFormat.LOWER_CAMEL
        isUpperCamel()      -> CaseFormat.UPPER_CAMEL
        else -> error("Unable to determine CaseFormat for String \"$this\"")
    }

fun String.toCaseFormat(format: CaseFormat): String = caseFormat.to(format, this)

fun String.isLowerHyphen()     = matches(LOWER_HYPHEN_MATCHER)
fun String.isLowerUnderscore() = matches(LOWER_UNDERSCORE_MATCHER)
fun String.isUpperUnderscore() = matches(UPPER_UNDERSCORE_MATCHER)
fun String.isLowerCamel()      = matches(LOWER_CAMEL_MATCHER)
fun String.isUpperCamel()      = matches(UPPER_CAMEL_MATCHER)

fun String.toLowerHyphen()     = toCaseFormat(CaseFormat.LOWER_HYPHEN)
fun String.toLowerUnderscore() = toCaseFormat(CaseFormat.LOWER_UNDERSCORE)
fun String.toUpperUnderscore() = toCaseFormat(CaseFormat.UPPER_UNDERSCORE)
fun String.toLowerCamel()      = toCaseFormat(CaseFormat.LOWER_CAMEL)
fun String.toUpperCamel()      = toCaseFormat(CaseFormat.UPPER_CAMEL)

fun String.toRootLowerCase() = toLowerCase(Locale.ROOT)
fun String.toRootUpperCase() = toUpperCase(Locale.ROOT)
