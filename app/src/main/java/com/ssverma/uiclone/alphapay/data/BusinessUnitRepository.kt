package com.ssverma.uiclone.alphapay.data

class BusinessUnitRepository {
    val iconUrl = "https://picsum.photos/id/237/150/150"

    private fun iconUrlById(id: Int): String {
        return "https://picsum.photos/id/$id/150/150"
    }

    val businessUnits = listOf(
        BusinessUnit.Bill(
            id = 1,
            name = "Vi Prepaid",
            imageUrl = iconUrlById(id = 1)
        ),
        BusinessUnit.Bill(
            id = 2,
            name = "JVVNL",
            imageUrl = iconUrlById(id = 15)
        ),
        BusinessUnit.Web(
            id = 3,
            name = "Airbnb",
            imageUrl = iconUrlById(id = 30),
            webPageUrl = "https://www.airbnb.com"
        ),
        BusinessUnit.Bill(
            id = 4,
            name = "Tata Sky",
            imageUrl = iconUrlById(id = 40)
        ),
        BusinessUnit.Payment(
            id = 5,
            name = "Flipkart",
            imageUrl = iconUrlById(id = 50)
        ),
        BusinessUnit.Payment(
            id = 6,
            name = "Swiggy",
            imageUrl = iconUrlById(id = 6)
        ),
        BusinessUnit.Web(
            id = 7,
            name = "Zomato",
            imageUrl = iconUrlById(id = 10),
            webPageUrl = "https://www.zomato.in"
        ),
        BusinessUnit.Payment(
            id = 8,
            name = "Paytm",
            imageUrl = iconUrlById(id = 8),

            ),
        BusinessUnit.Web(
            id = 9,
            name = "RedBus",
            imageUrl = iconUrlById(id = 90),
            webPageUrl = "https://www.redbus.in"
        ),
        BusinessUnit.Payment(
            id = 11,
            name = "Uber",
            imageUrl = iconUrlById(id = 11)
        )
    )
}