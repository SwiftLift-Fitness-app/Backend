package online.swiftlift.swiftlift.model.entity.workout

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.entity.BaseEntity
import online.swiftlift.swiftlift.model.entity.user.UserEntity
import online.swiftlift.swiftlift.model.enum.Day

@Entity
@Table(name = "routines")
class RoutineEntity(
    @Column(name = "name") val name: String = "",
    @Column(name = "description") val description: String = "",
    @ElementCollection
    @JoinTable(
        name = "workouts_exercises",
        joinColumns = [ JoinColumn(name = "workout_id") ]
    )
    @Column(name = "exercise_id") val workouts: Map<WorkoutEntity, Day> = mutableMapOf(),
    @ManyToOne @JoinColumn(name = "user") val user: UserEntity = UserEntity()
) : BaseEntity()