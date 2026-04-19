import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.assertTrue
import org.junit.Test

class ArchitectureTest {

    @Test
    fun `domain classes should not depend on Android framework`() {
        Konsist.scopeFromModule("app")
            .classes()
            .filter { it.resideInPackage("..domain..") }
            .assertTrue { it.hasNoImports { import -> import.name.startsWith("android.") } }
    }

    @Test
    fun `data classes should not depend on UI components`() {
        Konsist.scopeFromModule("app")
            .classes()
            .filter { it.resideInPackage("..data..") }
            .assertTrue {
                it.hasNoImports { import ->
                    import.name.contains("Fragment") ||
                    import.name.contains("Activity") ||
                    import.name.contains("ViewModel")
                }
            }
    }

    @Test
    fun `feature modules should not depend on each other directly`() {
        Konsist.scopeFromModule("app")
            .files
            .filter { it.resideInPackage("..feature.habits..") }
            .assertTrue {
                it.hasNoImports { import -> import.name.contains("feature.stats") }
            }
    }

    @Test
    fun `use cases should reside in domain layer`() {
        Konsist.scopeFromProject()
            .classes()
            .filter { it.name.endsWith("UseCase") }
            .assertTrue { it.resideInPackage("..domain..") }
    }

    @Test
    fun `repository interfaces should be in domain, implementations in data`() {
        Konsist.scopeFromProject().apply {
            interfaces()
                .filter { it.name.startsWith("I") && it.name.endsWith("Repository") }
                .assertTrue { it.resideInPackage("..domain..") }

            classes()
                .filter { it.name.endsWith("RepositoryImpl") }
                .assertTrue { it.resideInPackage("..data..") }
        }
    }
}
