rootProject.name = "headquarters-connector"

fun findAndRename(project: String, newName: String) {
    include(project)
    findProject(project)?.name = newName
}

findAndRename("connector-api", "headquarters-connector-core")