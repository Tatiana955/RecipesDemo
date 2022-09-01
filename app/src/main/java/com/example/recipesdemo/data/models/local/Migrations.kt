package com.example.recipesdemo.data.models.local

import io.realm.migration.AutomaticSchemaMigration

object Migrations {
    const val SCHEMA_VERSION = 1L

    val MIGRATION = AutomaticSchemaMigration {
        it.enumerate(
            className = "RecipeRealm",
            block = { _, newObject ->
                newObject?.run {
                    set(
                        propertyName = "labelForSearch",
                        value = String()
                    )
                    set(
                        propertyName = "primaryKey",
                        value = String()
                    )
                }
            }
        )
    }
}