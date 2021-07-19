package jpabook.start

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "members")
data class Member(
    @Column(name = "name")
    var username: String = "",

    var age: Int? = null,

    @Enumerated(EnumType.STRING)
    var roleType: RoleType = RoleType.USER,

    @Lob
    var description: String? = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var createdDate: OffsetDateTime = OffsetDateTime.now()

    var lastModifiedDate: OffsetDateTime = OffsetDateTime.now()
}

enum class RoleType {
    ADMIN,
    USER
}
