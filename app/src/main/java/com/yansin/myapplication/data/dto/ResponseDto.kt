package com.yansin.myapplication.data.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep
import com.yansin.myapplication.domain.model.Article

@Keep
@JsonClass(generateAdapter = true)
data class ResponseDto(
    @Json(name = "copyright")
    val copyright: String?,
    @Json(name = "num_results")
    val numResults: Int?,
    @Json(name = "results")
    val results: List<Result>?,
    @Json(name = "status")
    val status: String?
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Result(
        @Json(name = "abstract")
        val abstract: String?,
        @Json(name = "adx_keywords")
        val adxKeywords: String?,
        @Json(name = "asset_id")
        val assetId: String?,
        @Json(name = "byline")
        val byline: String?,
        @Json(name = "column")
        val column: String?,
        @Json(name = "des_facet")
        val desFacet: List<String>?,
        @Json(name = "eta_id")
        val etaId: Int?,
        @Json(name = "geo_facet")
        val geoFacet: List<String>?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "media")
        val media: List<Media>?,
        @Json(name = "nytdsection")
        val nytdsection: String?,
        @Json(name = "org_facet")
        val orgFacet: List<String>?,
        @Json(name = "per_facet")
        val perFacet: List<String>?,
        @Json(name = "published_date")
        val publishedDate: String?,
        @Json(name = "section")
        val section: String?,
        @Json(name = "source")
        val source: String?,
        @Json(name = "subsection")
        val subsection: String?,
        @Json(name = "title")
        val title: String?,
        @Json(name = "type")
        val type: String?,
        @Json(name = "updated")
        val updated: String?,
        @Json(name = "uri")
        val uri: String?,
        @Json(name = "url")
        val url: String?
    ) {


        @Keep
        @JsonClass(generateAdapter = true)
        data class Media(
            @Json(name = "approved_for_syndication")
            val approvedForSyndication: Int?,
            @Json(name = "caption")
            val caption: String?,
            @Json(name = "copyright")
            val copyright: String?,
            @Json(name = "media-metadata")
            val mediaMetadata: List<MediaMetadata>?,
            @Json(name = "subtype")
            val subtype: String?,
            @Json(name = "type")
            val type: String?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class MediaMetadata(
                @Json(name = "format")
                val format: String?,
                @Json(name = "height")
                val height: Int?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "width")
                val width: Int?
            )
        }

        fun toArticle(): Article {
            return Article(
                title = title ?: "",
                byLine = byline ?: "",
                publishedDate = publishedDate ?: "",
                id = id ?: "",
                abstract = abstract ?: "",
                image = media?.firstOrNull()?.mediaMetadata?.lastOrNull()?.url ?: "",
                section = section ?: ""
            )
        }
    }
}