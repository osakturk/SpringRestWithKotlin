package com.example.kotlin.model

import com.example.kotlin.util.StringUtils
import lombok.NoArgsConstructor
import org.codehaus.jackson.map.annotate.JsonSerialize
import java.lang.reflect.Array.get
import java.util.*
import javax.persistence.*
import kotlin.random.Random

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity
@Table(name = "users")
@NoArgsConstructor
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID", unique = true, nullable = false, length = 45)
        val id: Long? = null,
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "CREATE_DATE", nullable = false)
        val createDate: Date = Date(),
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "UPDATE_DATE", nullable = false)
        val updateDate: Date = Date(),
        @Column(name = "full_name", nullable = false)
        val fullName: String? = null,
        @Column(name = "email", nullable = false)
        val email: String? = null,
        @Column(name = "password", nullable = false)
        val password: String? = null,
        @Column(name = "token", nullable = false)
        val token: String? = StringUtils.getRandomString(60)
) : BaseObject()