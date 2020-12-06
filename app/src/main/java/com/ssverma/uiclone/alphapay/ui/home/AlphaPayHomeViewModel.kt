package com.ssverma.uiclone.alphapay.ui.home

import androidx.lifecycle.ViewModel
import com.ssverma.uiclone.alphapay.data.BusinessUnitRepository
import com.ssverma.uiclone.alphapay.data.PersonRepository
import com.ssverma.uiclone.alphapay.data.PromotionRepository

class AlphaPayHomeViewModel constructor(
    personRepository: PersonRepository = PersonRepository(),
    businessUnitRepository: BusinessUnitRepository = BusinessUnitRepository(),
    promotionRepository: PromotionRepository = PromotionRepository()
) : ViewModel() {

    val persons = personRepository.mockPersons

    val businessUnits = businessUnitRepository.businessUnits

    val promotions = promotionRepository.promotions
}