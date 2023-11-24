package aprl.util

/**
 * Returns the next largest integer if the list is complete (i.e. every n < max(list) has an m > n)
 * or the first missing element if it is not.
 *
 * listOf(1,2,3,4,5).nextOrMissing() == 6
 * listOf(2,3).nextOrMissing() == 1
 * listOf(4,6,7).nextOrMissing(first=4) == 5
 */
fun List<Int>.nextOrMissing(first: Int = 1): Int {
    val max = maxOrNull() ?: return first // Empty list => first missing element is 1
    for (i in first..<max) {
        if (i !in this) {
            // First missing element
            return i
        }
    }
    // If every integer in `i..<max` is present, return next largest integer
    return max + 1
}
