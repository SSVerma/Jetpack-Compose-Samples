package com.ssverma.uiclone.alphanews.data

class NewsRepository {
    val mockNews = listOf(
        News(
            id = 1,
            title = "Elon Musk says Tesla’s Chinese rival ‘stole’ Apple’s code",
            imageUrl = "https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2020/11/22/Pictures/_0701428e-2c8b-11eb-a1f1-9949958d68df.jpg",
            label = "Headlines",
            timestamp = "16 minutes ago",
            newsProviderLogo = "https://logodix.com/logo/1113851.jpg",
            isFullCoverageAvailable = true
        ),
        News(
            id = 2,
            title = "India exceeding Paris agreement targets: PM Modi at G20 summit",
            imageUrl = "https://images.livemint.com/img/2020/11/21/600x338/20201121234L_1605983429106_1605983439651.jpg",
            label = null,
            timestamp = "Today",
            newsProviderLogo = "https://iks.timesnownews.com/s/v1/img/logo/c_tnlogo.png",
            isFullCoverageAvailable = false
        ),
        News(
            id = 3,
            title = "Flashback: Nokia N97 was an \"iPhone killer\" that helped kill Nokia instead",
            imageUrl = "https://fdn.gsmarena.com/imgroot/news/20/11/flashback-nokia-n97/inline/-1200w5/gsmarena_001.jpg",
            label = "For you",
            timestamp = "2 days ago",
            newsProviderLogo = "https://static.wikia.nocookie.net/logopedia/images/8/87/Cropped-gsm-arena.png/revision/latest/scale-to-width-down/400?cb=20190222021019",
            isFullCoverageAvailable = true
        ),
        News(
            id = 4,
            title = "When Will Oxford Vaccine, India's Big Hope, Be Available? Details Here",
            imageUrl = "https://c.ndtvimg.com/2020-10/ge5e1i3c_coronavirus-vaccination-oxford-university-uk-covid19_625x300_03_October_20.jpg",
            label = "For you",
            timestamp = "2 days ago",
            newsProviderLogo = "https://logodix.com/logo/2131910.png",
            isFullCoverageAvailable = true
        ),
        News(
            id = 5,
            title = "Google is testing ‘Task Mate’ in India, which lets users earn money for doing tasks on their smartphones",
            imageUrl = "https://www.businessinsider.in/photo/79362294/Master.jpg",
            label = "For you",
            timestamp = "2 hours ago",
            newsProviderLogo = "https://media.insider.com/public/assets/BI/US/logos/logos-page/BI_light_background_color_horizontal.png",
            isFullCoverageAvailable = true
        )
    )
}