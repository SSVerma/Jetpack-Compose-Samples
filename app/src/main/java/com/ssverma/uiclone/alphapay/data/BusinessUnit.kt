package com.ssverma.uiclone.alphapay.data

sealed class BusinessUnit(
    open val id: Int,
    open val name: String,
    open val imageUrl: String
) {
    data class Payment(
        override val id: Int,
        override val name: String,
        override val imageUrl: String
    ) : BusinessUnit(id = id, name = name, imageUrl = imageUrl)

    data class Bill(
        override val id: Int,
        override val name: String,
        override val imageUrl: String
    ) : BusinessUnit(id = id, name = name, imageUrl = imageUrl)

    data class Web(
        override val id: Int,
        override val name: String,
        override val imageUrl: String,
        val webPageUrl: String
    ) : BusinessUnit(id = id, name = name, imageUrl = imageUrl)
}