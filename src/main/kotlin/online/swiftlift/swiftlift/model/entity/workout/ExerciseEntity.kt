package online.swiftlift.swiftlift.model.entity.workout

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import online.swiftlift.swiftlift.model.entity.BaseEntity
import java.time.LocalDateTime

@Entity
@Table(name = "exercises")
class ExerciseEntity(
    @Column(name = "name") val name: String = "",
    @Column(name = "description") val description: String = "",
    @Column(name = "created") val created: LocalDateTime = LocalDateTime.now(),
) : BaseEntity()