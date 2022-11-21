import kotlin.js.JsExport

@JsExport
data class Foo(val basic: String) {
    // This becomes this.c_1 with the set/get logic in Prototype.e and  Prototype.f function and a defineProperty reffering to them
    var custom: Int = 0
        get() {
            return field.takeIf { it % 2 == 0 } ?: (field + 1)
        }

    // The logic goes in a Foo.Prototype.g function and a defineProperty refers to it with get
    val computed: Int
        get() = basic.length

    // unobfuscated property
    var inClass: Int = 4
}