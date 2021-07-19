package jpabook.start

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import java.util.*


class SnakeCasePhysicalNamingStrategy : PhysicalNamingStrategyStandardImpl() {
    override fun toPhysicalCatalogName(name: Identifier?, context: JdbcEnvironment): Identifier? {
        return super.toPhysicalCatalogName(toSnakeCase(name), context)
    }

    override fun toPhysicalColumnName(name: Identifier?, context: JdbcEnvironment): Identifier? {
        return super.toPhysicalColumnName(toSnakeCase(name), context)
    }

    override fun toPhysicalSchemaName(name: Identifier?, context: JdbcEnvironment): Identifier? {
        return super.toPhysicalSchemaName(toSnakeCase(name), context)
    }

    override fun toPhysicalSequenceName(name: Identifier?, context: JdbcEnvironment): Identifier? {
        return super.toPhysicalSequenceName(toSnakeCase(name), context)
    }

    override fun toPhysicalTableName(name: Identifier?, context: JdbcEnvironment): Identifier? {
        return super.toPhysicalTableName(toSnakeCase(name), context)
    }

    private fun toSnakeCase(id: Identifier?): Identifier? {
        if (id == null) return id
        val name = id.text
        val snakeName = name.replace("([a-z]+)([A-Z]+)".toRegex(), "$1\\_$2").lowercase(Locale.getDefault())
        return if (snakeName != name) Identifier(snakeName, id.isQuoted) else id
    }
}
