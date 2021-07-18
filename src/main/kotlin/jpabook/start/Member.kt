package jpabook.start

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "MEMBERS")
data class Member(
    @Id
    @Column
    var id: String? = null,
    @Column(name = "NAME")
    var username: String = "",
    var age: Int? = null
)

