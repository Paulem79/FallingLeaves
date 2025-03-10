import xyz.jpenilla.resourcefactory.bukkit.BukkitPluginYaml

plugins {
  `my-conventions`
  id("io.github.patrick.remapper") version "1.+" apply false
  id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.2.0" // Generates plugin.yml based on the Gradle config
  id("com.gradleup.shadow") version "8.3.5"
}

allprojects {
  repositories {
    mavenLocal()
    mavenCentral()

    maven { url = uri("https://jitpack.io") }
    maven {
      url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

      content {
        includeGroup("org.bukkit")
        includeGroup("org.spigotmc")
      }
    }

    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/central") }
  }
}

java.disableAutoTargetJvm() // Allow consuming JVM 21 projects (i.e. paper_1_21_4) even though our release is 17

dependencies {
  compileOnly("org.spigotmc:spigot-api:1.19.4-R0.1-SNAPSHOT")

  implementation(project(":api"))
  runtimeOnly(project(":nms_1_19_4"))
  runtimeOnly(project(":nms_1_21_4"))
}

tasks.assemble {
  dependsOn(tasks.shadowJar)
}

// Configure plugin.yml generation
// - name, version, and description are inherited from the Gradle project.
bukkitPluginYaml {
  main = "ovh.paulem.fallingleaves.FallingLeaves"
  load = BukkitPluginYaml.PluginLoadOrder.STARTUP
  authors.add("Author")
  apiVersion = "1.19"
}
