package chess

fun Int.toReadbleChar(): Char {
    return ('0'.code + this).toChar()
}

fun Array<String>.removeElement(element: String): Array<String> {
    return this
        .filter {it != element}
        .map {it.toString()}
        .toTypedArray()
}