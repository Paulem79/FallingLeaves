plugins {
  `my-conventions`
  id("io.github.patrick.remapper")
}

val mcVersion = "1.21.4"

dependencies {
  implementation(project(":api"))
  compileOnly("org.spigotmc:spigot:${mcVersion}-R0.1-SNAPSHOT:remapped-mojang")
}

tasks.withType<JavaCompile>().configureEach {
  // Override release for newer MC
  options.release = 21
}

tasks.remap {
  version.set(mcVersion)
}

tasks.build {
  dependsOn(tasks.remap)
}
