package exercise.simple

import com.practice.examples.exercise.simple.primeNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PrimeNumberTest {

    @Test
    fun `test prime number`() {
        assertTrue(primeNumber(3),"3 is the prime number")
        assertFalse(primeNumber(4),"4 is not prime number")

        assertAll("Group assertion", {
            assertTrue(primeNumber(5))
            assertFalse(primeNumber(6))
            assertEquals(true, primeNumber(13))
        })
    }
}