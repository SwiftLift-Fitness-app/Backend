package online.swiftlift.swiftlift.model.entity

import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.*

@MappedSuperclass
open class BaseEntity(
    @Id val id: UUID
) {
    constructor() : this(UUID.randomUUID())
}