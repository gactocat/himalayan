package entity

data class Movie(
        var id: Long,
        var title: String,
        var isLive: Boolean,
        var onairStatus: OnairStatus
)
