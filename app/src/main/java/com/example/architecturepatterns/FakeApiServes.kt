package com.example.architecturepatterns

import com.example.architecturepatterns.model.wisdom

class FakeApiServes {
    private val wisdomList = listOf<wisdom>(
        wisdom(
            "The more I learn, the more I realize how much I don't know.  — Albert Einstein",
            "25-5-2002"
        ),
        wisdom(
            "Life is a balance of holding on and letting go.   — Rumi",
            "5-1-1993"
        ),
        wisdom(
            "Time is the most valuable thing a man can spend.  — Theophrastus",
            "2-9-1643"
        ),
        wisdom(
            "The oak fought the wind and was broken, the willow bent when it must and survived.  — Robert Jordan",
            "23-6-2345"
        ),
    )

    // To Get Wisdom List Randomly
    fun getWisdomRandom(): wisdom {
        val randoms = (Math.random() * wisdomList.size).toInt()
        return wisdomList[randoms]
    }

}