package online.swiftlift.swiftlift.model.entity.workout

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.enum.PrimaryArea

@Entity
@Table(name = "workouts")
class WorkoutEntity(
    @Column(name = "name") var name: String = "",
    @ElementCollection
    @JoinTable(
        name = "workouts_exercises",
        joinColumns = [ JoinColumn(name = "workout_id") ]
    )
    @Column(name = "exercise_id")
    var exercises: Map<ExerciseEntity, String> = mutableMapOf(),
    @Column(name = "primary_area") @Enumerated(EnumType.STRING) var primaryArea: PrimaryArea = PrimaryArea.CORE
) : BaseEntity()