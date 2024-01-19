package online.swiftlift.swiftlift.service

import online.swiftlift.swiftlift.model.dto.exercise.PrimaryAreaDTO
import online.swiftlift.swiftlift.model.enum.PrimaryArea

interface PrimaryAreaService {

    fun addPrimaryArea(primaryArea: PrimaryArea): PrimaryAreaDTO

    fun getPrimaryArea(primaryArea: PrimaryArea): PrimaryAreaDTO

    fun getAllPrimaryAreas(): Set<PrimaryAreaDTO>

    fun isEmpty(): Boolean
}