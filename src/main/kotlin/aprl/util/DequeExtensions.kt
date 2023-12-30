package aprl.util

import java.util.*

fun <T> Deque<T>.lastButNotFirst(): T {
    if (size <= 1) {
        throw NoSuchElementException("Last and first element are equal for deque of length $size")
    }
    return last
}

fun <T> Deque<T>.lastButNotFirstOrNull(): T? {
    if (size <= 1) {
        return null
    }
    return last
}

fun <T> Deque<T>.previousToLast(): T {
    if (size <= 1) {
        throw NoSuchElementException("No previous to last element for deque of length $size")
    }
    return elementAt(size - 2)
}
