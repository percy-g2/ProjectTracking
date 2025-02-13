package com.mumbicodes.projectie.domain.use_case.projects

import com.mumbicodes.projectie.domain.model.Project
import com.mumbicodes.projectie.domain.repository.ProjectsRepository
import com.mumbicodes.projectie.domain.util.OrderType
import com.mumbicodes.projectie.domain.util.ProjectsOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetProjectsUseCase(
    private val repository: ProjectsRepository,
) {
    /**
     * Added logic to get projects and sort the projects
     *
     * By default, the order is the date added
     * */
    operator fun invoke(
        projectOrder: ProjectsOrder = ProjectsOrder.DateAdded(OrderType.Descending),
    ): Flow<List<Project>> {

        return repository.getAllProjects()
            .map { projects ->
                when (projectOrder.orderType) {
                    is OrderType.Ascending -> {
                        when (projectOrder) {
                            is ProjectsOrder.Name -> projects.sortedBy { it.projectName.lowercase() }
                            is ProjectsOrder.Deadline -> projects.sortedBy { it.projectDeadline }
                            is ProjectsOrder.DateAdded -> projects.sortedBy { it.timeStamp }
                        }
                    }
                    is OrderType.Descending -> {
                        when (projectOrder) {
                            is ProjectsOrder.Name -> projects.sortedByDescending { it.projectName.lowercase() }
                            is ProjectsOrder.Deadline -> projects.sortedByDescending { it.projectDeadline }
                            is ProjectsOrder.DateAdded -> projects.sortedByDescending { it.timeStamp }
                        }
                    }
                }
            }
    }
}
