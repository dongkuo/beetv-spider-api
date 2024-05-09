package com.github.beetv.spider

interface Spider {

    suspend fun listCategory(): List<Category>

    suspend fun pageMediaByCategory(
        categoryId: String,
        pageNum: Long,
        pageSize: Long
    ): Page<SimpleMedia>

    suspend fun pageMediaByTopN(pageNum: Long, pageSize: Long): Page<SimpleMedia>

    suspend fun listHotSearchKeyword(): List<String>

    suspend fun pageMediaBySearch(keyword: String, pageNum: Long, pageSize: Long): Page<SimpleMedia>

    suspend fun getMediaById(mediaId: String): Media?
}

data class Category(
    val id: String,
    val name: String,
    val attachment: String? = null
)

data class SimpleMedia(
    val id: String,
    val name: String,
    val cover: String,
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

data class Source(
    val name: String,
    val url: String
)

data class Page<out T>(
    val items: List<T>,
    val total: Long,
)