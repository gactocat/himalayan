package entity

enum class OnairStatus(val rawValue: Int)  {
    BEFORE(0),
    IN_LIVE(1),
    AFTER(2),
}
