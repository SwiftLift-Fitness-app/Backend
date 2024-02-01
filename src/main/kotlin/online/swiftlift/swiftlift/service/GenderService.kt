package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.user.GenderDTO
import online.swiftlift.swiftlift.model.enum.GenderType

interface GenderService {

    fun addGender(gender: GenderType)

    fun findGender(gender: GenderType): GenderDTO

    fun isEmpty(): Boolean

}