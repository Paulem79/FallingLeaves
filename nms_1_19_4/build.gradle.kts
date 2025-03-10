plugins {
  `my-conventions`
  id("io.github.patrick.remapper")
}

val mcVersion = "1.19.4"

dependencies {
  implementation(project(":api"))
  compileOnly("org.spigotmc:spigot:${mcVersion}-R0.1-SNAPSHOT:remapped-mojang")
}

tasks.remap {
  version.set(mcVersion)
}

tasks.build {
  dependsOn(tasks.remap)
}
