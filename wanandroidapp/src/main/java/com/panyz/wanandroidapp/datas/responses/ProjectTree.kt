package com.panyz.wanandroidapp.datas.responses

data class ProjectTree(
    val id: Int,
    val courseId: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
)