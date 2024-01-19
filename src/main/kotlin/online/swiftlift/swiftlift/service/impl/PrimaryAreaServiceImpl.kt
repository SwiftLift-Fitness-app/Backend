package online.swiftlift.swiftlift.service.impl

import online.swiftlift.swiftlift.exception.PrimaryAreaNotFoundException
import online.swiftlift.swiftlift.model.dto.exercise.PrimaryAreaDTO
import online.swiftlift.swiftlift.model.entity.workout.PrimaryAreaEntity
import online.swiftlift.swiftlift.model.enum.PrimaryArea
import online.swiftlift.swiftlift.repository.PrimaryAreaRepository
import online.swiftlift.swiftlift.service.PrimaryAreaService
import org.springframework.stereotype.Service

@Service
class PrimaryAreaServiceImpl(private val primaryAreaRepository: PrimaryAreaRepository) : PrimaryAreaService {
    override fun addPrimaryArea(primaryArea: PrimaryArea): PrimaryAreaDTO =
        mapToDTO(
            primaryAreaRepository
                .save(PrimaryAreaEntity(primaryArea))
        )

    override fun getPrimaryArea(primaryArea: PrimaryArea): PrimaryAreaDTO =
        mapToDTO(
            primaryAreaRepository
                .findByName(primaryArea)
                .orElseThrow { PrimaryAreaNotFoundException(primaryArea.name) }
        )

    override fun getAllPrimaryAreas(): Set<PrimaryAreaDTO> =
        primaryAreaRepository
            .findAll()
            .map { mapToDTO(it) }
            .toSet()

    override fun isEmpty(): Boolean =
        primaryAreaRepository.count() == 0L

    private fun mapToDTO(primaryAreaEntity: PrimaryAreaEntity) =
        PrimaryAreaDTO(primaryAreaEntity.name.name)
}