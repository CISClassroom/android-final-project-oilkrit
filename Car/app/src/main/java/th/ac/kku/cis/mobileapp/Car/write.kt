package th.ac.kku.cis.mobileapp.Car


class cartype(var nametype:String)
class write {
    companion object Factory {
        fun create(): write = write()
    }

    var CommentId: String? = null
    var Comment: String? = null
    var Nametype: String? = null

}