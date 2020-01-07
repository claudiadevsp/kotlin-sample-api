package kotlin2.apirest.entities

import java.time.Instant
import javax.persistence.*

@Entity
class Todo(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
           val id: Long = 0, var text: String, var done:Boolean = false, val createdAt: Instant = Instant.now())