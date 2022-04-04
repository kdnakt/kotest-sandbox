package kotest.sandbox.config

import io.kotest.core.config.AbstractProjectConfig
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class ProjectConfig: AbstractProjectConfig() {
//    override val projectTimeout = 10.seconds
    override val projectTimeout = 1.minutes
}