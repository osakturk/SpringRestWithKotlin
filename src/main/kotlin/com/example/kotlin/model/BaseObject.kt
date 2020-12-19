package com.example.kotlin.model

import java.io.Serializable
import java.util.*
import javax.persistence.*

@MappedSuperclass
open class BaseObject: Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, length = 45)
    private val id: Long? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false)
    private val createDate = Date()

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DATE", nullable = false)
    private val updateDate = Date()
}