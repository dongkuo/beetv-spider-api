package com.github.beetv.spider

interface Spider {

    suspend fun fetchHotSearchKeyword(): List<String>

    suspend fun fetchCategory(): List<Category>

    suspend fun fetchCategoryWithMedia(): List<CategoryWithSimpleMedia>

    suspend fun fetchMediaByCategory(
        categoryId: String,
        pageNum: Long,
        pageSize: Long
    ): Page<SimpleMedia>

    suspend fun fetchMediaByTopN(pageNum: Long, pageSize: Long): List<SimpleMedia>

    suspend fun fetchMediaById(mediaId: String): Media?

    suspend fun searchMedia(keyword: String, pageNum: Long, pageSize: Long): Page<SimpleMedia>
}

data class Category(
    val id: String,
    val name: String,
)

data class SimpleMedia(
    val id: String,
    val name: String,
    val cover: String,
    val desc: String,
)

data class Media(
    val id: String,
    val name: String,
    val cover: String,
    val summary: String,
    val category: Category?,
    val releaseYear: Int?,
    val originCountry: String?,
    val sources: List<Source>
)

data class CategoryWithSimpleMedia(
    val category: Category,
    val medias: List<SimpleMedia>
)

data class Source(
    val name: String,
    val url: String
)

data class Page<out T>(
    val items: List<T>,
    val total: Long,
)