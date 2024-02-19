package online.swiftlift.swiftlift.model.entity

import jakarta.persistence.*
import online.swiftlift.swiftlift.model.enum.Day

@Entity
@Table(name = "days")
class DayEntity(
    @Column(name = "name") @Enumerated(EnumType.STRING) val name: Day = Day.Day1
): BaseEntity()