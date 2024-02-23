package online.swiftlift.swiftlift.model.entity.workout

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.Equipment
import online.swiftlift.swiftlift.model.enum.PrimaryArea
import java.time.LocalDateTime

@Entity
@Table(name = "exercises")
class ExerciseEntity(
    @Column(name = "name") val name: String = "",
    @Column(name = "description") var description: String = "",
    @Column(name = "area") @Enumerated(EnumType.STRING) var area: PrimaryArea = PrimaryArea.CORE,
    @Column(name = "equipment") @Enumerated(EnumType.STRING) var equipment: Equipment = Equipment.NONE,
) : BaseEntity()