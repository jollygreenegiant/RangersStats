import com.google.gson.annotations.SerializedName
import com.jggdevelopment.rangersstats.model.Name

data class Team(
    var id: Int,
    var placeName: Name,
    var abbrev: String,
    var logo: String
)
