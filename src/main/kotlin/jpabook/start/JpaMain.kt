package jpabook.start

import javax.persistence.EntityManager
import javax.persistence.Persistence

fun main() {
    val emf = Persistence.createEntityManagerFactory("jpabook")
    val em = emf.createEntityManager()
    val tx = em.transaction

    try {
        tx.begin()
        logic(em)
        tx.commit()
    } catch (e: Exception) {
        println(e)
        tx.rollback()
    } finally {
        em.close()
    }
    emf.close()
}

private fun logic(em: EntityManager) {
    val member = Member(id = "user2", username = "지한", age = 2)

    em.persist(member)
    member.age = 20

    val findMember = em.find(Member::class.java, member.id)
    println("""findMember=${findMember.username} age=${findMember.age}""")
}

